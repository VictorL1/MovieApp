package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class activityMovies extends AppCompatActivity {
    TextView textview;
    ImageView imageView;
    private RecyclerView movieRV;
    private ArrayList<MovieModel> movieModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        imageView = (ImageView) findViewById(R.id.idIVMovieImage);
        //for (int i=0; i<= MainActivity.popularMovies.size(); i++) {
           // textview.setText(MainActivity.popularMovies.get(10));
            //Picasso.get().load(MainActivity.popularMovies.get(11)).into(imageView);
       // }
//https://www.geeksforgeeks.org/cardview-using-recyclerview-in-android-with-example/

        movieRV = findViewById(R.id.idRVMovie);
        // Arraylist for storing data

        movieModelArrayList = new ArrayList<>();
        for(int i=0; i<= MainActivity.popularMovies.size()-2; i++) {

            movieModelArrayList.add(new MovieModel(MainActivity.popularMovies.get(i), Uri.parse(MainActivity.uriMovies.get(i)) ));
        }


        // we are initializing our adapter class and passing our arraylist to it.
        MovieAdapter movieAdapter = new MovieAdapter(this, movieModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        movieRV.setLayoutManager(linearLayoutManager);
        movieRV.setAdapter(movieAdapter);
    }


}