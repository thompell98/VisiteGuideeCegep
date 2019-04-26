package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class RechercheLocal extends AppCompatActivity {
    FirebaseFirestore db = null;
    ArrayList<String> lesMotsRecherche = null;
    ArrayList<String> lesNumerosDesLocaux = null;
    ArrayList<String> lesNomsDesLocaux = null;
    AutoCompleteTextView autoCompleteTextView = null;
    String numeroLocalActuel = null;
    String numeroLocalVoulu = null;
    ArrayList<Integer> positionActuelle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_local);
        setVariables();
        chargerFirestoreEnMemoire();
        obtenirDataScan();
        setListener();
    }

    private void setVariables()
    {
        db = FirebaseFirestore.getInstance();
        lesMotsRecherche = new ArrayList<String>();
        lesNumerosDesLocaux = new ArrayList<String>();
        lesNomsDesLocaux = new ArrayList<String>();
        autoCompleteTextView = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesMotsRecherche);
        autoCompleteTextView.setAdapter(adapter);
    }

    private void obtenirDataScan() {
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("numero") != null) {
            numeroLocalActuel = bundle.getString("numero");
            positionActuelle = bundle.getIntegerArrayList("positionD");
        }
    }

    private boolean verifierNumeroExiste(String unNumero)
    {
        for (int cpt = 0; cpt < lesNumerosDesLocaux.size(); cpt++) {
            if (unNumero.equals(lesNumerosDesLocaux.get(cpt))) {
                numeroLocalVoulu = lesNumerosDesLocaux.get(cpt);
                return true;
            }
        }
        return false;
    }

    private boolean verifierNomExiste(String unNom)
    {
        for (int cpt = 0; cpt < lesNomsDesLocaux.size(); cpt++) {
            if (unNom.equals(lesNomsDesLocaux.get(cpt))) {
                numeroLocalVoulu = lesNumerosDesLocaux.get(cpt);
                return true;
            }
        }
        return false;
    }

    private void setListener() {
        findViewById(R.id.buttonAfficherLeLocal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autoCompleteTextView.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Le champs ne doit pas être vide", Toast.LENGTH_LONG).show();
                }
                else {
                    if (verifierNumeroExiste(autoCompleteTextView.getText().toString()) ||
                        verifierNomExiste(autoCompleteTextView.getText().toString())) {
                        obtenirPositionLocalVoulu();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Aucun local n'a été trouvé", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void obtenirPositionLocalVoulu() {
       String etageDuLocal = "Étage " + Character.toString(numeroLocalVoulu.charAt(2));
       String aileDuLocal = "Aile " + Character.toString(numeroLocalVoulu.charAt(0));
       db.collection("Étages").document(etageDuLocal).collection("Ailes").document(aileDuLocal).collection("Locaux")
               .whereEqualTo("Numero", numeroLocalVoulu)
               .get()
               .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                   @Override
                   public void onComplete(@NonNull Task<QuerySnapshot> task) {
                       if (task.isSuccessful()) {
                           Intent trajet = new Intent(RechercheLocal.this, AffichageLocal.class);
                           for (QueryDocumentSnapshot document : task.getResult()) {
                               ArrayList<Integer> positionVoulue = (ArrayList<Integer>) document.get("Position");
                               trajet.putExtra("numeroLocalActuel", numeroLocalActuel);
                               trajet.putExtra("positionActuelle", positionActuelle);
                               trajet.putExtra("numeroLocalVoulu", numeroLocalVoulu);
                               trajet.putExtra("positionVoulue", positionVoulue);
                           }
                           startActivity(trajet);
                       } else {
                           Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_LONG).show();
                       }
                   }
               });
    }

    private void chargerFirestoreEnMemoire() {
        String[] ailes = new String[]{"A", "B", "C", "D", "E", "G", "N"};
        CollectionReference etagesRef = db.collection("Étages");
        for (int cpt = 0; cpt < 5; cpt++) {
            CollectionReference ailesRef = etagesRef.document("Étage " + String.valueOf(cpt)).collection("Ailes");
            for (int cpt2 = 0; cpt2 < 7; cpt2++) {
                CollectionReference locauxRef = ailesRef.document("Aile " + ailes[cpt2]).collection("Locaux");
                locauxRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {
                            lesNumerosDesLocaux.add(doc.getDocument().get("Numero").toString());
                            lesNomsDesLocaux.add(doc.getDocument().get("Nom").toString());
                            lesMotsRecherche.add(doc.getDocument().get("Numero").toString());
                            lesMotsRecherche.add(doc.getDocument().get("Nom").toString());
                        }
                    }
                });
            }
        }
    }
}
