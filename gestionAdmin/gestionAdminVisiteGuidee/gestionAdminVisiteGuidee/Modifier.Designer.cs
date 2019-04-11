namespace gestionAdminVisiteGuidee
{
    partial class Modifier
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Modifier));
            this.treeViewBD = new System.Windows.Forms.TreeView();
            this.textBoxNom = new System.Windows.Forms.TextBox();
            this.textBoxDescription = new System.Windows.Forms.TextBox();
            this.labelNom = new System.Windows.Forms.Label();
            this.labelDescription = new System.Windows.Forms.Label();
            this.labelNumero = new System.Windows.Forms.Label();
            this.textBoxNumero = new System.Windows.Forms.TextBox();
            this.shapeContainer1 = new Microsoft.VisualBasic.PowerPacks.ShapeContainer();
            this.rectangleShape2 = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.buttonModifier = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.buttonGererFichiers = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.labelGererFichiers = new System.Windows.Forms.Label();
            this.labelModifier = new System.Windows.Forms.Label();
            this.buttonRetour = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.buttonRetour)).BeginInit();
            this.SuspendLayout();
            // 
            // treeViewBD
            // 
            this.treeViewBD.Location = new System.Drawing.Point(71, 12);
            this.treeViewBD.Name = "treeViewBD";
            this.treeViewBD.Size = new System.Drawing.Size(185, 426);
            this.treeViewBD.TabIndex = 0;
            this.treeViewBD.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treeViewBD_AfterSelect);
            // 
            // textBoxNom
            // 
            this.textBoxNom.Location = new System.Drawing.Point(338, 74);
            this.textBoxNom.Name = "textBoxNom";
            this.textBoxNom.Size = new System.Drawing.Size(100, 20);
            this.textBoxNom.TabIndex = 1;
            // 
            // textBoxDescription
            // 
            this.textBoxDescription.Location = new System.Drawing.Point(338, 114);
            this.textBoxDescription.Multiline = true;
            this.textBoxDescription.Name = "textBoxDescription";
            this.textBoxDescription.Size = new System.Drawing.Size(237, 124);
            this.textBoxDescription.TabIndex = 3;
            // 
            // labelNom
            // 
            this.labelNom.AutoSize = true;
            this.labelNom.Location = new System.Drawing.Point(300, 77);
            this.labelNom.Name = "labelNom";
            this.labelNom.Size = new System.Drawing.Size(32, 13);
            this.labelNom.TabIndex = 4;
            this.labelNom.Text = "Nom:";
            // 
            // labelDescription
            // 
            this.labelDescription.AutoSize = true;
            this.labelDescription.Location = new System.Drawing.Point(275, 114);
            this.labelDescription.Name = "labelDescription";
            this.labelDescription.Size = new System.Drawing.Size(63, 13);
            this.labelDescription.TabIndex = 5;
            this.labelDescription.Text = "Description:";
            // 
            // labelNumero
            // 
            this.labelNumero.AutoSize = true;
            this.labelNumero.Location = new System.Drawing.Point(285, 47);
            this.labelNumero.Name = "labelNumero";
            this.labelNumero.Size = new System.Drawing.Size(47, 13);
            this.labelNumero.TabIndex = 8;
            this.labelNumero.Text = "Numero:";
            // 
            // textBoxNumero
            // 
            this.textBoxNumero.Enabled = false;
            this.textBoxNumero.Location = new System.Drawing.Point(338, 44);
            this.textBoxNumero.Name = "textBoxNumero";
            this.textBoxNumero.Size = new System.Drawing.Size(100, 20);
            this.textBoxNumero.TabIndex = 9;
            // 
            // shapeContainer1
            // 
            this.shapeContainer1.Location = new System.Drawing.Point(0, 0);
            this.shapeContainer1.Margin = new System.Windows.Forms.Padding(0);
            this.shapeContainer1.Name = "shapeContainer1";
            this.shapeContainer1.Shapes.AddRange(new Microsoft.VisualBasic.PowerPacks.Shape[] {
            this.rectangleShape2,
            this.buttonModifier,
            this.buttonGererFichiers});
            this.shapeContainer1.Size = new System.Drawing.Size(597, 450);
            this.shapeContainer1.TabIndex = 11;
            this.shapeContainer1.TabStop = false;
            // 
            // rectangleShape2
            // 
            this.rectangleShape2.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.rectangleShape2.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.rectangleShape2.BorderColor = System.Drawing.SystemColors.ActiveCaption;
            this.rectangleShape2.CornerRadius = 5;
            this.rectangleShape2.Location = new System.Drawing.Point(10, 13);
            this.rectangleShape2.Name = "rectangleShape2";
            this.rectangleShape2.Size = new System.Drawing.Size(38, 40);
            this.rectangleShape2.Click += new System.EventHandler(this.buttonGererFichiers_Click);
            // 
            // buttonModifier
            // 
            this.buttonModifier.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonModifier.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.buttonModifier.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonModifier.CornerRadius = 5;
            this.buttonModifier.Location = new System.Drawing.Point(405, 301);
            this.buttonModifier.Name = "buttonModifier";
            this.buttonModifier.Size = new System.Drawing.Size(110, 32);
            this.buttonModifier.Click += new System.EventHandler(this.buttonModifier_Click);
            // 
            // buttonGererFichiers
            // 
            this.buttonGererFichiers.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.buttonGererFichiers.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.buttonGererFichiers.BorderColor = System.Drawing.SystemColors.ActiveCaption;
            this.buttonGererFichiers.CornerRadius = 5;
            this.buttonGererFichiers.Location = new System.Drawing.Point(404, 258);
            this.buttonGererFichiers.Name = "buttonGererFichiers";
            this.buttonGererFichiers.Size = new System.Drawing.Size(110, 32);
            this.buttonGererFichiers.Click += new System.EventHandler(this.buttonGererFichiers_Click);
            // 
            // labelGererFichiers
            // 
            this.labelGererFichiers.AutoSize = true;
            this.labelGererFichiers.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.labelGererFichiers.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelGererFichiers.Location = new System.Drawing.Point(410, 267);
            this.labelGererFichiers.Name = "labelGererFichiers";
            this.labelGererFichiers.Size = new System.Drawing.Size(103, 13);
            this.labelGererFichiers.TabIndex = 12;
            this.labelGererFichiers.Text = "Gérer les fichiers";
            this.labelGererFichiers.Click += new System.EventHandler(this.buttonGererFichiers_Click);
            // 
            // labelModifier
            // 
            this.labelModifier.AutoSize = true;
            this.labelModifier.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.labelModifier.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelModifier.Location = new System.Drawing.Point(434, 311);
            this.labelModifier.Name = "labelModifier";
            this.labelModifier.Size = new System.Drawing.Size(52, 13);
            this.labelModifier.TabIndex = 13;
            this.labelModifier.Text = "Modifier";
            this.labelModifier.Click += new System.EventHandler(this.buttonModifier_Click);
            // 
            // buttonRetour
            // 
            this.buttonRetour.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.buttonRetour.Image = ((System.Drawing.Image)(resources.GetObject("buttonRetour.Image")));
            this.buttonRetour.Location = new System.Drawing.Point(12, 15);
            this.buttonRetour.Name = "buttonRetour";
            this.buttonRetour.Size = new System.Drawing.Size(35, 36);
            this.buttonRetour.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.buttonRetour.TabIndex = 14;
            this.buttonRetour.TabStop = false;
            this.buttonRetour.Click += new System.EventHandler(this.buttonRetour_Click);
            // 
            // Modifier
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(597, 450);
            this.Controls.Add(this.buttonRetour);
            this.Controls.Add(this.labelModifier);
            this.Controls.Add(this.labelGererFichiers);
            this.Controls.Add(this.textBoxNumero);
            this.Controls.Add(this.labelNumero);
            this.Controls.Add(this.labelDescription);
            this.Controls.Add(this.labelNom);
            this.Controls.Add(this.textBoxDescription);
            this.Controls.Add(this.textBoxNom);
            this.Controls.Add(this.treeViewBD);
            this.Controls.Add(this.shapeContainer1);
            this.Name = "Modifier";
            this.Text = "Modifier";
            ((System.ComponentModel.ISupportInitialize)(this.buttonRetour)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TreeView treeViewBD;
        private System.Windows.Forms.TextBox textBoxNom;
        private System.Windows.Forms.TextBox textBoxDescription;
        private System.Windows.Forms.Label labelNom;
        private System.Windows.Forms.Label labelDescription;
        private System.Windows.Forms.Label labelNumero;
        private System.Windows.Forms.TextBox textBoxNumero;
        private Microsoft.VisualBasic.PowerPacks.ShapeContainer shapeContainer1;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape buttonGererFichiers;
        private System.Windows.Forms.Label labelGererFichiers;
        private System.Windows.Forms.Label labelModifier;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape buttonModifier;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape rectangleShape2;
        private System.Windows.Forms.PictureBox buttonRetour;
    }
}