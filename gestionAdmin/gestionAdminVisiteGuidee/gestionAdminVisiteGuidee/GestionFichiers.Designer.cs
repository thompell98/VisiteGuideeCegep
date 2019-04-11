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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(GestionFichiers));
            this.groupBoxFichiersLocal = new System.Windows.Forms.GroupBox();
            this.listBoxFichiersLocal = new System.Windows.Forms.ListBox();
            this.groupBoxPreview = new System.Windows.Forms.GroupBox();
            this.pictureBoxPreview = new System.Windows.Forms.PictureBox();
            this.buttonAjouterFichier = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.shapeContainer1 = new Microsoft.VisualBasic.PowerPacks.ShapeContainer();
            this.rectangleShape2 = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.buttonSupprimerFichier = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.labelAjouter = new System.Windows.Forms.Label();
            this.labelSupprimer = new System.Windows.Forms.Label();
            this.buttonRetour = new System.Windows.Forms.PictureBox();
            this.mediaPlayer = new AxWMPLib.AxWindowsMediaPlayer();
            this.shapeContainer2 = new Microsoft.VisualBasic.PowerPacks.ShapeContainer();
            this.groupBoxFichiersLocal.SuspendLayout();
            this.groupBoxPreview.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxPreview)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.buttonRetour)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.mediaPlayer)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBoxFichiersLocal
            // 
            this.groupBoxFichiersLocal.Controls.Add(this.labelSupprimer);
            this.groupBoxFichiersLocal.Controls.Add(this.labelAjouter);
            this.groupBoxFichiersLocal.Controls.Add(this.listBoxFichiersLocal);
            this.groupBoxFichiersLocal.Controls.Add(this.shapeContainer2);
            this.groupBoxFichiersLocal.Location = new System.Drawing.Point(59, 12);
            this.groupBoxFichiersLocal.Name = "groupBoxFichiersLocal";
            this.groupBoxFichiersLocal.Size = new System.Drawing.Size(252, 302);
            this.groupBoxFichiersLocal.TabIndex = 3;
            this.groupBoxFichiersLocal.TabStop = false;
            this.groupBoxFichiersLocal.Text = "Fichiers du local";
            // 
            // listBoxFichiersLocal
            // 
            this.listBoxFichiersLocal.FormattingEnabled = true;
            this.listBoxFichiersLocal.Location = new System.Drawing.Point(6, 19);
            this.listBoxFichiersLocal.Name = "listBoxFichiersLocal";
            this.listBoxFichiersLocal.Size = new System.Drawing.Size(240, 212);
            this.listBoxFichiersLocal.TabIndex = 0;
            this.listBoxFichiersLocal.SelectedIndexChanged += new System.EventHandler(this.listBoxFichiersLocal_SelectedIndexChanged);
            // 
            // groupBoxPreview
            // 
            this.groupBoxPreview.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBoxPreview.Controls.Add(this.mediaPlayer);
            this.groupBoxPreview.Controls.Add(this.pictureBoxPreview);
            this.groupBoxPreview.Location = new System.Drawing.Point(326, 12);
            this.groupBoxPreview.Name = "groupBoxPreview";
            this.groupBoxPreview.Size = new System.Drawing.Size(413, 289);
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
            this.pictureBoxPreview.Size = new System.Drawing.Size(401, 260);
            this.pictureBoxPreview.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBoxPreview.TabIndex = 0;
            this.pictureBoxPreview.TabStop = false;
            // 
            // buttonAjouterFichier
            // 
            this.buttonAjouterFichier.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonAjouterFichier.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.buttonAjouterFichier.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonAjouterFichier.CornerRadius = 5;
            this.buttonAjouterFichier.Location = new System.Drawing.Point(8, 243);
            this.buttonAjouterFichier.Name = "buttonAjouterFichier";
            this.buttonAjouterFichier.Size = new System.Drawing.Size(108, 24);
            this.buttonAjouterFichier.Click += new System.EventHandler(this.buttonAjouter_Click);
            // 
            // shapeContainer1
            // 
            this.shapeContainer1.Location = new System.Drawing.Point(0, 0);
            this.shapeContainer1.Margin = new System.Windows.Forms.Padding(0);
            this.shapeContainer1.Name = "shapeContainer1";
            this.shapeContainer1.Shapes.AddRange(new Microsoft.VisualBasic.PowerPacks.Shape[] {
            this.rectangleShape2});
            this.shapeContainer1.Size = new System.Drawing.Size(742, 372);
            this.shapeContainer1.TabIndex = 6;
            this.shapeContainer1.TabStop = false;
            // 
            // rectangleShape2
            // 
            this.rectangleShape2.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.rectangleShape2.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.rectangleShape2.BorderColor = System.Drawing.SystemColors.ActiveCaption;
            this.rectangleShape2.CornerRadius = 5;
            this.rectangleShape2.Location = new System.Drawing.Point(11, 9);
            this.rectangleShape2.Name = "rectangleShape2";
            this.rectangleShape2.Size = new System.Drawing.Size(41, 42);
            // 
            // buttonSupprimerFichier
            // 
            this.buttonSupprimerFichier.BackColor = System.Drawing.Color.DarkRed;
            this.buttonSupprimerFichier.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.buttonSupprimerFichier.BorderColor = System.Drawing.Color.DarkRed;
            this.buttonSupprimerFichier.CornerRadius = 5;
            this.buttonSupprimerFichier.Location = new System.Drawing.Point(125, 242);
            this.buttonSupprimerFichier.Name = "buttonSupprimerFichier";
            this.buttonSupprimerFichier.Size = new System.Drawing.Size(111, 25);
            this.buttonSupprimerFichier.Click += new System.EventHandler(this.buttonSupprimer_Click);
            // 
            // labelAjouter
            // 
            this.labelAjouter.AutoSize = true;
            this.labelAjouter.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.labelAjouter.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelAjouter.Location = new System.Drawing.Point(41, 265);
            this.labelAjouter.Name = "labelAjouter";
            this.labelAjouter.Size = new System.Drawing.Size(47, 13);
            this.labelAjouter.TabIndex = 7;
            this.labelAjouter.Text = "Ajouter";
            this.labelAjouter.Click += new System.EventHandler(this.buttonAjouter_Click);
            // 
            // labelSupprimer
            // 
            this.labelSupprimer.AutoSize = true;
            this.labelSupprimer.BackColor = System.Drawing.Color.DarkRed;
            this.labelSupprimer.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSupprimer.ForeColor = System.Drawing.Color.Black;
            this.labelSupprimer.Location = new System.Drawing.Point(153, 265);
            this.labelSupprimer.Name = "labelSupprimer";
            this.labelSupprimer.Size = new System.Drawing.Size(63, 13);
            this.labelSupprimer.TabIndex = 8;
            this.labelSupprimer.Text = "Supprimer";
            this.labelSupprimer.Click += new System.EventHandler(this.buttonSupprimer_Click);
            // 
            // buttonRetour
            // 
            this.buttonRetour.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.buttonRetour.Image = ((System.Drawing.Image)(resources.GetObject("buttonRetour.Image")));
            this.buttonRetour.Location = new System.Drawing.Point(13, 12);
            this.buttonRetour.Name = "buttonRetour";
            this.buttonRetour.Size = new System.Drawing.Size(37, 38);
            this.buttonRetour.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.buttonRetour.TabIndex = 9;
            this.buttonRetour.TabStop = false;
            this.buttonRetour.Click += new System.EventHandler(this.buttonRetour_Click);
            // 
            // mediaPlayer
            // 
            this.mediaPlayer.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.mediaPlayer.Enabled = true;
            this.mediaPlayer.Location = new System.Drawing.Point(6, 19);
            this.mediaPlayer.Name = "mediaPlayer";
            this.mediaPlayer.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("mediaPlayer.OcxState")));
            this.mediaPlayer.Size = new System.Drawing.Size(398, 260);
            this.mediaPlayer.TabIndex = 10;
            this.mediaPlayer.Visible = false;
            // 
            // shapeContainer2
            // 
            this.shapeContainer2.Location = new System.Drawing.Point(3, 16);
            this.shapeContainer2.Margin = new System.Windows.Forms.Padding(0);
            this.shapeContainer2.Name = "shapeContainer2";
            this.shapeContainer2.Shapes.AddRange(new Microsoft.VisualBasic.PowerPacks.Shape[] {
            this.buttonSupprimerFichier,
            this.buttonAjouterFichier});
            this.shapeContainer2.Size = new System.Drawing.Size(246, 283);
            this.shapeContainer2.TabIndex = 1;
            this.shapeContainer2.TabStop = false;
            // 
            // GestionFichiers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(742, 372);
            this.Controls.Add(this.buttonRetour);
            this.Controls.Add(this.groupBoxPreview);
            this.Controls.Add(this.groupBoxFichiersLocal);
            this.Controls.Add(this.shapeContainer1);
            this.Name = "GestionFichiers";
            this.Text = "GestionFichiers";
            this.groupBoxFichiersLocal.ResumeLayout(false);
            this.groupBoxFichiersLocal.PerformLayout();
            this.groupBoxPreview.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxPreview)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.buttonRetour)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.mediaPlayer)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.GroupBox groupBoxFichiersLocal;
        private System.Windows.Forms.GroupBox groupBoxPreview;
        private System.Windows.Forms.ListBox listBoxFichiersLocal;
        private System.Windows.Forms.PictureBox pictureBoxPreview;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape buttonAjouterFichier;
        private Microsoft.VisualBasic.PowerPacks.ShapeContainer shapeContainer1;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape buttonSupprimerFichier;
        private System.Windows.Forms.Label labelAjouter;
        private System.Windows.Forms.Label labelSupprimer;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape rectangleShape2;
        private System.Windows.Forms.PictureBox buttonRetour;
        private AxWMPLib.AxWindowsMediaPlayer mediaPlayer;
        private Microsoft.VisualBasic.PowerPacks.ShapeContainer shapeContainer2;
    }
}