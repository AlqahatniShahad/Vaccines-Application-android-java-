package com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {
    EditText et_username,et_password,et_age,et_std_id;
    Button btn_regiter, we;
    String stdUsername,std_id,std_age;
    String stdpassword;
    Controllerdb controllerdb = new Controllerdb(this);
    SQLiteDatabase database;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_username = findViewById(R.id.textInputEditText);
        et_password = findViewById(R.id.editTextTextPersonName4);
        et_std_id = findViewById(R.id.editTextTextPersonName3);
        et_age = findViewById(R.id.editTextTextPersonName6);
        btn_regiter = findViewById(R.id.button5);
        builder=new AlertDialog.Builder(this);
        we = findViewById(R.id.y);

        we.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(intent);
            }
        });
        btn_regiter.setOnClickListener(new View.OnClickListener() {
       @Override
            public void onClick(View view) {
              database = controllerdb.getWritableDatabase();
              stdpassword = et_password.getText().toString();
              stdUsername = et_username.getText().toString();
                std_id = et_std_id.getText().toString();
                std_age = et_age.getText().toString();
           database.execSQL("INSERT INTO users(username,pass,class) VALUES('"+stdUsername+"','"+stdpassword+"','Patient')" );
           database.execSQL("INSERT INTO Patient(StdName,StdId,StdAge) VALUES('"+stdUsername+"','"+std_id+"','"+std_age+"')" );
           builder.setMessage("Patient Data Added Correctly into the Database");
           builder.setCancelable(false);
           builder.setPositiveButton("Agree", new  DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                 Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                 startActivity(intent);
               }});
                AlertDialog alert = builder.create();
                alert.setTitle("Attention");
                alert.show();

       }
    }
        );
}
}


