﻿namespace gestionAdminVisiteGuidee
{
    partial class GestionDesAdmins
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(GestionDesAdmins));
            this.listBoxAdmins = new System.Windows.Forms.ListBox();
            this.groupBoxSupprimer = new System.Windows.Forms.GroupBox();
            this.labelSupprimer = new System.Windows.Forms.Label();
            this.shapeContainer3 = new Microsoft.VisualBasic.PowerPacks.ShapeContainer();
            this.buttonSupprimer = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.groupBoxAjouter = new System.Windows.Forms.GroupBox();
            this.labelAjouter = new System.Windows.Forms.Label();
            this.labelConfirmerMotDePasse = new System.Windows.Forms.Label();
            this.labelMotDePasse = new System.Windows.Forms.Label();
            this.labelNomUtilisateur = new System.Windows.Forms.Label();
            this.labelPrenom = new System.Windows.Forms.Label();
            this.textBoxConfirmerMotDePasse = new System.Windows.Forms.TextBox();
            this.textBoxMotDePasse = new System.Windows.Forms.TextBox();
            this.textBoxNomUtilisateur = new System.Windows.Forms.TextBox();
            this.textBoxPrenom = new System.Windows.Forms.TextBox();
            this.shapeContainer2 = new Microsoft.VisualBasic.PowerPacks.ShapeContainer();
            this.buttonAjouter = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.rectangleShape2 = new Microsoft.VisualBasic.PowerPacks.RectangleShape();
            this.shapeContainer1 = new Microsoft.VisualBasic.PowerPacks.ShapeContainer();
            this.buttonRetour = new System.Windows.Forms.PictureBox();
            this.groupBoxSupprimer.SuspendLayout();
            this.groupBoxAjouter.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.buttonRetour)).BeginInit();
            this.SuspendLayout();
            // 
            // listBoxAdmins
            // 
            this.listBoxAdmins.FormattingEnabled = true;
            this.listBoxAdmins.Location = new System.Drawing.Point(6, 30);
            this.listBoxAdmins.Name = "listBoxAdmins";
            this.listBoxAdmins.Size = new System.Drawing.Size(260, 316);
            this.listBoxAdmins.Sorted = true;
            this.listBoxAdmins.TabIndex = 0;
            // 
            // groupBoxSupprimer
            // 
            this.groupBoxSupprimer.Controls.Add(this.labelSupprimer);
            this.groupBoxSupprimer.Controls.Add(this.listBoxAdmins);
            this.groupBoxSupprimer.Controls.Add(this.shapeContainer3);
            this.groupBoxSupprimer.Location = new System.Drawing.Point(48, 12);
            this.groupBoxSupprimer.Name = "groupBoxSupprimer";
            this.groupBoxSupprimer.Size = new System.Drawing.Size(272, 404);
            this.groupBoxSupprimer.TabIndex = 1;
            this.groupBoxSupprimer.TabStop = false;
            this.groupBoxSupprimer.Text = "Supprimer";
            // 
            // labelSupprimer
            // 
            this.labelSupprimer.AutoSize = true;
            this.labelSupprimer.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.labelSupprimer.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSupprimer.Location = new System.Drawing.Point(95, 367);
            this.labelSupprimer.Name = "labelSupprimer";
            this.labelSupprimer.Size = new System.Drawing.Size(63, 13);
            this.labelSupprimer.TabIndex = 15;
            this.labelSupprimer.Text = "Supprimer";
            this.labelSupprimer.Click += new System.EventHandler(this.buttonSupprimer_Click);
            // 
            // shapeContainer3
            // 
            this.shapeContainer3.Location = new System.Drawing.Point(3, 16);
            this.shapeContainer3.Margin = new System.Windows.Forms.Padding(0);
            this.shapeContainer3.Name = "shapeContainer3";
            this.shapeContainer3.Shapes.AddRange(new Microsoft.VisualBasic.PowerPacks.Shape[] {
            this.buttonSupprimer});
            this.shapeContainer3.Size = new System.Drawing.Size(266, 385);
            this.shapeContainer3.TabIndex = 1;
            this.shapeContainer3.TabStop = false;
            // 
            // buttonSupprimer
            // 
            this.buttonSupprimer.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.buttonSupprimer.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.buttonSupprimer.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.buttonSupprimer.CornerRadius = 5;
            this.buttonSupprimer.Location = new System.Drawing.Point(69, 340);
            this.buttonSupprimer.Name = "buttonSupprimer";
            this.buttonSupprimer.Size = new System.Drawing.Size(110, 32);
            this.buttonSupprimer.Click += new System.EventHandler(this.buttonSupprimer_Click);
            // 
            // groupBoxAjouter
            // 
            this.groupBoxAjouter.Controls.Add(this.labelAjouter);
            this.groupBoxAjouter.Controls.Add(this.labelConfirmerMotDePasse);
            this.groupBoxAjouter.Controls.Add(this.labelMotDePasse);
            this.groupBoxAjouter.Controls.Add(this.labelNomUtilisateur);
            this.groupBoxAjouter.Controls.Add(this.labelPrenom);
            this.groupBoxAjouter.Controls.Add(this.textBoxConfirmerMotDePasse);
            this.groupBoxAjouter.Controls.Add(this.textBoxMotDePasse);
            this.groupBoxAjouter.Controls.Add(this.textBoxNomUtilisateur);
            this.groupBoxAjouter.Controls.Add(this.textBoxPrenom);
            this.groupBoxAjouter.Controls.Add(this.shapeContainer2);
            this.groupBoxAjouter.Location = new System.Drawing.Point(349, 12);
            this.groupBoxAjouter.Name = "groupBoxAjouter";
            this.groupBoxAjouter.Size = new System.Drawing.Size(304, 404);
            this.groupBoxAjouter.TabIndex = 2;
            this.groupBoxAjouter.TabStop = false;
            this.groupBoxAjouter.Text = "Ajouter";
            // 
            // labelAjouter
            // 
            this.labelAjouter.AutoSize = true;
            this.labelAjouter.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.labelAjouter.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelAjouter.Location = new System.Drawing.Point(129, 266);
            this.labelAjouter.Name = "labelAjouter";
            this.labelAjouter.Size = new System.Drawing.Size(47, 13);
            this.labelAjouter.TabIndex = 14;
            this.labelAjouter.Text = "Ajouter";
            this.labelAjouter.Click += new System.EventHandler(this.buttonAjouter_Click);
            // 
            // labelConfirmerMotDePasse
            // 
            this.labelConfirmerMotDePasse.AutoSize = true;
            this.labelConfirmerMotDePasse.Location = new System.Drawing.Point(34, 204);
            this.labelConfirmerMotDePasse.Name = "labelConfirmerMotDePasse";
            this.labelConfirmerMotDePasse.Size = new System.Drawing.Size(120, 13);
            this.labelConfirmerMotDePasse.TabIndex = 8;
            this.labelConfirmerMotDePasse.Text = "Confirmer mot de passe:";
            // 
            // labelMotDePasse
            // 
            this.labelMotDePasse.AutoSize = true;
            this.labelMotDePasse.Location = new System.Drawing.Point(77, 155);
            this.labelMotDePasse.Name = "labelMotDePasse";
            this.labelMotDePasse.Size = new System.Drawing.Size(74, 13);
            this.labelMotDePasse.TabIndex = 7;
            this.labelMotDePasse.Text = "Mot de passe:";
            // 
            // labelNomUtilisateur
            // 
            this.labelNomUtilisateur.AutoSize = true;
            this.labelNomUtilisateur.Location = new System.Drawing.Point(64, 104);
            this.labelNomUtilisateur.Name = "labelNomUtilisateur";
            this.labelNomUtilisateur.Size = new System.Drawing.Size(87, 13);
            this.labelNomUtilisateur.TabIndex = 6;
            this.labelNomUtilisateur.Text = "Nom d\'utilisateur:";
            // 
            // labelPrenom
            // 
            this.labelPrenom.AutoSize = true;
            this.labelPrenom.Location = new System.Drawing.Point(105, 57);
            this.labelPrenom.Name = "labelPrenom";
            this.labelPrenom.Size = new System.Drawing.Size(46, 13);
            this.labelPrenom.TabIndex = 5;
            this.labelPrenom.Text = "Prenom:";
            // 
            // textBoxConfirmerMotDePasse
            // 
            this.textBoxConfirmerMotDePasse.Location = new System.Drawing.Point(157, 201);
            this.textBoxConfirmerMotDePasse.Name = "textBoxConfirmerMotDePasse";
            this.textBoxConfirmerMotDePasse.PasswordChar = '•';
            this.textBoxConfirmerMotDePasse.Size = new System.Drawing.Size(100, 20);
            this.textBoxConfirmerMotDePasse.TabIndex = 3;
            // 
            // textBoxMotDePasse
            // 
            this.textBoxMotDePasse.Location = new System.Drawing.Point(157, 152);
            this.textBoxMotDePasse.Name = "textBoxMotDePasse";
            this.textBoxMotDePasse.PasswordChar = '•';
            this.textBoxMotDePasse.Size = new System.Drawing.Size(100, 20);
            this.textBoxMotDePasse.TabIndex = 2;
            // 
            // textBoxNomUtilisateur
            // 
            this.textBoxNomUtilisateur.Location = new System.Drawing.Point(157, 101);
            this.textBoxNomUtilisateur.Name = "textBoxNomUtilisateur";
            this.textBoxNomUtilisateur.Size = new System.Drawing.Size(100, 20);
            this.textBoxNomUtilisateur.TabIndex = 1;
            // 
            // textBoxPrenom
            // 
            this.textBoxPrenom.Location = new System.Drawing.Point(157, 54);
            this.textBoxPrenom.Name = "textBoxPrenom";
            this.textBoxPrenom.Size = new System.Drawing.Size(100, 20);
            this.textBoxPrenom.TabIndex = 0;
            // 
            // shapeContainer2
            // 
            this.shapeContainer2.Location = new System.Drawing.Point(3, 16);
            this.shapeContainer2.Margin = new System.Windows.Forms.Padding(0);
            this.shapeContainer2.Name = "shapeContainer2";
            this.shapeContainer2.Shapes.AddRange(new Microsoft.VisualBasic.PowerPacks.Shape[] {
            this.buttonAjouter});
            this.shapeContainer2.Size = new System.Drawing.Size(298, 385);
            this.shapeContainer2.TabIndex = 4;
            this.shapeContainer2.TabStop = false;
            // 
            // buttonAjouter
            // 
            this.buttonAjouter.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonAjouter.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.buttonAjouter.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.buttonAjouter.CornerRadius = 5;
            this.buttonAjouter.Location = new System.Drawing.Point(95, 240);
            this.buttonAjouter.Name = "buttonAjouter";
            this.buttonAjouter.Size = new System.Drawing.Size(110, 32);
            this.buttonAjouter.Click += new System.EventHandler(this.buttonAjouter_Click);
            // 
            // rectangleShape2
            // 
            this.rectangleShape2.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.rectangleShape2.BackStyle = Microsoft.VisualBasic.PowerPacks.BackStyle.Opaque;
            this.rectangleShape2.BorderColor = System.Drawing.SystemColors.ActiveCaption;
            this.rectangleShape2.CornerRadius = 5;
            this.rectangleShape2.Location = new System.Drawing.Point(5, 15);
            this.rectangleShape2.Name = "rectangleShape2";
            this.rectangleShape2.Size = new System.Drawing.Size(39, 39);
            // 
            // shapeContainer1
            // 
            this.shapeContainer1.Location = new System.Drawing.Point(0, 0);
            this.shapeContainer1.Margin = new System.Windows.Forms.Padding(0);
            this.shapeContainer1.Name = "shapeContainer1";
            this.shapeContainer1.Shapes.AddRange(new Microsoft.VisualBasic.PowerPacks.Shape[] {
            this.rectangleShape2});
            this.shapeContainer1.Size = new System.Drawing.Size(704, 450);
            this.shapeContainer1.TabIndex = 3;
            this.shapeContainer1.TabStop = false;
            // 
            // buttonRetour
            // 
            this.buttonRetour.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.buttonRetour.Image = ((System.Drawing.Image)(resources.GetObject("buttonRetour.Image")));
            this.buttonRetour.Location = new System.Drawing.Point(7, 17);
            this.buttonRetour.Name = "buttonRetour";
            this.buttonRetour.Size = new System.Drawing.Size(35, 36);
            this.buttonRetour.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.buttonRetour.TabIndex = 15;
            this.buttonRetour.TabStop = false;
            this.buttonRetour.Click += new System.EventHandler(this.buttonRetour_Click);
            // 
            // GestionDesAdmins
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(704, 450);
            this.Controls.Add(this.buttonRetour);
            this.Controls.Add(this.groupBoxAjouter);
            this.Controls.Add(this.groupBoxSupprimer);
            this.Controls.Add(this.shapeContainer1);
            this.Name = "GestionDesAdmins";
            this.Text = "GestionDesAdmins";
            this.groupBoxSupprimer.ResumeLayout(false);
            this.groupBoxSupprimer.PerformLayout();
            this.groupBoxAjouter.ResumeLayout(false);
            this.groupBoxAjouter.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.buttonRetour)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListBox listBoxAdmins;
        private System.Windows.Forms.GroupBox groupBoxSupprimer;
        private System.Windows.Forms.GroupBox groupBoxAjouter;
        private System.Windows.Forms.TextBox textBoxConfirmerMotDePasse;
        private System.Windows.Forms.TextBox textBoxMotDePasse;
        private System.Windows.Forms.TextBox textBoxNomUtilisateur;
        private System.Windows.Forms.TextBox textBoxPrenom;
        private Microsoft.VisualBasic.PowerPacks.ShapeContainer shapeContainer3;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape buttonSupprimer;
        private System.Windows.Forms.Label labelPrenom;
        private Microsoft.VisualBasic.PowerPacks.ShapeContainer shapeContainer2;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape buttonAjouter;
        private System.Windows.Forms.Label labelConfirmerMotDePasse;
        private System.Windows.Forms.Label labelMotDePasse;
        private System.Windows.Forms.Label labelNomUtilisateur;
        private System.Windows.Forms.Label labelSupprimer;
        private System.Windows.Forms.Label labelAjouter;
        private Microsoft.VisualBasic.PowerPacks.RectangleShape rectangleShape2;
        private Microsoft.VisualBasic.PowerPacks.ShapeContainer shapeContainer1;
        private System.Windows.Forms.PictureBox buttonRetour;
    }
}