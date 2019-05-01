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

public class activityCanvas extends AppCompatActivity {
    Canvas canvas;
    ImageView mImageView;
    Bitmap bitmap;
    Intersection lesIntersections[] = new Intersection[5];

    ArrayList<Intersection> lesIntersectionsARelier = new ArrayList<Intersection>();
    Intersection intersectionATrouver;
    Intersection intersectionDepart;
    boolean connecte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        mImageView = (ImageView) findViewById(R.id.imageView);
        setCanvas();
        ajouterLesIntersections();
        intersectionDepart = lesIntersections[4];
        intersectionATrouver = lesIntersections[2];
        connecte = false;
        djikatra();
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
        canvas.drawLine((float) intersection1.x, (float) intersection1.y, (float) intersection2.x, (float) intersection2.y, paint);
        mImageView.setImageBitmap(bitmap);
    }

    private void afficherTrajet() {
        for (int cpt = 0; cpt < lesIntersectionsARelier.size() - 1; cpt++) {
            dessinerLigne(lesIntersectionsARelier.get(cpt), lesIntersectionsARelier.get(cpt + 1));
        }
    }

    private void ajouterLesIntersections() {
        lesIntersections[0] = new Intersection(0, 30, 250, new int[]{1, 2});
        lesIntersections[1] = new Intersection(1, 60, 30, new int[]{0, 3});
        lesIntersections[2] = new Intersection(2, 100, 80, new int[]{0, 3, 4});
        lesIntersections[3] = new Intersection(3, 100, 50, new int[]{1, 2, 4});
        lesIntersections[4] = new Intersection(4, 95, 20, new int[]{1, 3});
        dessinerIntersection(lesIntersections[0]);
        dessinerIntersection(lesIntersections[1]);
        dessinerIntersection(lesIntersections[2]);
        dessinerIntersection(lesIntersections[3]);
        dessinerIntersection(lesIntersections[4]);
    }

    private void dessinerIntersection(Intersection uneIntersection) {
        Paint paint = new Paint();
        canvas.drawCircle((float) uneIntersection.x, (float) uneIntersection.y, 10, paint);
    }

    private double calculerDistanceEntreDeuxPoints(Intersection intersection1, Intersection intersection2) {
        return Math.sqrt(Math.pow(intersection2.x - intersection1.x, 2) + Math.pow(intersection2.y - intersection1.y, 2));
    }

    private void djikatra() {
        while (connecte == false) {
            if (lesIntersectionsARelier.size() == 0) {
                lesIntersectionsARelier.add(intersectionDepart);
                ajouterProchaineIntersectionAuTrajet(intersectionDepart);
            } else {
                ajouterProchaineIntersectionAuTrajet(lesIntersectionsARelier.get(lesIntersectionsARelier.size() - 1));
            }
        }
        afficherTrajet();
    }

    private void ajouterProchaineIntersectionAuTrajet(Intersection intersectionInitial) {
        for (int cpt = 0; cpt < intersectionInitial.numerosIntersectionsReliees.size(); cpt++) {
            if (intersectionInitial.numerosIntersectionsReliees.get(cpt) == intersectionATrouver.numero) {
                lesIntersectionsARelier.add(lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)]);
                connecte = true;
            }
        }

        if (connecte != true) {
            Intersection intersectionLaPlusProche = null;
            for (int cpt = 0; cpt < intersectionInitial.numerosIntersectionsReliees.size(); cpt++) {
                if (cpt == 0) {
                    intersectionLaPlusProche = lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)];
                } else if (lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)].utilise == false) {
                    if (calculerDistanceEntreDeuxPoints(intersectionInitial, lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)]) <
                            calculerDistanceEntreDeuxPoints(intersectionInitial, lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt - 1)])) {
                        intersectionLaPlusProche = lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)];
                    }
                }
            }
            intersectionInitial.utilise = true;
            lesIntersectionsARelier.add(intersectionLaPlusProche);
        }
    }
}
