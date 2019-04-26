package com.example.visiteguideecegep;

import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
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
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class RechercheLocal extends AppCompatActivity {
    FirebaseFirestore db = null;
    ArrayList<String> lesMotsPourRecherche = null;
    AutoCompleteTextView autoCompleteTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_local);
        db = FirebaseFirestore.getInstance();
        lesMotsPourRecherche = new ArrayList<String>();
        autoCompleteTextView = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesMotsPourRecherche);
        autoCompleteTextView.setAdapter(adapter);
        chargerFirestoreEnMemoire();
    }

    private void chargerFirestoreEnMemoire()
    {
        String[] ailes = new String[]{"A", "B", "C", "D", "E", "G", "N"};
        CollectionReference etagesRef = db.collection("Étages");
        for (int cpt = 0; cpt < 5; cpt++)
        {
            CollectionReference ailesRef = etagesRef.document("Étage " + String.valueOf(cpt)).collection("Ailes");
            for (int cpt2 = 0; cpt2 < 7; cpt2++)
            {
                CollectionReference locauxRef = ailesRef.document("Aile " + ailes[cpt2]).collection("Locaux");
                locauxRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                            if (doc.getDocument().get("Numero") != null) {
                                lesMotsPourRecherche.add(doc.getDocument().get("Numero").toString());
                            }
                            if (doc.getDocument().get("Nom") != null) {
                                lesMotsPourRecherche.add(doc.getDocument().get("Nom").toString());
                            }
                        }
                    }
                });
            }
        }
    }
}
