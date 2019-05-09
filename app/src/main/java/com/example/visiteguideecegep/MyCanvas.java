package com.example.visiteguideecegep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCanvas extends View {

    Bitmap Star;
    Bitmap Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1);
    Bitmap Pin;
    private static final float MINIMUM_SCALE_FACTOR = 1.0f;
    private static final float MAXIMUM_SCALE_FACTOR = 4.0f;


    private ScaleGestureDetector mScaleDetector;
    private GestureDetector mMoveDetector;

    private float mScaleFactor;
    private float mScaleFocusX;
    private float mScaleFocusY;
    private float mFocusX = 0.0f;
    private float mFocusY = 0.0f;

    String nom_emplacement;
    String no_localA;
    String no_localD;
    String Description;
    Rect positionA;
    Rect destination;
    Boolean aa = true;
    String etageA;
    String etageB;
    int[] images = new int[4];
    Bitmap bitmap;
    Djikastra djikastra;
    Canvas canvas;
    Context leContext;


    public MyCanvas(Context context, Rect coordonneActu, Rect coordonneDes, String localA, String localD) {
        super(context);
        leContext = context;
        Toast toast = Toast.makeText(getContext(), "Perdu? Revenez en arrière et appuiyez sur 'Perdu en chemin'", Toast.LENGTH_LONG);
        toast.show();
        destination = coordonneDes;
        positionA = coordonneActu;

        //  nom_emplacement = emplacement;
        no_localA = localA;
        no_localD = localD;
        etageA = Character.toString(no_localA.charAt(2));
        etageB = Character.toString(no_localD.charAt(2));

        djikastra = new Djikastra(3, 7);

        //  dessinerLesIntersections(djikastra.lesIntersections);
        //     afficherTrajet(djikastra.meilleurTrajet);
        init(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //  String text = nom_emplacement +" "+ no_local+" "+Description;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        textPaint.setColor(0xFF000000);

        canvas.save();

        canvas.scale(mScaleFactor, mScaleFactor, mScaleFocusX, mScaleFocusY);
        canvas.translate(mFocusX, mFocusY);
        Rect dest = new Rect(0, 0, getWidth(), getHeight());
        Paint paint = new Paint();
        // Paint paintt = new Paint();
        paint.setFilterBitmap(true);
        // paintt.setColor(Color.RED);
        //  paintt.setStyle(Paint.Style.STROKE);
      //  paintt.setStrokeWidth(10);
        Paint paintte = new Paint();
        paintte.setColor(Color.RED);
        paintte.setStyle(Paint.Style.STROKE);
        paintte.setStrokeWidth(8);
        paintte.setAntiAlias(true);
//
        int i=0;
        canvas.drawBitmap(Map, null, dest, paint);

        Paint painte = new Paint();

        Display display = ((Activity)leContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        float widthRatio = width / 1000f;
        float heightRatio = height / 1000f;

        for (int cpt = 0; cpt < djikastra.lesIntersections.length; cpt++) {
            canvas.drawCircle(djikastra.lesIntersections[cpt].x * widthRatio, djikastra.lesIntersections[cpt].y * heightRatio, 10, painte);
        }
        for (int cpt = 0; cpt < djikastra.meilleurTrajet.size() - 1; cpt++) {
              canvas.drawLine((float) djikastra.meilleurTrajet.get(cpt).x * widthRatio , (float)  djikastra.meilleurTrajet.get(cpt).y * heightRatio , (float)  djikastra.meilleurTrajet.get(cpt + 1).x * widthRatio , (float)  djikastra.meilleurTrajet.get(cpt + 1).y * heightRatio, paintte);
        }


        int heightt = getHeight() / 20;
        int widthh = getWidth() / 20;

        //  if (nom_emplacement != null) {

        // canvas.drawLine(getLeft() + widthh * positionA.left, getBottom() - heightt * positionA.bottom, getLeft() + widthh * 11, getBottom() - heightt * 13, paintt);
        //canvas.drawLine(getLeft() + widthh * 11, getBottom() - heightt * 13, getLeft() + widthh * destination.left, getBottom() - heightt * destination.bottom, paintt);
        //   canvas.drawBitmap(Pin, null, new Rect(getLeft() + widthh *cordee.left, getTop() + heightt * cordee.top, getRight() - widthh * cordee.right, getBottom() - heightt *cordee.bottom), paint);
        if (Pin != null) {
            canvas.drawBitmap(Pin, null, new Rect(getLeft() + widthh * positionA.left, getTop() + heightt * positionA.top, getRight() - widthh * positionA.right, getBottom() - heightt * positionA.bottom), paint);
        }
        if (Star != null) {
            canvas.drawBitmap(Star, null, new Rect(getLeft() + widthh * destination.left, getTop() + heightt * destination.top, getRight() - widthh * destination.right, getBottom() - heightt * destination.bottom), paint);
        }
        // canvas.drawBitmap(Pin, null, new Rect(getLeft() + widthh *15, getTop() + heightt * 4, getRight() - widthh * 3, getBottom() - heightt *15), paint);


        canvas.restore();

    }

    private class ScalesListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            mScaleFactor *= detector.getScaleFactor();
            mScaleFocusX = detector.getFocusX();
            mScaleFocusY = detector.getFocusY();
            mScaleFactor = Math.max(MINIMUM_SCALE_FACTOR, Math.min(mScaleFactor, MAXIMUM_SCALE_FACTOR));
            invalidate();
            return true;

        }


    }


    private class MoveListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {

            try {
                if (!etageA.equals(etageB)) {
                    Toast toast = Toast.makeText(getContext(), "Touchez 2 fois pour changer d'étage ", Toast.LENGTH_SHORT);
                    toast.show();
                    if (aa) {
                        Pin = null;
                        aa = false;
                        Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);
                        for (int i = 1; i < images.length + 1; i++) {
                            if (etageB.equals(String.valueOf(i))) {
                                Map = BitmapFactory.decodeResource(getResources(), images[i - 1]);
                            }
                        }
                    } else {

                        aa = true;
                        Star = null;
                        Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
                        for (int i = 1; i < images.length + 1; i++) {
                            if (etageA.equals(String.valueOf(i))) {
                                Map = BitmapFactory.decodeResource(getResources(), images[i - 1]);
                            }
                        }
                    }

                }
                invalidate();

                return true;

            } catch (OutOfMemoryError e1) {
                Toast toast = Toast.makeText(getContext(), e1.toString(), Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }

        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            scrollBy((int) distanceX, (int) distanceY);
            mFocusX += -distanceX;
            mFocusY += -distanceY;
            return true;
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        try {
            mScaleDetector.onTouchEvent(event);
            mMoveDetector.onTouchEvent(event);
            return true;
        } catch (Exception e1) {
            Toast toast = Toast.makeText(getContext(), e1.toString(), Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

    }

    private void init(@NonNull Context context) {
        images[0] = R.drawable.etage1;
        images[1] = R.drawable.etage2;
        images[2] = R.drawable.etage3;
        images[3] = R.drawable.etage4;
        //  images[4] = R.drawable.etage5;
        if (!etageA.equals(etageB)) {
            Toast toast = Toast.makeText(getContext(), "Touchez 2 fois pour changer d'étage ", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);
        }
        Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
        for (int i = 1; i < images.length + 1; i++) {
            if (etageA.equals(String.valueOf(i))) {
                Map = null;
                Map = BitmapFactory.decodeResource(getResources(), images[i - 1]);
            }
        }


        this.mScaleFactor = MINIMUM_SCALE_FACTOR;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScalesListener());
        this.mMoveDetector = new GestureDetector(context, new MoveListener());

    }
//    private void dessinerLigne(Intersection intersection1, Intersection intersection2) {

//    }

//    private void afficherTrajet(ArrayList<Intersection> lesIntersectionsARelier) {
//        for (int cpt = 0; cpt < lesIntersectionsARelier.size() - 1; cpt++) {
//            dessinerLigne(lesIntersectionsARelier.get(cpt), lesIntersectionsARelier.get(cpt + 1));
//        }
//    }

    //   private void dessinerLesIntersections(Intersection[] lesIntersections) {
    //      for (int cpt = 0; cpt < lesIntersections.length; cpt++) {
    //    //     dessinerIntersection(lesIntersections[cpt]);
    //  }
    //   }

//    private void dessinerIntersection(Intersection uneIntersection) {
//        Paint paint = new Paint();
//        canvas.drawCircle((float) uneIntersection.x, (float) uneIntersection.y, 10, paint);
//    }

}

