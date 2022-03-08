package com.example.movieapp;

import android.net.Uri;

import java.net.URI;

public class MovieModel {
    private String movie_name;
    private Uri movie_image;

    // Constructor
    public MovieModel(String movie_name, Uri movie_image) {
        this.movie_name = movie_name;
        this.movie_image = movie_image;
    }

    // Getter and Setter
    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public Uri getMovie_image() {
        return movie_image;
    }

    public void setMovie_image(Uri movie_image) {
        this.movie_image = movie_image;
    }
}
