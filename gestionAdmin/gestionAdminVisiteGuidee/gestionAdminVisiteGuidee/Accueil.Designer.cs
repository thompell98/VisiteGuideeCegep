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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Accueil));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.labelBonjour = new System.Windows.Forms.Label();
            this.buttonVoirLocaux = new System.Windows.Forms.Button();
            this.buttonGererAdmins = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(84, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(269, 125);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(100, 150);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(234, 25);
            this.label1.TabIndex = 1;
            this.label1.Text = "Gestion visite guidée";
            // 
            // labelBonjour
            // 
            this.labelBonjour.AutoSize = true;
            this.labelBonjour.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelBonjour.Location = new System.Drawing.Point(152, 187);
            this.labelBonjour.Name = "labelBonjour";
            this.labelBonjour.Size = new System.Drawing.Size(64, 20);
            this.labelBonjour.TabIndex = 2;
            this.labelBonjour.Text = "Bonjour";
            // 
            // buttonVoirLocaux
            // 
            this.buttonVoirLocaux.Location = new System.Drawing.Point(146, 229);
            this.buttonVoirLocaux.Name = "buttonVoirLocaux";
            this.buttonVoirLocaux.Size = new System.Drawing.Size(143, 23);
            this.buttonVoirLocaux.TabIndex = 4;
            this.buttonVoirLocaux.Text = "Voir les locaux";
            this.buttonVoirLocaux.UseVisualStyleBackColor = true;
            this.buttonVoirLocaux.Click += new System.EventHandler(this.button2_Click);
            // 
            // buttonGererAdmins
            // 
            this.buttonGererAdmins.Location = new System.Drawing.Point(146, 280);
            this.buttonGererAdmins.Name = "buttonGererAdmins";
            this.buttonGererAdmins.Size = new System.Drawing.Size(143, 23);
            this.buttonGererAdmins.TabIndex = 6;
            this.buttonGererAdmins.Text = "Gérer les admins";
            this.buttonGererAdmins.UseVisualStyleBackColor = true;
            this.buttonGererAdmins.Click += new System.EventHandler(this.buttonGererAdmins_Click);
            // 
            // Accueil
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(440, 315);
            this.Controls.Add(this.buttonGererAdmins);
            this.Controls.Add(this.buttonVoirLocaux);
            this.Controls.Add(this.labelBonjour);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.pictureBox1);
            this.Name = "Accueil";
            this.Text = "Accueil";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelBonjour;
        private System.Windows.Forms.Button buttonVoirLocaux;
        private System.Windows.Forms.Button buttonGererAdmins;
    }
}