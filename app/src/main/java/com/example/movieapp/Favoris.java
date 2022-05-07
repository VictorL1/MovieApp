package com.example.movieapp;

public class Favoris {

    public int idutilisateur;
    public String favoris;



    public Favoris(int idutilisateur, String favoris)
    {

        this.idutilisateur= idutilisateur;
        this.favoris= favoris;

    }

    public Favoris(String favoris) {
        this.favoris= favoris;

    }

    public Favoris() {
    }

    public int getIdUtilisateur() {
        return idutilisateur;
    }

    public void setIdUtilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getFavoris() {
        return favoris;
    }

    public void setFavoris(String favoris) {
        this.favoris = favoris;
    }

}
