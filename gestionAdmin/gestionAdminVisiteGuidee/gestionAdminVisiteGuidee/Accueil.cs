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
    public partial class Accueil : Form
    {
        FirestoreDb db = FirestoreDb.Create("visiteguideecegep-f394b");
        string[] lesAiles = new string[] {"A", "B", "C", "D", "E", "G", "N"};

        public Accueil()
        {
            InitializeComponent();
            SynchroniserTreeView();
        }

        private void SynchroniserTreeView()
        {
            treeViewBD.Nodes.Add("Étages");
            for (int cpt = 0; cpt < 5; cpt++)
            {
                treeViewBD.Nodes[0].Nodes.Add("Étage " + (cpt+1).ToString());
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
                //ObtenirLocal
                //AfficherInfosDuLocal
            }
        }

        //private Dictionary<string, object> ObtenirLocal(string numeroLocal)
        //{
        //    Task<Dictionary<string, object>> taskLocal = Task.Run<Dictionary<string, object>>(async () => await TrouverLocalBD(numeroLocal));
        //    return taskLocal.Result;
        //}

        //private void AfficherLocal(Dictionary<string, object> leLocal)
        //{
        //    if (leLocal != null)
        //    {
        //        MessageBox.Show("Nom du local: " + leLocal["Nom"]);
        //    }
        //    else
        //    {
        //        MessageBox.Show("Le local n'existe pas");
        //    }
        //}

        //private async Task<Dictionary<string, object>> TrouverLocalBD(String local)
        //{
        //    Dictionary<string, object> leLocal = null;
        //    try
        //    {
        //        CollectionReference etagesRef = db.Collection("Étages");
        //        QuerySnapshot etagesSnapshot = await etagesRef.GetSnapshotAsync();
        //        foreach (DocumentSnapshot etagesDocument in etagesSnapshot.Documents)
        //        {
        //            CollectionReference locauxRef = etagesDocument.Reference.Collection("Locaux");
        //            QuerySnapshot locauxSnapShots = await locauxRef.GetSnapshotAsync();
        //            foreach (DocumentSnapshot locauxDocument in locauxSnapShots.Documents)
        //            {
        //                Dictionary<string, object> documentDictionary = locauxDocument.ToDictionary();
        //                if (documentDictionary["Numero"].ToString() == local)
        //                {
        //                    leLocal = documentDictionary;
        //                }
        //            }
        //        }
        //    }
        //    catch (Exception)
        //    {
        //        MessageBox.Show("Impossible de se connecter a la base de donnees", "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        //    }          
        //    return leLocal;
        //}
    }
}
