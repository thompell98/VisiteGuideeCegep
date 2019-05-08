package com.example.visiteguideecegep;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_PERMISSION = 1;
    String local;
    private static final String TAG = "ConnexionBD";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Boolean connected = false;


    //   ArrayList<Integer>  group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trajet_activity);
        Intent i = getIntent();
        local = i.getStringExtra("numero");
        verifierConnexion();
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
//                if (connected) {
                    redirectionCamera();
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "Veuillez vérifier votre connexion", Toast.LENGTH_SHORT).show();
//                    verifierConnexion();
//                }
            }
        });
    }

//    private void redirectionCamera() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION);
//        } else {
//            Intent intent = new Intent(this, ScanActivity.class);
//            intent.putExtra("allo", false);
//            startActivity(intent);
//        }
private void redirectionCamera()
    {
                    Intent intent = new Intent(this, EmplacementActivity.class);
//            intent.putExtra("allo", false);
            startActivity(intent);
    }


//        Intent scan = new Intent(this, ScanActivity.class);
//        scan.putExtra("allo", false);
//        startActivity(scan);



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //if (MainActivity.class != null) {
                    Intent intent = new Intent(this, ScanActivity.class);
                    intent.putExtra("allo", false);
                    startActivity(intent);
                    //  }
                } else {
                    Toast.makeText(this, "Veuillez autoriser l'utilisation de la caméra", Toast.LENGTH_SHORT).show();
                }

        }
    }

    private void verifierConnexion() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        connected = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;
    }
}

