package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class TrajetActivity extends AppCompatActivity {
    String local;
    private static final String TAG = "ConnexionBD";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView actuel;
    EditText destination;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    //   ArrayList<Integer>  group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trajet_activity);
        actuel = findViewById(R.id.textViewEmplacement);
        destination = findViewById(R.id.editText_destination);
        Intent i = getIntent();
        local = i.getStringExtra("numero");
        actuel.setText(local);
//        String etageDuLocal = "Étage " + Character.toString(destination.getText().charAt(2));
//        String aileDuLocal = "Aile " + Character.toString(destination.getText().charAt(0));
//        db.collection("Étages").document(etageDuLocal).collection("Ailes").document(aileDuLocal).collection("Locaux")
//
//     const start = destination;
//const end = startText + '\uf8ff';
//
//        return this.afs.collection('movies', ref =>
//                ref
//                        .orderBy('title')
//                        .limit(5)
//                        .startAt(start)
//                        .endAt(end)
//  )


        //Create a new ArrayAdapter with your context and the simple layout for the dropdown menu provided by Android
        final ArrayAdapter<String> autoComplete = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        //Child the root before all the push() keys are found and add a ValueEventListener()
        database.child("AutoCompleteOptions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Basically, this says "For each DataSnapshot *Data* in dataSnapshot, do what's inside the method.
                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()){
                    //Get the suggestion by childing the key of the string you want to get.
                    String suggestion = suggestionSnapshot.child("Numero").getValue(String.class);
                    //Add the retrieved string to the list
                    autoComplete.add(suggestion);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        AutoCompleteTextView ACTV= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ACTV.setAdapter(autoComplete);
        setListener();

//        if (actuel.getText().toString().equals(""))
//        {
//            Toast toast = Toast.makeText(getApplicationContext(), "Local inexistant", Toast.LENGTH_LONG);toast.show();
//
//        }
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
        if (!actuel.getText().toString().equals("") && !destination.getText().toString().equals("") && destination.getText().toString().length() >= 5) {


            canvas.putExtra("actuel", actuel.getText().toString());
            canvas.putExtra("destination", destination.getText().toString());
              if (!destination.getText().toString().equals(actuel.getText().toString())) {
                  String etageDuLocal = "Étage " + Character.toString(destination.getText().toString().charAt(2));
                  String aileDuLocal = "Aile " + Character.toString(destination.getText().toString().charAt(0));
                  db.collection("Étages").document(etageDuLocal).collection("Ailes").document(aileDuLocal).collection("Locaux")
                          .whereEqualTo("Numero", destination.getText().toString())
                          .get()
                          .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                              @Override
                              public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                  if (task.isSuccessful()) {

                                      for (QueryDocumentSnapshot document : task.getResult()) {
                                          //  intente.putExtra("numero", document.get("Numero").toString());
                                          //  intente.putExtra("nom", document.get("Nom").toString());
                                          //  intente.putExtra("description", document.get("Description").toString());
                                          ArrayList<Integer> group = (ArrayList<Integer>) document.get("Position");
                                          canvas.putExtra("position", group);
                                          Intent i = getIntent();
                                          ArrayList<Integer> position = i.getIntegerArrayListExtra("positionD");
                                          canvas.putExtra("positionA", position);

                                      }
                                      // Intent i = getIntent();
                                      // ArrayList<Integer> positionD = i.getIntegerArrayListExtra("position");
                                      // ArrayList<Integer> positionA = i.getIntegerArrayListExtra("positionA");
                                      //    if (canvas.getStringExtra("numero")==null)
                                      if (canvas.getIntegerArrayListExtra("positionA") == null && canvas.getIntegerArrayListExtra("position") == null) {
                                          Toast toast = Toast.makeText(getApplicationContext(), "Local inexistant(ou véréfier votre connexion internet)", Toast.LENGTH_LONG);
                                          toast.show();

                                      } else {
                                          startActivity(canvas);

                                      }
                                      // if (positionA != null&&positionD!=null) {
                                      // } else {
                                      //     Toast toastt = Toast.makeText(getApplicationContext(), "Numero local incorect", Toast.LENGTH_LONG);
                                      //     toastt.show();

                                      // }

                                  } else {
                                      Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_LONG).show();
                                  }
                              }
                          });

              }
              else
              {
                  Toast toast = Toast.makeText(getApplicationContext(), "Vous êtes à votre destination", Toast.LENGTH_LONG);toast.show();

              }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "champs incomplets", Toast.LENGTH_LONG);toast.show();
        }
    }
}
