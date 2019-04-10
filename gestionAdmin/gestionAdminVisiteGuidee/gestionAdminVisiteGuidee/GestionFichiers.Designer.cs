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
            this.buttonGererFichiers = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.shapeContainer1 = new Microsoft.VisualBasic.PowerPacks.ShapeContainer();
            this.rectangleShape1 = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.labelAjouter = new System.Windows.Forms.Label();
            this.labelSupprimer = new System.Windows.Forms.Label();
            this.rectangleShape2 = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.groupBoxFichiersLocal.SuspendLayout();
            this.groupBoxPreview.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxPreview)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBoxFichiersLocal
            // 
            this.groupBoxFichiersLocal.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.groupBoxFichiersLocal.Controls.Add(this.listBoxFichiersLocal);
            this.groupBoxFichiersLocal.Location = new System.Drawing.Point(59, 12);
            this.groupBoxFichiersLocal.Name = "groupBoxFichiersLocal";
            this.groupBoxFichiersLocal.Size = new System.Drawing.Size(252, 296);
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
            this.listBoxFichiersLocal.Size = new System.Drawing.Size(240, 251);
            this.listBoxFichiersLocal.TabIndex = 0;
            this.listBoxFichiersLocal.SelectedIndexChanged += new System.EventHandler(this.listBoxFichiersLocal_SelectedIndexChanged);
            // 
            // groupBoxPreview
            // 
            this.groupBoxPreview.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBoxPreview.Controls.Add(this.pictureBoxPreview);
            this.groupBoxPreview.Location = new System.Drawing.Point(326, 12);
            this.groupBoxPreview.Name = "groupBoxPreview";
            this.groupBoxPreview.Size = new System.Drawing.Size(436, 296);
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
            this.pictureBoxPreview.Size = new System.Drawing.Size(425, 267);
            this.pictureBoxPreview.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBoxPreview.TabIndex = 0;
            this.pictureBoxPreview.TabStop = false;
            // 
            // buttonGererFichiers
            // 
            this.buttonGererFichiers.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonGererFichiers.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.buttonGererFichiers.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonGererFichiers.CornerRadius = 5;
            this.buttonGererFichiers.Location = new System.Drawing.Point(71, 322);
            this.buttonGererFichiers.Name = "buttonGererFichiers";
            this.buttonGererFichiers.Size = new System.Drawing.Size(108, 25);
            this.buttonGererFichiers.Click += new System.EventHandler(this.buttonAjouter_Click);
            // 
            // shapeContainer1
            // 
            this.shapeContainer1.Location = new System.Drawing.Point(0, 0);
            this.shapeContainer1.Margin = new System.Windows.Forms.Padding(0);
            this.shapeContainer1.Name = "shapeContainer1";
            this.shapeContainer1.Shapes.AddRange(new Microsoft.VisualBasic.PowerPacks.Shape[] {
            this.rectangleShape2,
            this.rectangleShape1,
            this.buttonGererFichiers});
            this.shapeContainer1.Size = new System.Drawing.Size(734, 379);
            this.shapeContainer1.TabIndex = 6;
            this.shapeContainer1.TabStop = false;
            // 
            // rectangleShape1
            // 
            this.rectangleShape1.BackColor = System.Drawing.Color.DarkRed;
            this.rectangleShape1.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.rectangleShape1.BorderColor = System.Drawing.Color.DarkRed;
            this.rectangleShape1.CornerRadius = 5;
            this.rectangleShape1.Location = new System.Drawing.Point(185, 322);
            this.rectangleShape1.Name = "rectangleShape1";
            this.rectangleShape1.Size = new System.Drawing.Size(115, 26);
            this.rectangleShape1.Click += new System.EventHandler(this.buttonSupprimer_Click);
            // 
            // labelAjouter
            // 
            this.labelAjouter.AutoSize = true;
            this.labelAjouter.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.labelAjouter.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelAjouter.Location = new System.Drawing.Point(101, 328);
            this.labelAjouter.Name = "labelAjouter";
            this.labelAjouter.Size = new System.Drawing.Size(47, 13);
            this.labelAjouter.TabIndex = 7;
            this.labelAjouter.Text = "Ajouter";
            // 
            // labelSupprimer
            // 
            this.labelSupprimer.AutoSize = true;
            this.labelSupprimer.BackColor = System.Drawing.Color.DarkRed;
            this.labelSupprimer.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSupprimer.ForeColor = System.Drawing.Color.Black;
            this.labelSupprimer.Location = new System.Drawing.Point(213, 328);
            this.labelSupprimer.Name = "labelSupprimer";
            this.labelSupprimer.Size = new System.Drawing.Size(63, 13);
            this.labelSupprimer.TabIndex = 8;
            this.labelSupprimer.Text = "Supprimer";
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
            this.rectangleShape2.Click += new System.EventHandler(this.buttonGererFichiers_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(13, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(37, 38);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 9;
            this.pictureBox1.TabStop = false;
            // 
            // GestionFichiers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(734, 379);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.labelSupprimer);
            this.Controls.Add(this.labelAjouter);
            this.Controls.Add(this.groupBoxPreview);
            this.Controls.Add(this.groupBoxFichiersLocal);
            this.Controls.Add(this.shapeContainer1);
            this.Name = "GestionFichiers";
            this.Text = "GestionFichiers";
            this.groupBoxFichiersLocal.ResumeLayout(false);
            this.groupBoxPreview.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxPreview)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.GroupBox groupBoxFichiersLocal;
        private System.Windows.Forms.GroupBox groupBoxPreview;
        private System.Windows.Forms.ListBox listBoxFichiersLocal;
        private System.Windows.Forms.PictureBox pictureBoxPreview;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape buttonGererFichiers;
        private Microsoft.VisualBasic.PowerPacks.ShapeContainer shapeContainer1;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape rectangleShape1;
        private System.Windows.Forms.Label labelAjouter;
        private System.Windows.Forms.Label labelSupprimer;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape rectangleShape2;
        private System.Windows.Forms.PictureBox pictureBox1;
    }
}