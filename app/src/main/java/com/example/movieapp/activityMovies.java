package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        textview = (TextView) findViewById(R.id.title);
        imageView = (ImageView) findViewById(R.id.poster);
        //for (int i=0; i<= MainActivity.popularMovies.size(); i++) {
            textview.setText(MainActivity.popularMovies.get(10));
            Picasso.get().load(MainActivity.popularMovies.get(11)).into(imageView);
       // }
//https://www.geeksforgeeks.org/cardview-using-recyclerview-in-android-with-example/
    }
}