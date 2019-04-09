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
        public GestionFichiers()
        {
            InitializeComponent();
        }

        private void buttonImporter_Click(object sender, EventArgs e)
        {
            string filePath = "";
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
                        filePath = openFileDialog.FileName;            
                        var fileStream = openFileDialog.OpenFile();
                        using (StreamReader reader = new StreamReader(fileStream))
                        {
                            fileContent = reader.ReadToEnd();
                        }
                    }
                }
                listBoxFichiersLocal.Items.Add(filePath);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Il y a une erreur: " + ex.Message + " " + ex.Source);
            }
        }

        private void readFiles()
        {
            var client = StorageClient.Create();
            var bucketName = "visiteguideecegep-f394b.appspot.com";
            StorageClient storageClient = StorageClient.Create();
            foreach (var obj in client.ListObjects(bucketName, ""))
            {
                Console.WriteLine(obj.Name);
            }
        }

        private void listBoxFichiersLocal_SelectedIndexChanged(object sender, EventArgs e)
        {
            var imageSelectionnee = listBoxFichiersLocal.SelectedItem.ToString();
            if (!string.IsNullOrEmpty(imageSelectionnee))
            {
                pictureBoxPreview.Image = Image.FromFile(imageSelectionnee);
            }
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            readFiles();
        }
    }
}
