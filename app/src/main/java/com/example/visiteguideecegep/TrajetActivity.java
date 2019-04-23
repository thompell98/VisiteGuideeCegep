package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class TrajetActivity extends AppCompatActivity {
    String local;
    private static final String TAG = "ConnexionBD";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText actuel;
    EditText destination;
 //   ArrayList<Integer>  group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trajet_activity);
        actuel=findViewById(R.id.editText_emplacement);
        destination=findViewById(R.id.editText_destination);
        Intent i = getIntent();
        local = i.getStringExtra("numero");
        actuel.setText(local);
        setListener();

    }

    private void setListener() {
        findViewById(R.id.button_scanEdittext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionCamera();

            }
        });
        findViewById(R.id.button_rechercherTrajet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionCanvas();

            }
        });

    }

    private void redirectionCamera() {
        Intent scan = new Intent(this, ScanActivity.class);
        scan.putExtra("allo", false);
        startActivity(scan);
    }
    private void redirectionCanvas() {
        final Intent canvas = new Intent(this, EmplacementActivity.class);
        canvas.putExtra("actuel", actuel.getText().toString());
        canvas.putExtra("destination",destination.getText().toString() );
        String etageDuLocal = "Étage " + Character.toString( destination.getText().toString().charAt(2));
        String aileDuLocal = "Aile " + Character.toString( destination.getText().toString().charAt(0));
        db.collection("Étages").document(etageDuLocal).collection("Ailes").document(aileDuLocal).collection("Locaux")
                .whereEqualTo("Numero",destination.getText().toString())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Intent i = getIntent();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //  intente.putExtra("numero", document.get("Numero").toString());
                                //  intente.putExtra("nom", document.get("Nom").toString());
                                //  intente.putExtra("description", document.get("Description").toString());
                                ArrayList<Integer>group= (ArrayList<Integer>) document.get("Position");
                                canvas.putExtra("position", group);

                                Toast toast = Toast.makeText(getApplicationContext(),String.valueOf( group.get(1)), Toast.LENGTH_LONG);toast.show();
                                Toast toastt = Toast.makeText(getApplicationContext(),"gfdhd", Toast.LENGTH_LONG);toastt.show();

                            }


                            startActivity(canvas);

                        }
                        else {
                            Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });



    }
}