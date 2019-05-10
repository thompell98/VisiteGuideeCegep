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
   // String Nom_emplacement;
    Rect coordonnéesActuel;
    Rect coordonnéesDestination;
    String localA;
    String localD;
   // String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        // Nom_emplacement = i.getStringExtra("nom");
      //  localA = i.getStringExtra("numeroLocalActuel");
      //  localD = i.getStringExtra("numeroLocalVoulu");
        localA="A-111";
        localD="C-260";
        //   Toast toast = Toast.makeText(getApplicationContext(),local, Toast.LENGTH_LONG);toast.show();

        //  description = i.getStringExtra("description");

       // ArrayList<Integer> positionDes = i.getIntegerArrayListExtra("positionVoulue");
     //   ArrayList<Integer> positionAct = i.getIntegerArrayListExtra("positionActuelle");
       //  if (positionDes != null&&positionAct!=null) {


//        Toast toast = Toast.makeText(getApplicationContext(),String.valueOf( positionA.get(1)), Toast.LENGTH_LONG);toast.show();

//        if (Nom_emplacement != null) {
        coordonnéesActuel=new Rect(13,12,5,7);
                coordonnéesDestination=new Rect(11,4,6,15);
         //    coordonnéesActuel = new Rect(Integer.parseInt(String.valueOf(positionAct.get(0))), Integer.parseInt(String.valueOf(positionAct.get(1))), Integer.parseInt(String.valueOf(positionAct.get(2))), Integer.parseInt(String.valueOf(positionAct.get(3))));
         //    coordonnéesDestination = new Rect(Integer.parseInt(String.valueOf(positionDes.get(0))), Integer.parseInt(String.valueOf(positionDes.get(1))), Integer.parseInt(String.valueOf(positionDes.get(2))), Integer.parseInt(String.valueOf(positionDes.get(3))));
// } else {
//            Intent emplacement = new Intent(this, CameraActivity.class);
//            startActivity(emplacement);
//        }
             //  mycanvas = new MyCanvas(this, Nom_emplacement, local, description, coordonnées);
             mycanvas = new MyCanvas(this, coordonnéesActuel, coordonnéesDestination, localA, localD);
             mycanvas.setBackgroundColor(Color.WHITE);
             setContentView(mycanvas);
         }
       // else {
       //    Toast toastt = Toast.makeText(getApplicationContext(), "Numero local incorect", Toast.LENGTH_LONG);
       //    toastt.show();
       //      Intent intent = new Intent(this, TrajetActivity.class);
       //    startActivity(intent);
       //}
   // }


}

