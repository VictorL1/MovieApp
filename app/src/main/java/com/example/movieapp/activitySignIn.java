package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activitySignIn extends AppCompatActivity {

    Button b;

    EditText mail, mdp, pseudo;

    database h = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        pseudo = findViewById(R.id.EditTextPseudo);
        mail = findViewById(R.id.EditTextEmail);
        mdp = findViewById(R.id.EditTextMDP);


        b=findViewById(R.id.buttonSignIn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Utilisateur user = new Utilisateur(pseudo.getText().toString(),mail.getText().toString(),mdp.getText().toString());

                h.insertUser(user);
                Intent i = new Intent(activitySignIn.this,MainActivity.class);
                startActivity(i);

            }

        });


    }


}