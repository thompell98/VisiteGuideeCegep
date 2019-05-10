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

    String no_localA;
    String no_localD;
    int intersectionLocalA;
    int intersectionLocalB;
    Rect positionA;
    Rect destination;
    Boolean aa = true;
    String etageA;
    String etageB;
    int numeroEtageA;
    int numeroEtageB;
    int numeroEtageCourant;
    ArrayList<Intersection> trajetCourant;

    int[] images = new int[5];
    Djikastra djikastra;
    Context leContext;


    public MyCanvas(Context context, Rect coordonneActu, Rect coordonneDes, String localA, String localD, int intersectionLocalA, int intersectionLocalB) {
        super(context);
        leContext = context;
        Toast toast = Toast.makeText(getContext(), "Perdu? Revenez en arrière et appuiyez sur 'Perdu en chemin'", Toast.LENGTH_LONG);
        toast.show();
        destination = coordonneDes;
        positionA = coordonneActu;

        no_localA = localA;
        no_localD = localD;
        this.intersectionLocalA = intersectionLocalA;
        this.intersectionLocalB = intersectionLocalB;
        etageA = Character.toString(no_localA.charAt(2));
        etageB = Character.toString(no_localD.charAt(2));
        numeroEtageA = Integer.parseInt(etageA) - 1;
        numeroEtageB = Integer.parseInt(etageB) - 1;
        numeroEtageCourant = numeroEtageA;
        djikastra = new Djikastra();
        djikastra.trouverMeilleurTrajet(intersectionLocalA, intersectionLocalB, numeroEtageA, numeroEtageB);
        trajetCourant = djikastra.trajetEtagePrincipal;
        init(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        textPaint.setColor(0xFF000000);

        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor, mScaleFocusX, mScaleFocusY);
        canvas.translate(mFocusX, mFocusY);
        Rect dest = new Rect(0, 0, getWidth(), getHeight());
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(Map, null, dest, paint);
        Display display = ((Activity) leContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        float widthRatio = size.x / 1000f;
        float heightRatio = size.y / 1000f;
        Paint ligneTrajet = new Paint();
        ligneTrajet.setColor(Color.RED);
        ligneTrajet.setStyle(Paint.Style.STROKE);
        ligneTrajet.setStrokeWidth(20 * widthRatio);
        ligneTrajet.setAntiAlias(true);
        Paint paintte2 = new Paint();
        paintte2.setColor(Color.RED);

        //for (int cpt = 0; cpt < djikastra.lesIntersections[numeroEtageCourant].length; cpt++) {
        //    if (djikastra.lesIntersections[numeroEtageCourant][cpt] != null){
        //        canvas.drawCircle(djikastra.lesIntersections[numeroEtageCourant][cpt].coordonnee.x * widthRatio, djikastra.lesIntersections[numeroEtageCourant][cpt].coordonnee.y * heightRatio, 5 * heightRatio, painte);
        //    }
        //}

        for (int cpt = 0; cpt < trajetCourant.size() - 1; cpt++) {
            canvas.drawLine(trajetCourant.get(cpt).coordonnee.x * widthRatio, trajetCourant.get(cpt).coordonnee.y * heightRatio, trajetCourant.get(cpt + 1).coordonnee.x * widthRatio, trajetCourant.get(cpt + 1).coordonnee.y * heightRatio, ligneTrajet);
            canvas.drawCircle(trajetCourant.get(cpt).coordonnee.x * widthRatio, trajetCourant.get(cpt).coordonnee.y * heightRatio, 10 * widthRatio, paintte2);
            canvas.drawCircle(trajetCourant.get(cpt + 1).coordonnee.x * widthRatio, trajetCourant.get(cpt + 1).coordonnee.y * heightRatio, 10 * widthRatio, paintte2);
        }
        int heightt = getHeight() / 20;
        int widthh = getWidth() / 20;

        if (Pin != null) {
            canvas.drawBitmap(Pin, null, new Rect(getLeft() + widthh * positionA.left, getTop() + heightt * positionA.top, getRight() - widthh * positionA.right, getBottom() - heightt * positionA.bottom), paint);
        }
        if (Star != null) {
            canvas.drawBitmap(Star, null, new Rect(getLeft() + widthh * destination.left, getTop() + heightt * destination.top, getRight() - widthh * destination.right, getBottom() - heightt * destination.bottom), paint);
        }
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

                    if (aa) {
                        Pin = null;
                        aa = false;
                        Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);
                        for (int i = 1; i < images.length + 1; i++) {
                            if (etageB.equals(String.valueOf(i))) {
                                Map = BitmapFactory.decodeResource(getResources(), images[i - 1]);
                                numeroEtageCourant = numeroEtageB;
                                trajetCourant = djikastra.trajetEtageFinal;
                            }
                        }
                        Toast toast = Toast.makeText(getContext(), "Touchez 2 fois pour aller à l'étage " + etageA, Toast.LENGTH_LONG);
                        toast.show();
                    } else {

                        aa = true;
                        Star = null;
                        Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
                        for (int i = 1; i < images.length + 1; i++) {
                            if (etageA.equals(String.valueOf(i))) {
                                Map = BitmapFactory.decodeResource(getResources(), images[i - 1]);
                                numeroEtageCourant = numeroEtageA;
                                trajetCourant = djikastra.trajetEtagePrincipal;
                            }
                        }
                        Toast toast = Toast.makeText(getContext(), "Touchez 2 fois pour aller à l'étage " + etageB, Toast.LENGTH_LONG);
                        toast.show();
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
        images[4] = R.drawable.etage5;
        if (!etageA.equals(etageB)) {
            Toast toast = Toast.makeText(getContext(), "Touchez 2 fois pour aller à l'étage " + etageB, Toast.LENGTH_SHORT);
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


}

