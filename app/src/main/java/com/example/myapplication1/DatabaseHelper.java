package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Baza.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE korisnik (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ime TEXT, " +
                "prezime TEXT, " +
                "email TEXT UNIQUE, " +
                "password TEXT, " +
                "bodovi INTEGER DEFAULT 0, " +
                "slikaKorisnika BLOB)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS korisnik");
        onCreate(db);
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM korisnik WHERE email = ? AND password = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return exists;
    }

    private static String CurrentUserEmail;

    public static String getCurrentUserEmail() {
        return CurrentUserEmail;
    }

    public static void setCurrentUserEmail(String email) {
        CurrentUserEmail = email;
    }

    public static class UserInfo {
        public String ime;
        public String prezime;
        public int bodovi;
        public byte[] slikaKorisnika;

        public UserInfo(String ime, String prezime, int bodovi, byte[] slikaKorisnika) {
            this.ime = ime;
            this.prezime = prezime;
            this.bodovi = bodovi;
            this.slikaKorisnika = slikaKorisnika;
        }
    }
}

