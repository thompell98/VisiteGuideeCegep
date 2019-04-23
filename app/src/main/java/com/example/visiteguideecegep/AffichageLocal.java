package com.example.visiteguideecegep;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class AffichageLocal extends AppCompatActivity {
    FirebaseStorage storage = null;
    StorageReference storageRef = null;
    StorageReference imageRef = null;
    FirebaseAuth mAuth = null;
    ImageView imageView = null;
    ViewFlipper imageFlipper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_local);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageFlipper = (ViewFlipper)findViewById( R.id.image_flipper );
        createArrayOfFiles("A-111");
    }

    public void createArrayOfFiles(final String numeroLocal)
    {
        String aile = "Aile " + String.valueOf(numeroLocal.charAt(0));
        String etage = "Étage " + String.valueOf(numeroLocal.charAt(2));
        CollectionReference colRef = FirebaseFirestore.getInstance().collection("Étages").document(etage).collection("Ailes").document(aile).collection("Locaux");
        colRef.whereEqualTo("Numero", numeroLocal)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                List<String> lesFichiers = (List<String>) document.get("Fichiers");
                                setCloudStorage(numeroLocal);
                                downloadArrayOfImages(numeroLocal, lesFichiers);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Erreur", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void downloadArrayOfImages(String numeroLocal, List<String> lesFichiers)
    {
        for (int cpt = 0; cpt < lesFichiers.size(); cpt++)
        {
            downloadImage(numeroLocal, lesFichiers.get(cpt));
        }
    }

    private void setCloudStorage(String numeroLocal)
    {
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        mAuth.signInAnonymously();
        if (user == null) {
            signInAnonymously();
        }
    }

    private void signInAnonymously() {
        mAuth.signInAnonymously().addOnSuccessListener(this, new  OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
            }
        })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(getApplicationContext(), "Auth failure", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void downloadImage(String numeroLocal, String nomDuFichier)
    {
        imageRef = storageRef.child(numeroLocal + "/" + nomDuFichier);
        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(imageView);
                ViewGroup parent = (ViewGroup) imageView.getParent();
                if (parent != null) {
                    parent.removeView(imageView);
                }
                imageFlipper.addView(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
               Toast.makeText(getApplicationContext(), "Download image error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
