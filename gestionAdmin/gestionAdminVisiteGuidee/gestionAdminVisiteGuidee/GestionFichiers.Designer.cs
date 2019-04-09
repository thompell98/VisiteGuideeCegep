namespace gestionAdminVisiteGuidee
{
    partial class GestionFichiers
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelFichier = new System.Windows.Forms.Label();
            this.textBoxPathFichier = new System.Windows.Forms.TextBox();
            this.buttonImporter = new System.Windows.Forms.Button();
            this.groupBoxFichiersLocal = new System.Windows.Forms.GroupBox();
            this.listBoxFichiersLocal = new System.Windows.Forms.ListBox();
            this.groupBoxPreview = new System.Windows.Forms.GroupBox();
            this.pictureBoxPreview = new System.Windows.Forms.PictureBox();
            this.button1 = new System.Windows.Forms.Button();
            this.groupBoxFichiersLocal.SuspendLayout();
            this.groupBoxPreview.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxPreview)).BeginInit();
            this.SuspendLayout();
            // 
            // labelFichier
            // 
            this.labelFichier.AutoSize = true;
            this.labelFichier.Location = new System.Drawing.Point(51, 17);
            this.labelFichier.Name = "labelFichier";
            this.labelFichier.Size = new System.Drawing.Size(41, 13);
            this.labelFichier.TabIndex = 0;
            this.labelFichier.Text = "Fichier:";
            // 
            // textBoxPathFichier
            // 
            this.textBoxPathFichier.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textBoxPathFichier.Location = new System.Drawing.Point(92, 14);
            this.textBoxPathFichier.Name = "textBoxPathFichier";
            this.textBoxPathFichier.Size = new System.Drawing.Size(423, 20);
            this.textBoxPathFichier.TabIndex = 1;
            // 
            // buttonImporter
            // 
            this.buttonImporter.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonImporter.Location = new System.Drawing.Point(519, 12);
            this.buttonImporter.Name = "buttonImporter";
            this.buttonImporter.Size = new System.Drawing.Size(103, 23);
            this.buttonImporter.TabIndex = 2;
            this.buttonImporter.Text = "Importer un fichier";
            this.buttonImporter.UseVisualStyleBackColor = true;
            this.buttonImporter.Click += new System.EventHandler(this.buttonImporter_Click);
            // 
            // groupBoxFichiersLocal
            // 
            this.groupBoxFichiersLocal.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.groupBoxFichiersLocal.Controls.Add(this.listBoxFichiersLocal);
            this.groupBoxFichiersLocal.Location = new System.Drawing.Point(12, 54);
            this.groupBoxFichiersLocal.Name = "groupBoxFichiersLocal";
            this.groupBoxFichiersLocal.Size = new System.Drawing.Size(252, 330);
            this.groupBoxFichiersLocal.TabIndex = 3;
            this.groupBoxFichiersLocal.TabStop = false;
            this.groupBoxFichiersLocal.Text = "Fichiers du local";
            // 
            // listBoxFichiersLocal
            // 
            this.listBoxFichiersLocal.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.listBoxFichiersLocal.FormattingEnabled = true;
            this.listBoxFichiersLocal.Location = new System.Drawing.Point(6, 19);
            this.listBoxFichiersLocal.Name = "listBoxFichiersLocal";
            this.listBoxFichiersLocal.Size = new System.Drawing.Size(240, 303);
            this.listBoxFichiersLocal.TabIndex = 0;
            this.listBoxFichiersLocal.SelectedIndexChanged += new System.EventHandler(this.listBoxFichiersLocal_SelectedIndexChanged);
            // 
            // groupBoxPreview
            // 
            this.groupBoxPreview.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBoxPreview.Controls.Add(this.pictureBoxPreview);
            this.groupBoxPreview.Location = new System.Drawing.Point(286, 54);
            this.groupBoxPreview.Name = "groupBoxPreview";
            this.groupBoxPreview.Size = new System.Drawing.Size(392, 330);
            this.groupBoxPreview.TabIndex = 4;
            this.groupBoxPreview.TabStop = false;
            this.groupBoxPreview.Text = "preview";
            // 
            // pictureBoxPreview
            // 
            this.pictureBoxPreview.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pictureBoxPreview.Location = new System.Drawing.Point(6, 19);
            this.pictureBoxPreview.Name = "pictureBoxPreview";
            this.pictureBoxPreview.Size = new System.Drawing.Size(381, 301);
            this.pictureBoxPreview.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBoxPreview.TabIndex = 0;
            this.pictureBoxPreview.TabStop = false;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(188, 391);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 5;
            this.button1.Text = "button1";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // GestionFichiers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(690, 413);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.groupBoxPreview);
            this.Controls.Add(this.groupBoxFichiersLocal);
            this.Controls.Add(this.buttonImporter);
            this.Controls.Add(this.textBoxPathFichier);
            this.Controls.Add(this.labelFichier);
            this.Name = "GestionFichiers";
            this.Text = "GestionFichiers";
            this.groupBoxFichiersLocal.ResumeLayout(false);
            this.groupBoxPreview.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxPreview)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelFichier;
        private System.Windows.Forms.TextBox textBoxPathFichier;
        private System.Windows.Forms.Button buttonImporter;
        private System.Windows.Forms.GroupBox groupBoxFichiersLocal;
        private System.Windows.Forms.GroupBox groupBoxPreview;
        private System.Windows.Forms.ListBox listBoxFichiersLocal;
        private System.Windows.Forms.PictureBox pictureBoxPreview;
        private System.Windows.Forms.Button button1;
    }
}