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
    public partial class GestionDesAdmins : Form
    {
        FirestoreDb db = FirestoreDb.Create("visiteguideecegep-f394b");
        public GestionDesAdmins()
        {
            InitializeComponent();
            AfficherLesAdmins();
        }

        private void AfficherLesAdmins()
        {
            List<Dictionary<string, object>> lesAdmins = ObtenirLesAdmins();
            foreach (Dictionary<string, object> admin in lesAdmins)
            {
                listBoxAdmins.Items.Add(admin["Username"]).ToString();
            }
        }

        private List<Dictionary<string, object>> ObtenirLesAdmins()
        {
            Task<List<Dictionary<string, object>>> taskLocaux = Task.Run<List<Dictionary<string, object>>>(async () => await TrouverAdminsBD());
            return taskLocaux.Result;
        }

        private async Task<List<Dictionary<string, object>>> TrouverAdminsBD()
        {
            List<Dictionary<string, object>> lesAdmins = new List<Dictionary<string, object>>();
            CollectionReference reference = db.Collection("Admins");
            QuerySnapshot adminsSnapshot = await reference.GetSnapshotAsync();
            foreach (DocumentSnapshot admin in adminsSnapshot.Documents)
            {
                Dictionary<string, object> documentDictionary = admin.ToDictionary();
                lesAdmins.Add(documentDictionary);
            }
            return lesAdmins;
        }

        private void buttonModifier_Click(object sender, EventArgs e)
        {

        }

        private void buttonGererFichiers_Click(object sender, EventArgs e)
        {

        }
    }
}
