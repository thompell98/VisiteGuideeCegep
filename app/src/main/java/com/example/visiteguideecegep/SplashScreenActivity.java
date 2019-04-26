package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView = findViewById(R.id.textView_splash);
        imageView = findViewById(R.id.imageView_logo);
        Drawable myDrawable = getApplicationContext().getDrawable(R.drawable.logo);
        imageView.setImageDrawable(myDrawable);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);

        final Intent intent = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();
    }
}
