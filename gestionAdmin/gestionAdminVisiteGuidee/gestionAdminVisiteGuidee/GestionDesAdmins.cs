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
            listBoxAdmins.Items.Clear();
            List<Dictionary<string, object>> lesAdmins = ObtenirLesAdmins();
            foreach (Dictionary<string, object> admin in lesAdmins)
            {
                if (admin["Username"].ToString() != Connexion.username)
                {
                    listBoxAdmins.Items.Add(admin["Username"]).ToString();
                }
            }
        }

        private void Retourner()
        {
            this.Hide();
            Accueil accueil = new Accueil();
            accueil.Visible = true;
        }

        private async void SupprimerAdminFirestore(string usernameAdminSelectionne)
        {
            DocumentReference adminReference = ObtenirUnAdmin(usernameAdminSelectionne).Reference;
            await adminReference.DeleteAsync();
        }

        private async Task AjouterAdminFirestore(string prenom, string username, string password)
        {
            CollectionReference collectionRef = db.Collection("Admins");
            Dictionary<string, object> user = new Dictionary<string, object>
            {
                { "Password", password },
                { "Prenom", prenom },
                { "Username", username }
            };
            await collectionRef.AddAsync(user);
            return;
        }

        private void RéinisiatliserChampsAjout()
        {
            textBoxPrenom.Clear();
            textBoxNomUtilisateur.Clear();
            textBoxMotDePasse.Clear();
            textBoxConfirmerMotDePasse.Clear();
        }

        private void SupprimerAdmin()
        {
            if (listBoxAdmins.SelectedIndex > -1)
            {
                string usernameAdminSelectionne = listBoxAdmins.SelectedItem.ToString();
                SupprimerAdminFirestore(usernameAdminSelectionne);
                listBoxAdmins.Items.Remove(listBoxAdmins.SelectedItem);
                MessageBox.Show("Admin supprimé", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Veuillez sélectionner un admin", "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void AjouterAdmin()
        {
            if (textBoxPrenom.Text != "" && textBoxNomUtilisateur.Text != "" && 
                textBoxMotDePasse.Text != "" && textBoxConfirmerMotDePasse.Text != "")
            {
                if (ObtenirUnAdmin(textBoxNomUtilisateur.Text) == null && textBoxMotDePasse.Text == textBoxConfirmerMotDePasse.Text)
                {
                    Task.Run(async () => await AjouterAdminFirestore(textBoxPrenom.Text, textBoxNomUtilisateur.Text, textBoxMotDePasse.Text)).ContinueWith( task => {
                        RéinisiatliserChampsAjout();
                        AfficherLesAdmins();
                        System.Console.WriteLine("HERE");
                    }, TaskScheduler.FromCurrentSynchronizationContext());                                    
                    MessageBox.Show("Admin ajouté", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    if (ObtenirUnAdmin(textBoxNomUtilisateur.Text) != null)
                    {
                        MessageBox.Show("Ce nom d'utilisateur est déja utilisé");
                    }
                    if (textBoxMotDePasse.Text != textBoxConfirmerMotDePasse.Text)
                    {
                        MessageBox.Show("La confirmation du mot de passe est incorrecte");
                    }
                }
            }
            else
            {
                MessageBox.Show("Veuillez remplir chacun des champs", "Erreur", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private List<Dictionary<string, object>> ObtenirLesAdmins()
        {
            Task<List<Dictionary<string, object>>> taskAdmins = Task.Run<List<Dictionary<string, object>>>(async () => await TrouverAdminsBD());
            return taskAdmins.Result;
        }

        private DocumentSnapshot ObtenirUnAdmin(string username)
        {
            Task<DocumentSnapshot> taskAdmin = Task.Run<DocumentSnapshot>(async () => await TrouverUnAdminBD(username));
            taskAdmin.Wait();
            return taskAdmin.Result;
        }

        private async Task<DocumentSnapshot> TrouverUnAdminBD(string username)
        {
            DocumentSnapshot unAdmin = null;
            CollectionReference reference = db.Collection("Admins");
            QuerySnapshot adminsSnapshot = await reference.GetSnapshotAsync();
            foreach (DocumentSnapshot admin in adminsSnapshot.Documents)
            {
                Dictionary<string, object> documentDictionary = admin.ToDictionary();
                if (documentDictionary["Username"].ToString() == username)
                {
                    unAdmin = admin;
                }
            }
            return unAdmin;
        }

        private async Task<List<Dictionary<string, object>>> TrouverAdminsBD()
        {
            List<Dictionary<string, object>> lesAdmins = new List<Dictionary<string, object>>();
            CollectionReference reference = db.Collection("Admins");
            QuerySnapshot adminsSnapshot = await reference.GetSnapshotAsync();
            foreach (DocumentSnapshot admin in adminsSnapshot.Documents)
            {
                Dictionary<string, object> documentDictionary = admin.ToDictionary();
                if (documentDictionary["Username"].ToString() != "admin")
                {
                    lesAdmins.Add(documentDictionary);
                }
            }
            return lesAdmins;
        }

        private void buttonRetour_Click(object sender, EventArgs e)
        {
            Retourner();
        }

        private void buttonSupprimer_Click(object sender, EventArgs e)
        {
            SupprimerAdmin();
        }

        private void buttonAjouter_Click(object sender, EventArgs e)
        {
            AjouterAdmin();
        }
    }
}
