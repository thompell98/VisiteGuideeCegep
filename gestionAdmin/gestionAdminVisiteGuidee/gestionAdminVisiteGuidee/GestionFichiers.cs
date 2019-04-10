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
            string destFile = System.IO.Path.Combine("C:\\imagesCache", nomDuFichier);
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
            string path = "C:\\imagesCache";
            if (!File.Exists(path + "\\" + nomDuFichier))
            {
                TelechargerFichierFirestore(path, nomDuFichier);
            }
            if (!string.IsNullOrEmpty(path))
            {
                Image img;
                using (var bmpTemp = new Bitmap(path + "\\" + nomDuFichier))
                {
                    img = new Bitmap(bmpTemp);
                }
                pictureBoxPreview.Image = img;
            }
        }

        private void CreerDossierCacheExiste()
        {
            string pathCache = "C:\\imagesCache";
            if (!System.IO.Directory.Exists(pathCache))
            {
                System.IO.Directory.CreateDirectory(pathCache);
            }
        }

        private void TelechargerFichierFirestore(string path, string imageSelectionnee)
        {
            CreerDossierCacheExiste();
            var client = StorageClient.Create();
            using (var stream = File.OpenWrite(path + "\\" + imageSelectionnee))
            {
                client.DownloadObject(bucketName, numeroDuLocal + "/" + imageSelectionnee, stream);
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
                AfficherImage(nomDuFichier);
            }
        }

        private void SupprimerImageCache(string nomDuFichierSelectionne)
        {
            string path = "C:\\imagesCache\\" + nomDuFichierSelectionne;
            pictureBoxPreview.Image = null;
            File.Delete(path);
        }

        private void SupprimerImageFirestore(string nomDuFichier)
        {
            var storage = StorageClient.Create();
            storage.DeleteObject(bucketName, numeroDuLocal + "/" + nomDuFichier);
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
                SupprimerImageCache(nomDuFichierSelectionne);
                SupprimerImageFirestore(nomDuFichierSelectionne);
                listBoxFichiersLocal.Items.Remove(listBoxFichiersLocal.SelectedItem);
            }
        }

        private void buttonAjouter_Click(object sender, EventArgs e)
        {
            string nomDuFichier = "";
            string path = "";
            string fileContent = "";
            try
            {
                using (OpenFileDialog openFileDialog = new OpenFileDialog())
                {
                    openFileDialog.InitialDirectory = "c:\\";
                    openFileDialog.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
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
            catch (Exception ex)
            {
                MessageBox.Show("Il y a une erreur: " + ex.Message + " " + ex.Source);
            }
        }

        private void buttonGererFichiers_Click(object sender, EventArgs e)
        {

        }
    }
}
