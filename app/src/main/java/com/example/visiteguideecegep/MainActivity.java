package com.example.visiteguideecegep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView a, b, c;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Connexion reussie", Toast.LENGTH_LONG).show();

        a = (TextView) findViewById(R.id.textViewNumero);
        b = (TextView) findViewById(R.id.textViewNom);
        c = (TextView) findViewById(R.id.textViewEtage);
        editText = (EditText) findViewById(R.id.editTextSearch);
        button = (Button) findViewById(R.id.buttonSearch);
        setListener();
    }

    private void setListener()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
