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
        public Accueil()
        {
            InitializeComponent();
        }

        private void buttonRechercherLocal_Click(object sender, EventArgs e)
        {
            string numeroLocal = textBoxNumeroLocal.Text;
            Dictionary<string, object> leLocal = ObtenirLocal(numeroLocal);
            AfficherLocal(leLocal);
        }

        private Dictionary<string, object> ObtenirLocal(string numeroLocal)
        {
            Task<Dictionary<string, object>> taskLocal = Task.Run<Dictionary<string, object>>(async () => await TrouverLocalBD(numeroLocal));
            return taskLocal.Result;
        }

        private void AfficherLocal(Dictionary<string, object> leLocal)
        {
            if (leLocal != null)
            {
                MessageBox.Show("Nom du local: " + leLocal["Nom"]);
            }
            else
            {
                MessageBox.Show("Le local n'existe pas");
            }
        }

        private async Task<Dictionary<string, object>> TrouverLocalBD(String local)
        {
            Dictionary<string, object> leLocal = null;
            try
            {
                CollectionReference etagesRef = db.Collection("Étages");
                QuerySnapshot etagesSnapshot = await etagesRef.GetSnapshotAsync();
                foreach (DocumentSnapshot etagesDocument in etagesSnapshot.Documents)
                {
                    CollectionReference locauxRef = etagesDocument.Reference.Collection("Locaux");
                    QuerySnapshot locauxSnapShots = await locauxRef.GetSnapshotAsync();
                    foreach (DocumentSnapshot locauxDocument in locauxSnapShots.Documents)
                    {
                        Dictionary<string, object> documentDictionary = locauxDocument.ToDictionary();
                        if (documentDictionary["Numero"].ToString() == local)
                        {
                            leLocal = documentDictionary;
                        }
                    }
                }
            }
            catch (Exception)
            {
                MessageBox.Show("Impossible de se connecter a la base de donnees", "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }          
            return leLocal;
        }
    }
}
