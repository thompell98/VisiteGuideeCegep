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
        setListener();
        Intent sendUserToRechercheLocal = new Intent(this, RechercheLocal.class);
        startActivity(sendUserToRechercheLocal);
    }

    private void setListener() {
        findViewById(R.id.button_gotoscan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionCamera();
            }
        });
        findViewById(R.id.buttonAffichageLocal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionAffichageLocal();
            }
        });
    }

    private void redirectionCamera()
    {
        Intent sendUserToSignUpOrLogin=new Intent(this, CameraActivity.class);
        startActivity(sendUserToSignUpOrLogin);
    }

    private void redirectionDb()
    {
        Intent sendUserToSignUpOrLogin=new Intent(this, ConnexionBD.class);
        startActivity(sendUserToSignUpOrLogin);
    }

    private void redirectionAffichageLocal()
    {
        Intent sendUserToAffichageLocal = new Intent(this, AffichageLocal.class);
        startActivity(sendUserToAffichageLocal);
    }
}
