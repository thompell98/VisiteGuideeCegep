using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Google.Cloud.Firestore;
using Google.Cloud.Storage.V1;
using System.IO;

namespace gestionAdminVisiteGuidee
{
    public partial class GestionFichiers : Form
    {
        string bucketName = "visiteguideecegep-f394b.appspot.com";
        FirestoreDb db = FirestoreDb.Create("visiteguideecegep-f394b");
        string numeroDuLocal = Modifier.numero;

        public GestionFichiers()
        {
            InitializeComponent();
            LireFichiersFirestore(numeroDuLocal);
        }

        private void AjouterFichierCache(string path, string nomDuFichier)
        {
            CreerDossierCacheExiste();
            string sourceFile = System.IO.Path.Combine(path, nomDuFichier);
            string destFile = System.IO.Path.Combine("C:\\fichiersCache", nomDuFichier);
            System.IO.File.Copy(sourceFile, destFile, true);
        }

        private void UploaderFichierFirestore(string path, string nomDuFichier)
        {
            string objectName = null;
            var storage = StorageClient.Create();
            using (var f = File.OpenRead(path + "\\" + nomDuFichier))
            {
                objectName = objectName ?? Path.GetFileName(path + "\\" + nomDuFichier);
                storage.UploadObject(bucketName, numeroDuLocal + "/" + objectName, null, f);
            }
            DocumentReference leLocalReference = ObtenirLocal(numeroDuLocal, "Aile " + numeroDuLocal[0].ToString(), "Étage " + numeroDuLocal[2].ToString()).Reference;
            leLocalReference.UpdateAsync("Fichiers", FieldValue.ArrayUnion(nomDuFichier));
        }

        private DocumentSnapshot ObtenirLocal(string numero, string aileDuLocal, string etageDuLocal)
        {
            Task<DocumentSnapshot> taskLocal = Task.Run<DocumentSnapshot>(async () => await TrouverLocalBD(numero, aileDuLocal, etageDuLocal));
            taskLocal.Wait();
            return taskLocal.Result;
        }

        private async Task<DocumentSnapshot> TrouverLocalBD(string numero, string aileDuLocal, string etageDuLocal)
        {
            DocumentSnapshot leLocal = null;
            CollectionReference reference = db.Collection("Étages").Document(etageDuLocal).Collection("Ailes").Document(aileDuLocal).Collection("Locaux");
            QuerySnapshot locauxSnapshot = await reference.GetSnapshotAsync();
            foreach (DocumentSnapshot local in locauxSnapshot.Documents)
            {
                Dictionary<string, object> documentDictionary = local.ToDictionary();
                if (documentDictionary["Numero"].ToString() == numero)
                {
                    leLocal = local;
                }
            }
            return leLocal;
        }

        private void LireFichiersFirestore(string numeroLocal)
        {
            var client = StorageClient.Create();
            StorageClient storageClient = StorageClient.Create();
            foreach (var obj in client.ListObjects(bucketName, numeroLocal))
            {
                if (obj.Name != numeroLocal + "/")
                {
                    listBoxFichiersLocal.Items.Add(obj.Name);
                }
            }
        }

        private void AfficherImage(string nomDuFichier)
        {
            mediaPlayer.Visible = false;
            mediaPlayer.Ctlcontrols.stop();
            pictureBoxPreview.Visible = true;
            if (!File.Exists("C:\\fichiersCache\\" + nomDuFichier))
            {
                TelechargerFichierFirestore("C:\\fichiersCache", nomDuFichier);
            }
            Image img;
            using (var bmpTemp = new Bitmap("C:\\fichiersCache\\" + nomDuFichier))
            {
                img = new Bitmap(bmpTemp);
            }
            pictureBoxPreview.Image = img;
        }

        private void AfficherVideo(string nomDuFichier)
        {
            pictureBoxPreview.Visible = false;
            mediaPlayer.Visible = true;
            if (!File.Exists("C:\\fichiersCache\\" + nomDuFichier))
            {
                TelechargerFichierFirestore("C:\\fichiersCache", nomDuFichier);
            }
            mediaPlayer.URL = "C:\\fichiersCache\\" + nomDuFichier;
        }

        private void CreerDossierCacheExiste()
        {
            if (!System.IO.Directory.Exists("C:\\fichiersCache"))
            {
                System.IO.Directory.CreateDirectory("C:\\fichiersCache");
            }
        }

        private void TelechargerFichierFirestore(string path, string fichierSelectionnee)
        {
            CreerDossierCacheExiste();
            var client = StorageClient.Create();
            using (var stream = File.OpenWrite(path + "\\" + fichierSelectionnee))
            {
                client.DownloadObject(bucketName, numeroDuLocal + "/" + fichierSelectionnee, stream);
            }
        }

        private void listBoxFichiersLocal_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listBoxFichiersLocal.SelectedItem != null)
            {
                string nomDuFichier = listBoxFichiersLocal.SelectedItem.ToString();
                if (nomDuFichier.StartsWith(numeroDuLocal + "/"))
                { 
                    nomDuFichier = nomDuFichier.ToString().Remove(0, 6);
                }
                if (nomDuFichier.EndsWith(".bmp") || nomDuFichier.EndsWith(".jpg") || nomDuFichier.EndsWith(".png"))
                {
                    AfficherImage(nomDuFichier);
                }
                else if (nomDuFichier.EndsWith(".mp4") || nomDuFichier.EndsWith(".mp3"))
                {
                    AfficherVideo(nomDuFichier);
                }
            }
        }

        private void SupprimerFichierCache(string nomDuFichierSelectionne)
        {
            string path = "C:\\fichiersCache\\" + nomDuFichierSelectionne;
            pictureBoxPreview.Image = null;
            mediaPlayer.URL = null;
            File.Delete(path);
        }

        private void SupprimerFichierFirestore(string nomDuFichier)
        {
            var storage = StorageClient.Create();
            storage.DeleteObject(bucketName, numeroDuLocal + "/" + nomDuFichier);
            DocumentReference leLocalReference = ObtenirLocal(numeroDuLocal, "Aile " + numeroDuLocal[0].ToString(), "Étage " + numeroDuLocal[2].ToString()).Reference;
            leLocalReference.UpdateAsync("Fichiers", FieldValue.ArrayRemove(nomDuFichier));
        }

        private void buttonSupprimer_Click(object sender, EventArgs e)
        {
            if (listBoxFichiersLocal.Items.Count > 0)
            {
                string nomDuFichierSelectionne = listBoxFichiersLocal.SelectedItem.ToString();
                if (nomDuFichierSelectionne.StartsWith(numeroDuLocal + "/"))
                {
                    nomDuFichierSelectionne = nomDuFichierSelectionne.Remove(0, 6);
                }
                SupprimerFichierCache(nomDuFichierSelectionne);
                SupprimerFichierFirestore(nomDuFichierSelectionne);
                listBoxFichiersLocal.Items.Remove(listBoxFichiersLocal.SelectedItem);
            }
        }

        private void buttonAjouter_Click(object sender, EventArgs e)
        {
            string nomDuFichier = "";
            string path = "";
            string fileContent = "";
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.InitialDirectory = "c:\\";
                openFileDialog.Filter = "Images/Videos/Audio (*.bmp;*.png;*.jpg;*.mp4;*.mp3)|*.bmp;*.png;*.jpg;*.mp4;*.mp3";
                openFileDialog.FilterIndex = 2;
                openFileDialog.RestoreDirectory = true;
                if (openFileDialog.ShowDialog() == DialogResult.OK)
                {
                    path = openFileDialog.FileName;
                    path = Path.GetDirectoryName(path);
                    nomDuFichier = openFileDialog.SafeFileName;
                    var fileStream = openFileDialog.OpenFile();
                    using (StreamReader reader = new StreamReader(fileStream))
                    {
                        fileContent = reader.ReadToEnd();
                    }
                    AjouterFichierCache(path, nomDuFichier);
                    UploaderFichierFirestore(path, nomDuFichier);
                    listBoxFichiersLocal.Items.Add(nomDuFichier);
                }
            }
        }

        private void buttonRetour_Click(object sender, EventArgs e)
        {
            Retourner();         
        }

        private void Retourner()
        {
            this.Hide();
            mediaPlayer.Ctlcontrols.stop();
            Modifier formModifier = Modifier.formModifier;
            formModifier.Visible = true;
        }
    }
}
