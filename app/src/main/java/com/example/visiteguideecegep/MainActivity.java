package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redirectionCanvasActivity();
        //redirectionCamera();
    }

    private void redirectionCamera()
    {
        Intent sendUserToSignUpOrLogin=new Intent(this, TrajetActivity.class);
        startActivity(sendUserToSignUpOrLogin);
    }

    private void redirectionCanvasActivity()
    {
        Intent sendUserToActivityCanvas = new Intent(this, activityCanvas.class);
        startActivity(sendUserToActivityCanvas);
    }
}
