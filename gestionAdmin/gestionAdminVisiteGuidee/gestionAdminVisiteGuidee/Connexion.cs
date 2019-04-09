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
    public partial class Connexion : Form
    {
        FirestoreDb db = FirestoreDb.Create("visiteguideecegep-f394b");
        public static string prenom = "";

        public Connexion()
        {
            InitializeComponent();
        }

        private void buttonSeConnecter_Click(object sender, EventArgs e)
        {
            String nomUtilisateur = textBoxNomUtilisateur.Text;
            String motDePasse = textBoxMotDePasse.Text;
            SeConnecter(nomUtilisateur, motDePasse);
        }

        private void GoToAccueil()
        {
            this.Hide();
            Accueil form = new Accueil();
            form.Show();
        }

        private async void SeConnecter(String nomUtilisateur, String motDePasse)
        {
            if (nomUtilisateur == "" || motDePasse == "")
            {
                MessageBox.Show("Veuillez remplir chacun des champs pour vous connecter.", "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                CollectionReference usersRef = db.Collection("Admins");
                try
                {
                    QuerySnapshot snapshot = await usersRef.GetSnapshotAsync();
                    foreach (DocumentSnapshot document in snapshot.Documents)
                    {
                        Dictionary<string, object> documentDictionary = document.ToDictionary();
                        if (documentDictionary["Username"].ToString() == nomUtilisateur
                            && documentDictionary["Password"].ToString() == motDePasse)
                        {
                            prenom = documentDictionary["Prenom"].ToString();
                            GoToAccueil();
                        }
                        else
                        {
                            MessageBox.Show("Mauvais nom d'utilisateur ou mot de passe, veuillez réessayer.", "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                        }
                    }
                }
                catch (Exception e)
                {
                    MessageBox.Show(e.ToString(), "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
            }
        }
    }
}
