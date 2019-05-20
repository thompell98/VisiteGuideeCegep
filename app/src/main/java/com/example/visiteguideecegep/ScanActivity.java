package com.example.visiteguideecegep;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.zxing.Result;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView scannerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Boolean trajetperdu;
    String local;
    ArrayList<Integer> positionVoulue;
int intersectionLocalVoulu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        Intent i = getIntent();
        trajetperdu = i.getBooleanExtra("trajetPerdu", true);
        setContentView(scannerView);
        local = i.getStringExtra("numeroLocalVoulu");
        positionVoulue = i.getIntegerArrayListExtra("positionVoulue");
        intersectionLocalVoulu=i.getIntExtra("intersectionLocalVoulu",0);
    }


    @Override
    public void handleResult(Result result) {
        String etageDuLocal = "Étage " + Character.toString(result.getText().charAt(2));
        String aileDuLocal = "Aile " + Character.toString(result.getText().charAt(0));
        db.collection("Étages").document(etageDuLocal).collection("Ailes").document(aileDuLocal).collection("Locaux")
                .whereEqualTo("Numero", result.getText())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Intent intente = new Intent(ScanActivity.this, MainActivity.class);
                            Intent trajet = new Intent(ScanActivity.this, RechercheLocal.class);
                            Intent trajetPerdu = new Intent(ScanActivity.this, EmplacementActivity.class);

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                trajet.putExtra("numero", document.get("Numero").toString());
                                ArrayList<Integer> positionActuelle = (ArrayList<Integer>) document.get("Position");
                                int intersectionLocalActuel = document.getLong("Intersection").intValue();
                                trajet.putExtra("positionD", positionActuelle);
                                trajet.putExtra("intersectionLocalActuel", intersectionLocalActuel);
                                trajetPerdu.putExtra("numeroLocalActuel", document.get("Numero").toString());
                                trajetPerdu.putExtra("positionActuelle", positionActuelle);
                                trajetPerdu.putExtra("intersectionLocalActuel", intersectionLocalActuel);
                            }
                            if (trajetperdu) {
                                if (trajet.getStringExtra("numero") == null) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Local inexistant(ou vérifier votre connexion internet)", Toast.LENGTH_LONG);
                                    toast.show();
                                    startActivity(intente);
                                } else {
                                    startActivity(trajet);
                                }
                            } else {
                                trajetPerdu.putExtra("numeroLocalVoulu", local);
                                trajetPerdu.putExtra("intersectionLocalVoulu", intersectionLocalVoulu);
                                trajetPerdu.putExtra("positionVoulue", positionVoulue);
                                startActivity(trajetPerdu);
                                finish();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}