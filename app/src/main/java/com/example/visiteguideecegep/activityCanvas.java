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
    Intersection lesIntersections[] = new Intersection[9];
    boolean connecte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        mImageView = findViewById(R.id.imageView);
        setCanvas();
        ajouterLesIntersections();
        connecte = false;
        djikastra(lesIntersections[0], lesIntersections[8]);
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

    private void afficherTrajet(ArrayList<Intersection> lesIntersectionsARelier) {
        for (int cpt = 0; cpt < lesIntersectionsARelier.size() - 1; cpt++) {
            dessinerLigne(lesIntersectionsARelier.get(cpt), lesIntersectionsARelier.get(cpt + 1));
        }
    }

    private void ajouterLesIntersections() {
        lesIntersections[0] = new Intersection(0, 250, 20, new int[]{1});
        lesIntersections[1] = new Intersection(1, 250, 70, new int[]{7, 2});
        lesIntersections[2] = new Intersection(2, 250, 120, new int[]{1, 6});
        lesIntersections[3] = new Intersection(3, 250, 170, new int[]{2, 4, 8});
        lesIntersections[4] = new Intersection(4, 250, 220, new int[]{3, 5, 6});
        lesIntersections[5] = new Intersection(5, 200, 220, new int[]{4, 7});
        lesIntersections[6] = new Intersection(6, 300, 220, new int[]{4});
        lesIntersections[7] = new Intersection(7, 150, 220, new int[]{2, 3});
        lesIntersections[8] = new Intersection(8, 350, 220, new int[]{6});
        for (int cpt = 0; cpt < lesIntersections.length; cpt++) {
            dessinerIntersection(lesIntersections[cpt]);
        }
    }

    private void dessinerIntersection(Intersection uneIntersection) {
        Paint paint = new Paint();
        canvas.drawCircle((float) uneIntersection.x, (float) uneIntersection.y, 10, paint);
    }

    private double calculerDistanceEntreDeuxPoints(Intersection intersection1, Intersection intersection2) {
        return Math.sqrt(Math.pow(intersection2.x - intersection1.x, 2) + Math.pow(intersection2.y - intersection1.y, 2));
    }

    private void djikastra(Intersection intersectionDepart, Intersection intersectionATrouver) {
        final HashMap<Intersection, Double> distances = new HashMap<>();
        HashMap<Intersection, Intersection> precedent = new HashMap<>();
        ArrayList<Intersection> intersections = new ArrayList<>();
        intersections.addAll(Arrays.asList(lesIntersections));
        for(Intersection intersection : intersections){
            distances.put(intersection, Double.MAX_VALUE);
            precedent.put(intersection, null);
        }
        distances.put(intersectionDepart, (double) 0);

        while (intersections.size() != 0) {
            Collections.sort(intersections, new Comparator<Intersection>() {
                @Override
                public int compare(Intersection o1, Intersection o2) {
                    return distances.get(o1).compareTo(distances.get(o2));
                }
            });
            Intersection intersectionATraiter = intersections.get(0);
            intersections.remove(intersectionATraiter);
            for(int numeroIntersectionsReliees : intersectionATraiter.numerosIntersectionsReliees){
                Intersection intersectionDestinationEnTraitement = lesIntersections[numeroIntersectionsReliees];
                double distanceCourante = distances.get(intersectionATraiter) +  calculerDistanceEntreDeuxPoints(intersectionDestinationEnTraitement, intersectionATraiter);
                if (distanceCourante < distances.get(intersectionDestinationEnTraitement)){
                    distances.put(intersectionDestinationEnTraitement, distanceCourante);
                    precedent.put(intersectionDestinationEnTraitement, intersectionATraiter);
                }
            }
        }

        if (precedent.get(intersectionATrouver) == null){
            Toast.makeText(getApplicationContext(), "Aucun chemin trouvé", Toast.LENGTH_LONG).show();
        }

        Intersection intersectionTrajet = intersectionATrouver;
        ArrayList<Intersection> meilleurTrajet = new ArrayList<>();
        meilleurTrajet.add(intersectionTrajet);
        while (intersectionTrajet != intersectionDepart) {
            meilleurTrajet.add(precedent.get(intersectionTrajet));
            intersectionTrajet = precedent.get(intersectionTrajet);
        }
        afficherTrajet(meilleurTrajet);
    }

/*    private void djikastra() {
        if (intersectionDepart.numero < intersectionATrouver.numero) {
            Intersection intersectionTemp = intersectionDepart;
            intersectionDepart = intersectionATrouver;
            intersectionATrouver = intersectionTemp;
        }
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
                intersectionInitial.utilise = true;
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
    }*/
}
