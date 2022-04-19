package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholder> {


    private Context context;
    private ArrayList<MovieModel> movieModelArrayList;

    // Constructor
    public MovieAdapter(Context context, ArrayList<MovieModel> movieModelArrayList) {
        this.context = context;
        this.movieModelArrayList = movieModelArrayList;

    }

    @NonNull
    @Override
    public MovieAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardlayout, parent, false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.Viewholder holder, int position) {

        // to set data to textview and imageview of each card layout
        MovieModel model = movieModelArrayList.get(position);
        holder.movieName.setText(model.getMovie_name());
        holder.movieIV.setImageURI(model.getMovie_image());
        Picasso.get().load(movieModelArrayList.get(position).getMovie_image()).into(holder.movieIV);
        holder.movieRate.setText(movieModelArrayList.get(position).getMovie_rate() + "⭐");
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), activityInformation.class);
                intent.putExtra("id", model.getMovie_id());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return movieModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView movieIV;
        private TextView movieName;
        private TextView movieRate;
        private RelativeLayout cardview;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            movieIV = itemView.findViewById(R.id.idIVMovieImage);
            movieName = itemView.findViewById(R.id.idTVMovieName);
            movieRate = itemView.findViewById(R.id.idTVMovieRating);
            cardview = itemView.findViewById(R.id.CardLayout);
        }
    }
}
