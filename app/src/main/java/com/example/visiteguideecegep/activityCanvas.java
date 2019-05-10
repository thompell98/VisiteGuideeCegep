package com.example.visiteguideecegep;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firestore.v1.StructuredQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class activityCanvas extends AppCompatActivity {
    Canvas canvas;
    ImageView mImageView;
    Bitmap bitmap;
    Djikastra djikastra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        mImageView = findViewById(R.id.imageView);
        //djikastra = new Djikastra(3, 7);
        setCanvas();
        //dessinerLesIntersections(djikastra.lesIntersections);
        //afficherTrajet(djikastra.meilleurTrajet);
    }

    private void setCanvas() {
        bitmap = Bitmap.createBitmap(
                500,
                300,
                Bitmap.Config.ARGB_8888
        );
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.LTGRAY);
        mImageView.setImageBitmap(bitmap);
    }

    private void dessinerLigne(Intersection intersection1, Intersection intersection2) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setAntiAlias(true);
        canvas.drawLine(intersection1.coordonnee.x, intersection1.coordonnee.y, intersection2.coordonnee.x, intersection2.coordonnee.y, paint);
        mImageView.setImageBitmap(bitmap);
    }

    private void afficherTrajet(ArrayList<Intersection> lesIntersectionsARelier) {
        for (int cpt = 0; cpt < lesIntersectionsARelier.size() - 1; cpt++) {
            dessinerLigne(lesIntersectionsARelier.get(cpt), lesIntersectionsARelier.get(cpt + 1));
        }
    }

    private void dessinerLesIntersections(Intersection[] lesIntersections) {
        for (int cpt = 0; cpt < lesIntersections.length; cpt++) {
            dessinerIntersection(lesIntersections[cpt]);
        }
    }

    private void dessinerIntersection(Intersection uneIntersection) {
        Paint paint = new Paint();
        canvas.drawCircle(uneIntersection.coordonnee.x, uneIntersection.coordonnee.y, 10, paint);
    }
}
