package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.TextView;
import android.widget.ZoomButtonsController;

import com.github.chrisbanes.photoview.PhotoView;


public class EmplacementActivity extends AppCompatActivity {


    Matrix matrix=new Matrix();
    Float scale=1f;
    ScaleGestureDetector SGD;
MyCanvas mycanvas;
    // private Paint paint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        mycanvas=new MyCanvas(this);
      //  mycanvas.setBackgroundColor(Color.RED);
//mycanvas.setBackgroundResource(R.drawable.caf);
mycanvas.setBackgroundColor(Color.WHITE);
      //  TextView nom = findViewById(R.id.textView_nom);
             //   nom.setText("Nom: " + i.getStringExtra("nom"));

        setContentView(mycanvas);

      //  TextView etage = findViewById(R.id.textView_etage);

       // test();

  //      PhotoView plan = findViewById(R.id.photo_view);
    //    plan.setImageResource(R.drawable.caf);
//        PhotoView pin = findViewById(R.id.photo_viewpin);
//
//        pin.setImageResource(R.drawable.pin);
//
//
//        //  if (i.getStringExtra("numero").equals("C-161")) {

//        etage.setText("Etage: " + i.getStringExtra("etage"));
//
//
//        //   }

    }


}

