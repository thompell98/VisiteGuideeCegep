package com.example.visiteguideecegep;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Toast;

public class MyCanvas extends View {

    Bitmap Star;
    Bitmap Map;
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


    public MyCanvas(Context context, Rect coordonnéActu, Rect coordonnéDes, String localA, String localD) {
        super(context);

        destination = coordonnéDes;
        positionA = coordonnéActu;

        //  nom_emplacement = emplacement;
        no_localA = localA;
        no_localD = localD;
        etageA = Character.toString(no_localA.charAt(2));
        etageB = Character.toString(no_localD.charAt(2));

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
        Paint paintt = new Paint();
        paint.setFilterBitmap(true);
        paintt.setColor(Color.RED);
        paintt.setStyle(Paint.Style.STROKE);
        paintt.setStrokeWidth(10);
        canvas.drawBitmap(Map, null, dest, paint);

        int heightt = getHeight() / 20;
        int widthh = getWidth() / 20;

        //  if (nom_emplacement != null) {

        canvas.drawLine(getLeft() + widthh * positionA.left, getBottom() - heightt * positionA.bottom, getLeft() + widthh * 11, getBottom() - heightt * 13, paintt);
        canvas.drawLine(getLeft() + widthh * 11, getBottom() - heightt *13, getLeft() + widthh * destination.left, getBottom() - heightt * destination.bottom, paintt);
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
                Toast toast = Toast.makeText(getContext(), "Touchez 2 fois pour changer d'étage ", Toast.LENGTH_LONG);
                toast.show();
                if (aa) {
                    if (etageB.equals("1")) {
                        Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1);
                        Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);
                        //   Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
                        Pin = null;
                        aa = false;
                        //Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);

                    }
                    if (etageB.equals("2")) {
                        Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage2);
                        Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);
                        // Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
                        aa = false;
                        Pin = null;
                        //  Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);
                    }
                    if (etageB.equals("3")) {
                        Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage2);
                        //   Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);
                        // Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);

                        // Star = BitmapFactor y.decodeResource(getResources(), R.drawable.star);
                    }
                } else {
                    if (etageA.equals("1")) {
                        Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1);
                        aa = true;
                        Star = null;
                        Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);

                        // Pin = null;
                    }
                    if (etageA.equals("2")) {
                        Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage2);
                        aa = true;
                        Star = null;
                        // Pin = null;
                        Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);

                    }
                }

            }
            invalidate();


            // addElementToDisplay(new Marqueur(pinmap, (e.getX()/zoomlevel1)+currX,(e.getY()/zoomlevel1)-currY));
            //   pinmap.setHeight(pinmap.getHeight()/(int)zoomlevel1);
            //    pinmap.setWidth(pinmap.getWidth()/(int)zoomlevel1);

    return true;
}
catch (OutOfMemoryError e1)
{
    Toast toast = Toast.makeText(getContext(), e1.toString(), Toast.LENGTH_LONG);toast.show();
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
        }
        catch (Exception e1)
        {
            Toast toast = Toast.makeText(getContext(), e1.toString(), Toast.LENGTH_LONG);toast.show();
            return false;
        }

    }

    private void init(@NonNull Context context) {

        if (!etageA.equals(etageB)) {
            Toast toast = Toast.makeText(getContext(), "Touchez 2 fois pour changer d'étage ", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Star = BitmapFactory.decodeResource(getResources(), R.drawable.star);

        }
        // Description=description;
        Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
        // final String etageA = Character.toString(no_localA.charAt(2));
        if (etageA.equals("1")) {
            Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1);

        } else if (etageA.equals("2")) {
            Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage2);

        }
//        else if (etageA.equals("3"))
//        {
//            Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1);
//
//        }
//        else if (etageA.equals("4"))
//        {
//            Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1);
//
//        }
//        else if (etageA.equals("5"))
//        {
//            Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1);
//
//        }

        this.mScaleFactor = MINIMUM_SCALE_FACTOR;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScalesListener());
        this.mMoveDetector = new GestureDetector(context, new MoveListener());

    }


}

