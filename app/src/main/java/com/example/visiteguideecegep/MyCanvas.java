package com.example.visiteguideecegep;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MotionEventCompat;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.MotionEvent.INVALID_POINTER_ID;

public class MyCanvas extends View {


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
    String no_local;
    String Description;
    Rect cordee;

    public MyCanvas(Context context, String emplacement,String local,String description, Rect corde) {
        super(context);
        cordee = corde;
        nom_emplacement = emplacement;
        no_local=local;
        Description=description;
        init(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = nom_emplacement +" "+ no_local+" "+Description;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        textPaint.setColor(0xFF000000);

        int width = (int) textPaint.measureText(text);
        StaticLayout.Builder builder = StaticLayout.Builder.obtain(text, 0, text.length(), textPaint, width);

        canvas.save();
        StaticLayout myStaticLayout = builder.build();
        canvas.scale(mScaleFactor, mScaleFactor, mScaleFocusX, mScaleFocusY);
        canvas.translate(mFocusX, mFocusY);
        Rect dest = new Rect(0, 0, getWidth(), getHeight());
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(Map, null, dest, paint);

        int heightt = getHeight() / 20;
        int widthh = getWidth() / 20;

         if (nom_emplacement != null) {
             canvas.drawBitmap(Pin, null, new Rect(getLeft() + widthh *cordee.left, getTop() + heightt * cordee.top, getRight() - widthh * cordee.right, getBottom() - heightt *cordee.bottom), paint);
             myStaticLayout.draw(canvas);
         }
         else
         {
             Toast.makeText(getContext(),"Emplacement non trouvé",Toast.LENGTH_LONG).show();
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
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            scrollBy((int) distanceX, (int) distanceY);
            mFocusX += -distanceX;
            mFocusY += -distanceY;
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleDetector.onTouchEvent(event);
        mMoveDetector.onTouchEvent(event);
        return true;
    }

    private void init(@NonNull Context context) {
        Map = BitmapFactory.decodeResource(getResources(), R.drawable.etage1bon);
        Pin = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
        this.mScaleFactor = MINIMUM_SCALE_FACTOR;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScalesListener());
        this.mMoveDetector = new GestureDetector(context, new MoveListener());
    }

}

