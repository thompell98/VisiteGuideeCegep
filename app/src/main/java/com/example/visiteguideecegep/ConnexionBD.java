package com.example.visiteguideecegep;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ConnexionBD extends AppCompatActivity
{
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView textViewNumero = null;
    TextView textViewNom = null;
    TextView textViewEtage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_bd);
        setListeners();
    }

    private void setListeners()
    {
        findViewById(R.id.buttonSearch).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getLocalData();
            }
        });
    }

    private void getLocalData()
    {
        textViewNumero = (TextView) findViewById(R.id.textViewNumero);
        textViewNom = (TextView) findViewById(R.id.textViewNom);
        textViewEtage = (TextView) findViewById(R.id.textViewEtage);
        DocumentReference user = db.collection("Locaux").document("k8qwfJoomwxO4wcilSa3");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if (task.isSuccessful())
                {
                    DocumentSnapshot doc = task.getResult();
                    textViewNumero.setText(doc.get("numero").toString());
                    textViewNom.setText(doc.get("nom").toString());
                    textViewEtage.setText(doc.get("Etage").toString());
                }
            }
        }).addOnFailureListener(new OnFailureListener()
        {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(getApplicationContext(), "This is my Toast message!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
