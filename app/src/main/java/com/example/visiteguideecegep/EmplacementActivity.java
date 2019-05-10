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
    Rect coordonnéesActuel;
    Rect coordonnéesDestination;
    String localA;
    String localD;
    int intersectionLocalA;
    int intersectionLocalB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        Bundle bundle = getIntent().getExtras();
        localA = i.getStringExtra("numeroLocalActuel");
        localD = i.getStringExtra("numeroLocalVoulu");
        intersectionLocalA = bundle.getInt("intersectionLocalActuel");
        intersectionLocalB = bundle.getInt("intersectionLocalVoulu");
        ArrayList<Integer> positionDes = i.getIntegerArrayListExtra("positionVoulue");
        ArrayList<Integer> positionAct = i.getIntegerArrayListExtra("positionActuelle");

        coordonnéesActuel = new Rect(Integer.parseInt(String.valueOf(positionAct.get(0))), Integer.parseInt(String.valueOf(positionAct.get(1))), Integer.parseInt(String.valueOf(positionAct.get(2))), Integer.parseInt(String.valueOf(positionAct.get(3))));
        coordonnéesDestination = new Rect(Integer.parseInt(String.valueOf(positionDes.get(0))), Integer.parseInt(String.valueOf(positionDes.get(1))), Integer.parseInt(String.valueOf(positionDes.get(2))), Integer.parseInt(String.valueOf(positionDes.get(3))));

        mycanvas = new MyCanvas(this, coordonnéesActuel, coordonnéesDestination, localA, localD, intersectionLocalA, intersectionLocalB);
        mycanvas.setBackgroundColor(Color.WHITE);
        setContentView(mycanvas);
    }


}

