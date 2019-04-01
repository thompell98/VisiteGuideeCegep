package com.example.visiteguideecegep;

import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.button_goToScan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionCamera();
            }
        });
    }
private void redirectionCamera()
{
    Intent sendUserToSignUpOrLogin=new Intent(this, CameraActivity.class);
    startActivity(sendUserToSignUpOrLogin);
}

}
