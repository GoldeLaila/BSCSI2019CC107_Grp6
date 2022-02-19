package com.example.taguigscholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityYear extends AppCompatActivity {
    Button una,dalawa,tatlo,apat,lima ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_year);
        una = (Button) findViewById(R.id.button2);
        dalawa = (Button) findViewById(R.id.button3);
        tatlo = (Button) findViewById(R.id.button4);
        apat = (Button) findViewById(R.id.button7);
        lima = (Button) findViewById(R.id.button8);

        una.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent = new Intent(MainActivityYear.this, MainActivity3lani2.class);
                startActivity(intent);

            }
        });
        dalawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent = new Intent(MainActivityYear.this, MainActivity3lani2.class);
                startActivity(intent);

            }
        });
        tatlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent = new Intent(MainActivityYear.this, MainActivity3lani2.class);
                startActivity(intent);

            }
        });
        apat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent = new Intent(MainActivityYear.this, MainActivity3lani2.class);
                startActivity(intent);

            }
        });
        lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent = new Intent(MainActivityYear.this, MainActivity3lani2.class);
                startActivity(intent);

            }
        });

    }
}