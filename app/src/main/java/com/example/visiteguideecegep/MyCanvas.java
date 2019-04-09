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

    //    Float scale = 1f;
//    ScaleGestureDetector SGD;
    Bitmap bm;
    Bitmap bmm;
    //    float startX;
//    float startY;
//    float ammountX;
//    float ammountY;
//    private int mActivePointerId = INVALID_POINTER_ID;
    private static final float MINIMUM_SCALE_FACTOR = 1.0f;
    private static final float MAXIMUM_SCALE_FACTOR = 5.0f;
    //   private Picture mPicture;
    private Paint mPaint;
    private ScaleGestureDetector mScaleDetector;
    private GestureDetector mMoveDetector;

    private float mScaleFactor;
    private float mScaleFocusX;
    private float mScaleFocusY;
    private float mFocusX = 0.0f;
    private float mFocusY = 0.0f;

    private float mImageHeight;
    private float mImageWidth;
    private int mViewHeight;
    private int mViewWidth;
    //   private RectF mDrawingRect;
    String mText = "This is some text.";
    TextPaint mTextPaint;
    // StaticLayout mStaticLayout;
    String aa;

    public MyCanvas(Context context, String emp) {
        super(context);
        aa = emp;
        init(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text = "fdsd";
        Toast.makeText(getContext(), aa, Toast.LENGTH_SHORT).show();
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        textPaint.setColor(0xFF000000);

        int width = (int) textPaint.measureText(text);
        StaticLayout.Builder builder = StaticLayout.Builder.obtain(text, 0, text.length(), textPaint, width);

        canvas.save();
        StaticLayout myStaticLayout = builder.build();
//        canvas.scale(scale, scale);
//        canvas.translate(ammountX,ammountY);

        // canvas.translate(getPaddingLeft(), getPaddingTop());


        canvas.scale(mScaleFactor, mScaleFactor, mScaleFocusX, mScaleFocusY);

        canvas.translate(mFocusX, mFocusY);
        Rect dest = new Rect(0, 0, getWidth(), getHeight());
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bm, null, dest, paint);
        //canvas.drawText("dsgjsdklgh",25, 25, paint);
        myStaticLayout.draw(canvas);


        //   nom.setText("Nom: " + i.getStringExtra("nom"));
        if (aa.equals("caf")) {
            canvas.drawBitmap(bmm, null, new Rect(400, 600, 500, 700), paint);
        }
        if (aa.equals("piscine")) {
            canvas.drawBitmap(bmm, null, new Rect(100, 1300, 200, 1400), paint);
        }
        //   canvas.drawBitmap(bmp,null, new Rect(0,0,800,800),null);

        canvas.restore();

        //  SGD=new ScaleGestureDetector(getContext(),new ScalesListener());
        //    canvas.setMatrix(matrix);

//        paint.setColor(Color.WHITE);
//
//        canvas.drawPaint(paint);
//
//        paint.setColor(Color.RED);
//        paint.setTextSize(30);


    }

    private class ScalesListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
//            scale = scale * detector.getScaleFactor();
//            scale = Math.max(1f, Math.min(scale, 5f));
//            invalidate();
//            return true;

            mScaleFactor *= detector.getScaleFactor();
            mScaleFocusX = detector.getFocusX();
            mScaleFocusY = detector.getFocusY();
            mScaleFactor = Math.max(MINIMUM_SCALE_FACTOR, Math.min(mScaleFactor, MAXIMUM_SCALE_FACTOR));

            invalidate();

            return true;

        }

    }

    private class MoveListener extends GestureDetector.SimpleOnGestureListener {

//        @Override
//        public boolean onDown(MotionEvent e) {
//            return true;
//        }

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
//        SGD.onTouchEvent(event);
//
//
//    if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
//       startX = event.getX();
//       startY = event.getY();
//       return true;
//   }else if(event.getActionMasked() == MotionEvent.ACTION_MOVE){
//       ammountX = event.getX() - startX;
//       ammountY = event.getY() - startY;
//       return true;
//   }
//   return super.onTouchEvent(event);
//
        return true;

    }

    private void init(@NonNull Context context) {
        bm = BitmapFactory.decodeResource(getResources(), R.drawable.caf);
        bmm = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
        //   SGD = new ScaleGestureDetector(context, new ScalesListener());
//        mTextPaint = new TextPaint();
//        mTextPaint.setAntiAlias(true);
//        mTextPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
//        mTextPaint.setColor(0xFF000000);
//
//        // default to a single line of text
//        int width = (int) mTextPaint.measureText(mText);
//        mStaticLayout = new StaticLayout(mText, mTextPaint, (int) width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);

        this.mScaleFactor = MINIMUM_SCALE_FACTOR;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScalesListener());
        this.mMoveDetector = new GestureDetector(context, new MoveListener());
    }

}

