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


public class EmplacementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emplacement_activity);

//int imageRessource=getResources().getIdentifier()
//imageView.setImageResource(ima);
        // imageView = new ImageView(this);
TextView textView =findViewById(R.id.textView2);
//textView.setText(ScanActivity.emp);
      //  if (ScanActivity.emp == "caf") {
            ImageView imageView = findViewById(R.id.imageView2);
            imageView.setImageResource(R.drawable.ping);

       // }
    }
}

