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

    public database(@Nullable Context context) {
        super(context, "MovieDatabase", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableUtilisateur= "CREATE TABLE " + "Utilisateur" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Username +" String DEFAULT 'anonyme' ,"
                + Email + " String DEFAULT 'username@gmail.com',"
                + Password +" String DEFAULT '1234' );";
        db.execSQL(createTableUtilisateur);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Utilisateur");
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
}