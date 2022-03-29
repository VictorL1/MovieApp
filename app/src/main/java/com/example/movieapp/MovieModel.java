package com.example.movieapp;

import android.net.Uri;

import java.net.URI;

public class MovieModel {
    private String movie_name;
    private Uri movie_image;
    private Long movie_rate;

    // Constructor
    public MovieModel(String movie_name, Uri movie_image, Long movie_rate) {
        this.movie_name = movie_name;
        this.movie_image = movie_image;
        this.movie_rate = movie_rate;
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

    public long getMovie_rate(){
        return movie_rate;
    }

    public void setMovie_image(Uri movie_image) {
        this.movie_image = movie_image;
    }
}
