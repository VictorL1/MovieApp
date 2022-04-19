package com.example.movieapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Bundle extras = getIntent().getExtras();
        newId= extras.getLong("id");
        title = findViewById(R.id.MovieName);
        queue = Volley.newRequestQueue(this);
        try {
            getJsonRep();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void getJsonRep()throws IOException {
        String urlMovie = "https://api.themoviedb.org/3/movie/" + newId + "?api_key=8a7ef7cc2644c64c0de94fb16a453d29";
        StringRequest requeteDetailsFilm = new StringRequest(Request.Method.GET, urlMovie,
                reponse -> {
            try {
                JSONObject obj = new JSONObject(reponse);
                title.setText(obj.getString("title"));
                //poster = obj.getString("poster_path");
                //poster = "https://image.tmdb.org/t/p/w500" + poster;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {});
        queue.add(requeteDetailsFilm);
    }
}
