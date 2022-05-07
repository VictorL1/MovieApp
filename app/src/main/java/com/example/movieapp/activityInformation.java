package com.example.movieapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class activityInformation extends AppCompatActivity {
    long newId;
    TextView title;
    String poster;
    ImageView image;
    RequestQueue queue;
    ImageButton imagebutton;

    database h = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Bundle extras = getIntent().getExtras();
        newId= extras.getLong("id");
        title = findViewById(R.id.MovieName);
        image = findViewById(R.id.MoviePoster);
        queue = Volley.newRequestQueue(this);
        try {
            getJsonRep();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imagebutton = findViewById(R.id.button_star);

        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if is not on fav table in BDD && connected
                imagebutton.setImageResource(R.drawable.star_on);

               // Favoris favoris = new Favoris(getIdUtilisateur(),newId);
              //SS  h.insertFav(favoris);

                //else --> create account or connect to ur account

            }
        });


    }
    public void getJsonRep()throws IOException {
        String urlMovie = "https://api.themoviedb.org/3/movie/" + newId + "?api_key=8a7ef7cc2644c64c0de94fb16a453d29";
        StringRequest requeteDetailsFilm = new StringRequest(Request.Method.GET, urlMovie,
                reponse -> {
            try {
                JSONObject obj = new JSONObject(reponse);
                title.setText(obj.getString("title"));
                poster = obj.getString("poster_path");
                poster = "https://image.tmdb.org/t/p/w500" + poster;
                image.setImageURI(Uri.parse(poster));
                Picasso.get().load(poster).into(image);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {});
        queue.add(requeteDetailsFilm);
    }
}
