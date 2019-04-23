package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class EmplacementActivity extends AppCompatActivity {


    MyCanvas mycanvas;
    String Nom_emplacement;
    Rect coordonnées=new Rect(0,0,0,0);
    Rect coordonnéesDestination;
    String local;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
       // Nom_emplacement = i.getStringExtra("nom");
        local = i.getStringExtra("actuel");
     //   Toast toast = Toast.makeText(getApplicationContext(),local, Toast.LENGTH_LONG);toast.show();

        //  description = i.getStringExtra("description");

        ArrayList<Integer> position = i.getIntegerArrayListExtra("position");
//        Toast toast = Toast.makeText(getApplicationContext(),String.valueOf( position.get(1)), Toast.LENGTH_LONG);toast.show();

//        if (Nom_emplacement != null) {
//                             coordonnées = new Rect(Integer.parseInt(String.valueOf(group.get(0))), Integer.parseInt(String.valueOf(group.get(1))), Integer.parseInt(String.valueOf(group.get(2))), Integer.parseInt(String.valueOf(group.get(3))));
//  coordonnées = new Rect(Integer.parseInt(String.valueOf(position.get(0))), Integer.parseInt(String.valueOf(position.get(1))), Integer.parseInt(String.valueOf(position.get(2))), Integer.parseInt(String.valueOf(position.get(3))));
// } else {
//            Intent emplacement = new Intent(this, CameraActivity.class);
//            startActivity(emplacement);
//        }
      //  mycanvas = new MyCanvas(this, Nom_emplacement, local, description, coordonnées);
        mycanvas = new MyCanvas(this,coordonnées);
        mycanvas.setBackgroundColor(Color.WHITE);
        setContentView(mycanvas);
    }


}

