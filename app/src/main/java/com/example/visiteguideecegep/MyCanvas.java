package com.example.visiteguideecegep;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyCanvas extends View {

    Bitmap bitmap;
//Paint paint;
Rect rect;
    public MyCanvas(Context context) {
        super(context);
//paint=new Paint();
rect=new Rect();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
     //   paint.setStrokeWidth(3);
       // canvas.setBitmap(R.drawable.caf);
        canvas.drawBitmap(bm,null, new Rect(200,200,300,300),null);
    }


}
