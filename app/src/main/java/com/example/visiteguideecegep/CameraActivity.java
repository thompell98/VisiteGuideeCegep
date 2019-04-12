package com.example.visiteguideecegep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class CameraActivity extends AppCompatActivity {
    public static TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);

        Intent i=getIntent();
        setListener();
    }

    private void setListener() {
        findViewById(R.id.button_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionCamera();
            }
        });
   
    }
    private void redirectionCamera()
    {
        Intent sendUserToSignUpOrLogin=new Intent(this, ScanActivity.class);
        startActivity(sendUserToSignUpOrLogin);
    }
    private void redirectionEmplacement()
    {
        Intent emplacement = new Intent(this, EmplacementActivity.class);
        startActivity(emplacement);
    }
}

