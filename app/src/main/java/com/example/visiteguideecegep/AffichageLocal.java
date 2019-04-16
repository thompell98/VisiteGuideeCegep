package com.example.visiteguideecegep;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AffichageLocal extends AppCompatActivity {

    FirebaseStorage storageRef = null;
    StorageReference cafeteriaRef = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_local);
        setCloudStorage();
        downloadImage();
    }

    private void setCloudStorage()
    {
        storageRef = FirebaseStorage.getInstance("gs://visiteguideecegep-f394b.appspot.com");
        cafeteriaRef = storageRef.getReference("A-111/cafeteria.jpg");
    }

    private void downloadImage()
    {
        final long ONE_MEGABYTE = 1024 * 1024;
        cafeteriaRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
    }
}
