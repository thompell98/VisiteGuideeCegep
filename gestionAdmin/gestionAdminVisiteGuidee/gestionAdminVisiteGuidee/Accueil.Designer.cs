namespace gestionAdminVisiteGuidee
{
    partial class Accueil
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
            this.buttonRechercherLocal = new System.Windows.Forms.Button();
            this.textBoxNumeroLocal = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // buttonRechercherLocal
            // 
            this.buttonRechercherLocal.Location = new System.Drawing.Point(319, 140);
            this.buttonRechercherLocal.Name = "buttonRechercherLocal";
            this.buttonRechercherLocal.Size = new System.Drawing.Size(75, 23);
            this.buttonRechercherLocal.TabIndex = 0;
            this.buttonRechercherLocal.Text = "Rechercher";
            this.buttonRechercherLocal.UseVisualStyleBackColor = true;
            this.buttonRechercherLocal.Click += new System.EventHandler(this.buttonRechercherLocal_Click);
            // 
            // textBoxNumeroLocal
            // 
            this.textBoxNumeroLocal.Location = new System.Drawing.Point(319, 101);
            this.textBoxNumeroLocal.Name = "textBoxNumeroLocal";
            this.textBoxNumeroLocal.Size = new System.Drawing.Size(100, 20);
            this.textBoxNumeroLocal.TabIndex = 1;
            // 
            // Accueil
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.textBoxNumeroLocal);
            this.Controls.Add(this.buttonRechercherLocal);
            this.Name = "Accueil";
            this.Text = "Accueil";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonRechercherLocal;
        private System.Windows.Forms.TextBox textBoxNumeroLocal;
    }
}