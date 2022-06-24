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

public class MainActivity6 extends AppCompatActivity {
    Button btn_regiter,m;
    Controllerdb controllerdb = new Controllerdb(this);
    SQLiteDatabase database;
    EditText et_username,et_password,et_mobile;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        builder = new AlertDialog.Builder(this);
        et_username = findViewById(R.id.editTextTextPersonName);
        et_password = findViewById(R.id.editTextTextPersonName2);
        et_mobile = findViewById(R.id.editTextTextPersonName5);
        btn_regiter = findViewById(R.id.button6);
        m = findViewById(R.id.ln);

        m.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivity4.class);
                startActivity(intent);
            }
        });
        btn_regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = controllerdb.getWritableDatabase();
                String Managername = et_username.getText().toString();
                String Managerpass = et_password.getText().toString();
                String ManagerMobile = et_mobile.getText().toString();
                database.execSQL("INSERT INTO users(username,pass,class) VALUES('" + Managername + "','" + Managerpass + "','Manager')");
                database.execSQL("INSERT INTO Manager( TName,TMobile) VALUES('" + Managername + "','" + ManagerMobile + "')");
                builder.setMessage("Manager Data Added Correctly into the Database");
                builder.setCancelable(false);
                builder.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity6.this, MainActivity4.class);
                        startActivity(intent); }
                });
                AlertDialog alert =builder.create();
                alert.setTitle("Attention");
                alert.show();
            }
        });}}
