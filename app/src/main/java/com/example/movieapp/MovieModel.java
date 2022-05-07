package com.example.movieapp;

import android.net.Uri;

import java.net.URI;

public class MovieModel {
    private String movie_name;
    private Uri movie_image;
    private Long movie_rate;
    private long movie_id;
    private String movie_language;

    // Constructor
    public MovieModel(String movie_name, Uri movie_image, Long movie_rate, long movie_id) {
        this.movie_name = movie_name;
        this.movie_image = movie_image;
        this.movie_rate = movie_rate;
        this.movie_id = movie_id;
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

    public Long getMovie_rate(){
        return movie_rate;
    }

    public void setMovie_rate(Long movie_rate) {
        this.movie_rate = movie_rate;
    }

    public long getMovie_id(){ return movie_id; }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }






}
