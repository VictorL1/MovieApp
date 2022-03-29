package com.example.movieapp;

public class Utilisateur {

    public String username;
    public String mail;
    String password;


    public Utilisateur()
    {

        this.username="";
        this.mail="";
        this.password="";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
