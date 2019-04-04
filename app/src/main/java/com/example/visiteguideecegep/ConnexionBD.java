package com.example.visiteguideecegep;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ConnexionBD extends AppCompatActivity
{
    private static final String TAG = "ConnexionBD";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView textViewNumero = null;
    TextView textViewNom = null;
    TextView textViewEtage = null;
    EditText editTextSearch = null;

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
                editTextSearch = (EditText) findViewById(R.id.editTextSearch);
                String numeroLocal = editTextSearch.getText().toString();
                getLocalData(numeroLocal);
            }
        });
    }

    private void getDataFromDocumentPath(String documentPath)
    {
        textViewNumero = (TextView) findViewById(R.id.textViewNumero);
        textViewNom = (TextView) findViewById(R.id.textViewNom);
        textViewEtage = (TextView) findViewById(R.id.textViewEtage);
        DocumentReference user = db.collection("Locaux").document(documentPath);
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
                Toast.makeText(getApplicationContext(), "Erreur", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getLocalData(String numeroLocal)
    {
        textViewNumero = (TextView) findViewById(R.id.textViewNumero);
        textViewNom = (TextView) findViewById(R.id.textViewNom);
        textViewEtage = (TextView) findViewById(R.id.textViewEtage);
        db.collection("Locaux")
                .whereEqualTo("Numero", numeroLocal)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                textViewNumero.setText(document.get("Numero").toString());
                                textViewNom.setText(document.get("Nom").toString());
                                textViewEtage.setText(document.get("Etage").toString());
                            }
                        }
                        else
                            {
                                Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
