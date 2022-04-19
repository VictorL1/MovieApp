package com.example.movieapp;

public class Utilisateur {

    public int id;
    public String username;
    public String mail;
    String password;


    public Utilisateur(int id, String username, String mail, String password)
    {

        this.id= id;
        this.username= username;
        this.mail=mail;
        this.password=password;
    }

    public Utilisateur(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
