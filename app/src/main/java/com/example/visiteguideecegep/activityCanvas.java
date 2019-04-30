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

public class activityCanvas extends AppCompatActivity
{
    Canvas canvas;
    ImageView mImageView;
    Bitmap bitmap;
    Intersection lesIntersections[] = new Intersection[5];
    Intersection intersectionATrouver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        mImageView = (ImageView) findViewById(R.id.imageView);
        setCanvas();
        ajouterLesIntersections();
        dessinerIntersection(lesIntersections[0]);
        dessinerIntersection(lesIntersections[1]);
        dessinerIntersection(lesIntersections[2]);
        intersectionATrouver = lesIntersections[2];
        trouverCheminLePlusCourt(lesIntersections[0]);
    }

    private void setCanvas()
    {
        bitmap = Bitmap.createBitmap(
                500,
                300,
                Bitmap.Config.ARGB_8888
        );
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.LTGRAY);
        mImageView.setImageBitmap(bitmap);
    }

    private void dessinerLigne(Intersection intersection1, Intersection intersection2)
    {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setAntiAlias(true);
        canvas.drawLine((float) intersection1.x, (float) intersection1.y, (float) intersection2.x, (float) intersection2.y, paint);
        mImageView.setImageBitmap(bitmap);
    }

    private void ajouterLesIntersections()
    {
       lesIntersections[0] = new Intersection(0, 30, 250,  new int[]{1, 2});
       lesIntersections[1] = new Intersection(1, 60, 30,  new int[]{0, 2});
       lesIntersections[2] = new Intersection(2, 100, 80,  new int[]{0, 1});
    }

    private void dessinerIntersection(Intersection uneIntersection)
    {
        Paint paint = new Paint();
        canvas.drawCircle((float) uneIntersection.x, (float) uneIntersection.y, 10, paint);
    }

    private double calculerDistanceEntreDeuxPoints(Intersection intersection1, Intersection intersection2)
    {
        return Math.sqrt(Math.pow(intersection2.x - intersection1.x, 2) + Math.pow(intersection2.y - intersection1.y, 2));
    }

    private void trouverCheminLePlusCourt(Intersection intersectionInitial)
    {
        double[] lesLongueursPossibles;

        for(int cpt = 0; cpt < intersectionInitial.numerosIntersectionsReliees.size(); cpt++)
        {
            //if (lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)] != )
        }
        intersectionInitial.utilise = true;

    }

}
