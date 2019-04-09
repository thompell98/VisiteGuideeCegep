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
            this.treeViewBD = new System.Windows.Forms.TreeView();
            this.textBoxNom = new System.Windows.Forms.TextBox();
            this.textBoxDescription = new System.Windows.Forms.TextBox();
            this.labelNom = new System.Windows.Forms.Label();
            this.labelDescription = new System.Windows.Forms.Label();
            this.buttonModifier = new System.Windows.Forms.Button();
            this.labelNumero = new System.Windows.Forms.Label();
            this.textBoxNumero = new System.Windows.Forms.TextBox();
            this.buttonGererFichiers = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // treeViewBD
            // 
            this.treeViewBD.Location = new System.Drawing.Point(36, 12);
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
            // buttonModifier
            // 
            this.buttonModifier.Location = new System.Drawing.Point(417, 415);
            this.buttonModifier.Name = "buttonModifier";
            this.buttonModifier.Size = new System.Drawing.Size(75, 23);
            this.buttonModifier.TabIndex = 7;
            this.buttonModifier.Text = "Modifier";
            this.buttonModifier.UseVisualStyleBackColor = true;
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
            // buttonGererFichiers
            // 
            this.buttonGererFichiers.Location = new System.Drawing.Point(384, 270);
            this.buttonGererFichiers.Name = "buttonGererFichiers";
            this.buttonGererFichiers.Size = new System.Drawing.Size(135, 23);
            this.buttonGererFichiers.TabIndex = 10;
            this.buttonGererFichiers.Text = "Gérer les fichiers du local";
            this.buttonGererFichiers.UseVisualStyleBackColor = true;
            this.buttonGererFichiers.Click += new System.EventHandler(this.buttonGererFichiers_Click);
            // 
            // Modifier
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(666, 450);
            this.Controls.Add(this.buttonGererFichiers);
            this.Controls.Add(this.textBoxNumero);
            this.Controls.Add(this.labelNumero);
            this.Controls.Add(this.buttonModifier);
            this.Controls.Add(this.labelDescription);
            this.Controls.Add(this.labelNom);
            this.Controls.Add(this.textBoxDescription);
            this.Controls.Add(this.textBoxNom);
            this.Controls.Add(this.treeViewBD);
            this.Name = "Modifier";
            this.Text = "Modifier";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TreeView treeViewBD;
        private System.Windows.Forms.TextBox textBoxNom;
        private System.Windows.Forms.TextBox textBoxDescription;
        private System.Windows.Forms.Label labelNom;
        private System.Windows.Forms.Label labelDescription;
        private System.Windows.Forms.Button buttonModifier;
        private System.Windows.Forms.Label labelNumero;
        private System.Windows.Forms.TextBox textBoxNumero;
        private System.Windows.Forms.Button buttonGererFichiers;
    }
}