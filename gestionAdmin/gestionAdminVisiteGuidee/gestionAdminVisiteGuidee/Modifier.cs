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

namespace gestionAdminVisiteGuidee
{
    public partial class Modifier : Form
    {
        FirestoreDb db = FirestoreDb.Create("visiteguideecegep-f394b");
        string[] lesAiles = new string[] { "A", "B", "C", "D", "E", "G", "N" };
        WaitPlease form = new WaitPlease();
        public static string numero = "";
        public static Modifier formModifier = null;

        public Modifier()
        {
            InitializeComponent();
            SynchroniserTreeView();
        }

        private void AfficherLoadingScreen()
        {
            form.Show();
        }

        private void EnleverLoadingScreen()
        {
            form.Hide();
        }

        private void Return()
        {
            this.Hide();
            Accueil form = new Accueil();
            form.Show();
        }

        private void SynchroniserTreeView()
        {
            AfficherLoadingScreen();
            treeViewBD.Nodes.Add("Étages");
            for (int cpt = 0; cpt < 5; cpt++)
            {
                treeViewBD.Nodes[0].Nodes.Add("Étage " + (cpt + 1).ToString());
                for (int cpt2 = 0; cpt2 < 7; cpt2++)
                {
                    treeViewBD.Nodes[0].Nodes[cpt].Nodes.Add("Aile " + lesAiles[cpt2].ToString());
                    List<Dictionary<string, object>> lesLocaux = ObtenirLesLocaux("Étage " + (cpt + 1).ToString(), "Aile " + lesAiles[cpt2].ToString());
                    foreach (Dictionary<string, object> unLocal in lesLocaux)
                    {
                        treeViewBD.Nodes[0].Nodes[cpt].Nodes[cpt2].Nodes.Add(unLocal["Numero"].ToString());
                    }
                }
            }
            EnleverLoadingScreen();
        }

        private List<Dictionary<string, object>> ObtenirLesLocaux(string etage, string aile)
        {
            Task<List<Dictionary<string, object>>> taskLocaux = Task.Run<List<Dictionary<string, object>>>(async () => await ChercherLocauxSelonEtageAile(etage, aile));
            return taskLocaux.Result;
        }

        private async Task<List<Dictionary<string, object>>> ChercherLocauxSelonEtageAile(string etage, string aile)
        {
            List<Dictionary<string, object>> lesLocaux = new List<Dictionary<string, object>>();
            CollectionReference reference = db.Collection("Étages").Document(etage).Collection("Ailes").Document(aile).Collection("Locaux");
            QuerySnapshot locauxSnapshot = await reference.GetSnapshotAsync();
            foreach (DocumentSnapshot local in locauxSnapshot.Documents)
            {
                Dictionary<string, object> documentDictionary = local.ToDictionary();
                lesLocaux.Add(documentDictionary);
            }
            return lesLocaux;
        }

        private void treeViewBD_AfterSelect(object sender, TreeViewEventArgs e)
        {
            if (e.Node.Level >= 3)
            {
                TreeNode node = treeViewBD.SelectedNode;
                numero = treeViewBD.SelectedNode.Text;
                string aileDuLocal = node.Parent.Text;
                node = node.Parent;
                string etageDuLocal = node.Parent.Text;
                Dictionary<string, object> leLocal = ObtenirLocal(numero, aileDuLocal, etageDuLocal).ToDictionary();
                AfficherLocal(leLocal);
            }
        }

        private void AfficherLocal(Dictionary<string, object> leLocal)
        {
            textBoxNumero.Text = leLocal["Numero"].ToString();
            textBoxNom.Text = leLocal["Nom"].ToString();
            textBoxDescription.Text = leLocal["Description"].ToString();
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

        private async void ModifierLocal()
        {
            DocumentReference leLocal = ObtenirLocal("B-533", "Aile B", "Étage 5").Reference;
            Dictionary<FieldPath, object> updates = new Dictionary<FieldPath, object>
            {
                { new FieldPath("Description"), textBoxDescription.Text },
                { new FieldPath("Nom"), textBoxNom.Text },
                { new FieldPath("Numero"), textBoxNumero.Text },
            };
            WriteResult updateResult = await leLocal.UpdateAsync(updates);
            MessageBox.Show("Modifications effectuées", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void OuvrirFormGestionFichiers()
        {
            if (textBoxNumero.Text == "")
            {
                MessageBox.Show("Veuillez sélectionner un local", "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                numero = textBoxNumero.Text;
                this.Visible = false;
                formModifier = this;
                GestionFichiers form = new GestionFichiers();
                form.Show();
            }
        }

        private void buttonGererFichiers_Click(object sender, EventArgs e)
        {
            OuvrirFormGestionFichiers();
        }

        private void buttonRetour_Click(object sender, EventArgs e)
        {
            Return();
        }

        private void buttonModifier_Click(object sender, EventArgs e)
        {
            if (textBoxNumero.Text != "")
            {
                ModifierLocal();
            }
        }
    }
}
