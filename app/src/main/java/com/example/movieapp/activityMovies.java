package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class activityMovies extends AppCompatActivity {
    TextView textview;
    ImageView imageView;
    private RecyclerView movieRV;
    private ArrayList<MovieModel> movieModelArrayList= new ArrayList<>();
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        imageView = (ImageView) findViewById(R.id.idIVMovieImage);
        movieRV = findViewById(R.id.idRVMovie);
        // Arraylist for storing data
        queue = Volley.newRequestQueue(this);
        movieModelArrayList = new ArrayList<>();

        try {
            getJsonRep();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getJsonRep()throws IOException {
        String urlPopularMovie = "https://api.themoviedb.org/3/movie/popular?api_key=8a7ef7cc2644c64c0de94fb16a453d29";

        StringRequest requeteFilmPopulaire = new StringRequest(Request.Method.GET, urlPopularMovie,
                reponse -> {
                    try {
                        JSONObject obj = new JSONObject(reponse);
                        JSONArray results = obj.getJSONArray("results");

                        String title;
                        String poster;
                        Long id;
                        Long rate;


                        for (int i = 0; i < results.length(); i++) {
                            title = results.getJSONObject(i).getString("title");
                            poster = results.getJSONObject(i).getString("poster_path");
                            poster = "https://image.tmdb.org/t/p/w500" + poster;
                            rate = results.getJSONObject(i).getLong("vote_average");
                            id = results.getJSONObject(i).getLong("id");
                            MovieModel moviemodel = new MovieModel(title, Uri.parse(poster), rate, id);
                            movieModelArrayList.add(moviemodel);
                        }
                        MovieAdapter movieAdapter = new MovieAdapter(this, movieModelArrayList);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                        movieRV.setLayoutManager(linearLayoutManager);
                        movieRV.setAdapter(movieAdapter);

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {});
        queue.add(requeteFilmPopulaire);

    }
}