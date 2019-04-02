package com.example.visiteguideecegep;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
 import android.content.Intent;
        import android.graphics.Camera;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;


public class EmplacementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emplacement_activity);
        Intent i=getIntent();
        PhotoView plan = findViewById(R.id.photo_view);
        plan.setImageResource(R.drawable.caf);
        PhotoView pin =findViewById(R.id.photo_viewpin);
       if (i.getStringExtra("allo").equals("caf")) {

        pin.setImageResource(R.drawable.pin);

        }
    }
}

