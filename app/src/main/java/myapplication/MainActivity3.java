package com.example.myapplication;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity {

    RadioButton radio1,radio2,radio3,radio4;
    Button button,az;
    ImageView imageView, imageView11;
    Intent intent=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        az = findViewById(R.id.m);
        az.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intent);
            }
        });


        radio1 = findViewById(R.id.radioButton3);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton5);
        radio4 = findViewById(R.id.radioButton4);

        button = findViewById(R.id.button3);
        imageView = findViewById(R.id.imageView5);
        imageView11 = findViewById(R.id.imageView11);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (radio1.isChecked()) {
                    imageView11.setImageDrawable(getDrawable(R.drawable.fourth));
                } else if (radio2.isChecked()) {
                    imageView11.setImageDrawable(getDrawable(R.drawable.third));
                } else if (radio3.isChecked()) {
                    imageView11.setImageDrawable(getDrawable(R.drawable.second));
                } else if (radio4.isChecked()) {
                    imageView11.setImageDrawable(getDrawable(R.drawable.aa));
                } else {
                    Toast.makeText(getApplicationContext(), "Selected Vaccine", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }}


