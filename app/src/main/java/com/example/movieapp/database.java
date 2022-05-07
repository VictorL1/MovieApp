package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {


    public static final String IDUtilisateur = "ID";
    public static final String Username = "Username";
    public static final String Email = "Email";
    public static final String Password = "Password";

    public static final String IdFavoris = "IdFavoris";


    public database(@Nullable Context context) {
        super(context, "MovieDatabase", null, 3);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableUtilisateur= "CREATE TABLE " + "Utilisateur" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Username +" String DEFAULT 'anonyme' ,"
                + Email + " String DEFAULT 'username@gmail.com',"
                + Password +" String DEFAULT '1234' );";
        db.execSQL(createTableUtilisateur);

        String createTableFavoris= "CREATE TABLE " + "Favoris" + "(" + "IDUtilisateur" + " INTEGER PRIMARY KEY ," +
                IdFavoris +" STRING DEFAULT '0' );";
        db.execSQL(createTableFavoris);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Utilisateur");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + "Favoris");
        onCreate(db);
    }

    public boolean SauvagarderUtilisateur(Utilisateur utilisateur){
        SQLiteDatabase db = this.getWritableDatabase();
        Long numIdUser = DatabaseUtils.queryNumEntries(db,"Utilisateur",null);
        if (numIdUser < 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(IDUtilisateur, 1);
            long result = db.insert("Utilisateur", "ID", contentValues);
        }
        numIdUser = DatabaseUtils.queryNumEntries(db,"Utilisateur",null);
        if (numIdUser >= 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(IDUtilisateur, 1);
            contentValues.put(Username, utilisateur.username);
            contentValues.put(Email, utilisateur.mail);
            contentValues.put(Password, utilisateur.password);


            db.update("Utilisateur", contentValues, "ID= ? ", new String[]{"1"});
            return true;
        }
        return false;
    }

    public boolean SauvagarderFavoris(Favoris favoris){
        SQLiteDatabase db = this.getWritableDatabase();
        Long numIdUser = DatabaseUtils.queryNumEntries(db,"Favoris",null);
        if (numIdUser < 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(IDUtilisateur, 1);
            long result = db.insert("Favoris", "ID", contentValues);
        }
        numIdUser = DatabaseUtils.queryNumEntries(db,"Favoris",null);
        if (numIdUser >= 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(IDUtilisateur, 1);
            //contentValues.put(IdFavoris, utilisateur.IdFavoris);



            db.update("Favoris", contentValues, "ID= ? ", new String[]{"1"});
            return true;
        }
        return false;
    }

    @SuppressLint("Range")
    public boolean ChargerUtilisateur(Utilisateur utilisateur){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] ColonnesUtilisateur = { "ID", "username", "mail", "Password"};


        Cursor cursor =db.query("Utilisateur", ColonnesUtilisateur, "ID = ?",new String[]{"1"},null,null,null);
        if( cursor != null && cursor.moveToFirst() ){
            utilisateur.username =cursor.getString(cursor.getColumnIndex("Username"));
            utilisateur.mail=cursor.getString(cursor.getColumnIndex("Email"));
            utilisateur.password=cursor.getString(cursor.getColumnIndex("Password"));

            cursor.close();
            return true;

        }
        return false;
    }

   /* @SuppressLint("Range")
    public boolean ChargerFavoris(Favoris favoris){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] ColonnesFavoris = { "IDUtilisateur", "IdFavoris"};


        Cursor cursor =db.query("Favoris", ColonnesFavoris, "ID = ?",new String[]{"1"},null,null,null);
        if( cursor != null && cursor.moveToFirst() ){
            favoris.IdUtilisateur =cursor.getString(cursor.getColumnIndex("IDUtilisateur"));
            favoris.IdFavoris=cursor.getString(cursor.getColumnIndex("IdFavoris"));

            cursor.close();
            return true;

        }
        return false;
    } */

    public void insertUser(Utilisateur user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", user.getUsername());
        cv.put("email", user.getMail());
        cv.put("password", user.getPassword());

        db.insert("Utilisateur",null, cv);
    }

    public void insertFav(Favoris favoris){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("IdFavoris", favoris.getIdUtilisateur());

        db.insert("Favoris",null, cv);
    }
/*
    public void updateUser(Utilisateur user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", user.getUsername());
        cv.put("email", user.getMail());
        cv.put("password", user.getPassword());

        db.update("utilisateur",cv,"_id=?",new String[]{String.valueOf(user.getId())});
    }


    public void deleteUser(int id){
        SQLiteDatabase db = this.getWritableDatabase();



        db.delete("utilisateur","_id=?",new String[]{String.valueOf(id)});

    }

    public Cursor getAllUsers(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM utilisateur", null);

        return c;
    }

    public Utilisateur getOneUser(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("utilisateur", new String[]{"_id", "username", "mail","password"},"_id=?",
                new String[]{String.valueOf(id)},null, null, null);

        c.moveToFirst();
        Utilisateur user = new Utilisateur(c.getInt(0),c.getString(1), c.getString(2), c.getString(3));

        return user;
    }


 */
}