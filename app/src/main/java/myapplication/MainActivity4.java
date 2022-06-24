package com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
public class MainActivity4 extends AppCompatActivity {
    Controllerdb controllerdb;
    SQLiteDatabase db;
    Button btnLogin, btnSignUp, bs;
    EditText ed_Username, ed_Password;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        controllerdb = new Controllerdb(this);
        btnLogin = (Button) findViewById(R.id.button4);
        bs = (Button) findViewById(R.id.b);
        btnSignUp = (Button) findViewById(R.id.button2);
        ed_Password = (EditText) findViewById(R.id.editTextTextPassword2);
        ed_Username = (EditText) findViewById(R.id.textInputEditText2);
        builder = new AlertDialog.Builder(this);
        bs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = ed_Username.getText().toString();
                String pass = ed_Password.getText().toString();
                boolean isExist = checkUserExist(user, pass);
                if (isExist) {
                    String type = checkUserType(user, pass);
                    if (type.equals("Patient")) {
                        Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                        startActivity(intent);
                    } else if (type.equals("Manager")) {
                        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                        startActivity(intent);
                    }
                } else {
                    ed_Password.setText(null);
                    builder.setMessage("Wrong Username or Password!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Login Faild!");
                    alert.show();
                }
            }

            public String checkUserType(String user, String pass) {
                String Userclass = "";
                String[] columns = {"class"};
                db = controllerdb.getReadableDatabase();
                String selection = "username=? and pass = ?";
                String[] selectionArgs = {user, pass};
                Cursor cursor = db.query("users", columns, selection, selectionArgs, null,
                        null, null);

                if (cursor.moveToFirst()) {
                    Userclass = cursor.getString(cursor.getColumnIndex("class"));
                }
                return Userclass;
            }

            public boolean checkUserExist(String user, String pass) {
                String[] columns = {"username"};
                db = controllerdb.getReadableDatabase();
                String selection = "username=? and pass = ?";
                String[] selectionArgs = {user, pass};
                Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
                int count = cursor.getCount();
                cursor.close();
                if (count > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            PopupMenu popup = new PopupMenu(MainActivity4.this, btnSignUp);

            public void onClick(View view) {

                popup.getMenuInflater().inflate(R.menu.sign_pop_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.patient:
                                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                                startActivity(intent);
                                return true;
                            case R.id.manager:
                                Intent intent22 = new Intent(MainActivity4.this, MainActivity6.class);
                                startActivity(intent22);
                                return true;
                        }
                        return true;
                    }
                });
                popup.show();

            }
        });
    }}

