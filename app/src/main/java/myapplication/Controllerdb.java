package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Controllerdb extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ProjectVDB";

    public Controllerdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String request, request2, request3,request4 ;
        request = " CREATE TABLE IF NOT EXISTS users (username VARCHAR PRIMARY KEY, pass VARCHAR , class VARCHAR );";
        db.execSQL(request);
        request2 = " CREATE TABLE IF NOT EXISTS Manager(Id INTEGER PRIMARY KEY AUTOINCREMENT, TName VARCHAR, TMobile VARCHAR );";
        db.execSQL(request2);
        request3 = " CREATE TABLE IF NOT EXISTS Patient (Id INTEGER PRIMARY KEY AUTOINCREMENT, StdName VARCHAR, StdId VARCHAR, StdAge VARCHAR );";
        db.execSQL(request3);
        request4 = " CREATE TABLE IF NOT EXISTS Appointment (APPnumber INTEGER PRIMARY KEY AUTOINCREMENT, day VARCHAR, date VARCHAR);";
        db.execSQL(request4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String request, request2, request3 ,request4;
        request = "DROP TABLE IF EXISTS users";
        db.execSQL(request);
        request2 = "DROP TABLE IF EXISTS Patient"; db.execSQL(request2);
        request3 = "DROP TABLE IF EXISTS Manager"; db.execSQL(request3);
        request4 = "DROP TABLE IF EXISTS Appointment"; db.execSQL(request4);
        onCreate(db);
    }
}
