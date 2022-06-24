package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity5 extends AppCompatActivity {

    Controllerdb controllerdb = new Controllerdb(this);
    SQLiteDatabase db;
    ListView lv;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> PatientName = new ArrayList<String>();
    private ArrayList<String> PatientId = new ArrayList<String>();
    private ArrayList<String> PatientAge = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        lv= findViewById(R.id.listview);
        DisplayData();
        Button po = (Button) findViewById(R.id.u);

        po.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity5.this,MainActivity4.class);
                startActivity(intent);
            }
        });
    }
        public void DisplayData() {
            db = controllerdb.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Patient", null);
            Id.clear();
            PatientName.clear();
            PatientId.clear();
            PatientAge.clear();
            if (cursor.moveToFirst()) {
                do {
                    Id.add(cursor.getString(cursor.getColumnIndex("Id")));
                    PatientName.add(cursor.getString(cursor.getColumnIndex("StdName")));
                    PatientId.add(cursor.getString(cursor.getColumnIndex("StdId")));
                    PatientAge.add(cursor.getString(cursor.getColumnIndex("StdAge")));
                } while (cursor.moveToNext());
            }
            PatientAdapter sa = new PatientAdapter(MainActivity5.this, Id, PatientName, PatientId, PatientAge);
            lv.setAdapter(sa);
            cursor.close();
        }}







