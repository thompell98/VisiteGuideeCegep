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
        public Accueil()
        {
            InitializeComponent();
            ModifierLabelBonjour();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            VoirLesLocaux();
        }

        public void ModifierLabelBonjour()
        {
            labelBonjour.Text = "Bonjour " + Connexion.prenom;
        }

        private void VoirLesLocaux()
        {
            this.Hide();
            Modifier form = new Modifier();
            form.Show();
        }

        private void GererLesAdmins()
        {
            this.Hide();
            GestionDesAdmins form = new GestionDesAdmins();
            form.Show();
        }

        private void buttonGererAdmins_Click(object sender, EventArgs e)
        {
            GererLesAdmins();
        }
    }
}
