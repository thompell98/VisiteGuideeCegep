package com.example.visiteguideecegep;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.MotionEvent.INVALID_POINTER_ID;

public class MyCanvas extends View {

    Float scale = 1f;
    ScaleGestureDetector SGD;
    Bitmap bm;
    Bitmap bmm;
    float x,y;
    private int mActivePointerId = INVALID_POINTER_ID;
    public MyCanvas(Context context) {
        super(context);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(scale, scale);
        canvas.translate(50,50);
        Rect dest = new Rect(0, 0, getWidth(), getHeight());
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bm, null, dest, paint);
        canvas.drawBitmap(bmm, null, new Rect(200,200,300,300), paint);
        //   canvas.drawBitmap(bmp,null, new Rect(0,0,800,800),null);
        canvas.restore();
        //  SGD=new ScaleGestureDetector(getContext(),new ScalesListener());
        //    canvas.setMatrix(matrix);

    }

    private class ScalesListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale = scale * detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5f));
            invalidate();
            return true;

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        SGD.onTouchEvent(event);


//        switch(event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN: {
//
//            }
//            break;
//
//            case MotionEvent.ACTION_MOVE:
//            {
//                x=(int)event.getX();
//                y=(int)event.getY();
//
//                invalidate();
//            }
//
//            break;
//            case MotionEvent.ACTION_UP:
//
//                x=(int)event.getX();
//                y=(int)event.getY();
//                System.out.println(".................."+x+"......"+y); //x= 345 y=530
//                invalidate();
//                break;
//        }

        return true;
  
    }

    private void init(@NonNull Context context) {
        bm = BitmapFactory.decodeResource(getResources(), R.drawable.caf);
        bmm = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
        SGD = new ScaleGestureDetector(context, new ScalesListener());
    }
}

