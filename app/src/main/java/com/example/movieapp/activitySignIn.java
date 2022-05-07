package com.example.movieapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class activitySignIn extends AppCompatActivity {

    Button b, b2;
    ImageButton e, e2;

    boolean boule = false;
    boolean boule2 = false;

    EditText mail, mdp, pseudo, mdp2;

    database h = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        pseudo = findViewById(R.id.EditTextPseudo);
        mail = findViewById(R.id.EditTextEmail);
        mdp = findViewById(R.id.EditTextMDP);
        mdp2 = findViewById(R.id.EditTextMDP2);


        b=findViewById(R.id.buttonSignIn);
        b2=findViewById(R.id.back_on_menu);

        e= findViewById(R.id.btn_eye1);
        e2= findViewById(R.id.btn_eye2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mail.getText().toString().isEmpty() && !mdp.getText().toString().isEmpty() && !pseudo.getText().toString().isEmpty() && !mdp2.getText().toString().isEmpty() && mdp.getText().toString() == mdp2.getText().toString()) {

                    Utilisateur user = new Utilisateur(pseudo.getText().toString(), mail.getText().toString(), mdp.getText().toString());

                    h.insertUser(user);
                    Intent i = new Intent(activitySignIn.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activitySignIn.this);
                    // Set the message show for the Alert time
                    builder.setMessage("Certains champs sont vides ! Veuillez remplir tous les champs !");
                    // Set Alert Title
                    builder.setTitle("Erreur !");
                    builder.setCancelable(false);
                    builder.setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            // If user click no
                            // then dialog box is canceled.
                            dialog.cancel();
                        }
                    });
                    // Create the Alert dialog
                    AlertDialog alertDialog = builder.create();

                    // Show the Alert Dialog box
                    alertDialog.show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(activitySignIn.this, MainActivity.class);
                startActivity(i);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!boule){
                    mdp.setTransformationMethod(null);
                    boule = true;

                }
                else{
                    mdp.setTransformationMethod(new PasswordTransformationMethod());
                    boule = false;
                }


            }
        });

        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!boule2){
                    mdp2.setTransformationMethod(null);
                    boule2 = true;

                }
                else{
                    mdp2.setTransformationMethod(new PasswordTransformationMethod());
                    boule2 = false;
                }


            }
        });
    }
}