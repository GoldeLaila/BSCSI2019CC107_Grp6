package com.example.taguigscholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3lanishits extends AppCompatActivity {
    Button button, lani, tlc, tcu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3lanishits);
        button = (Button) findViewById(R.id.profile);
        lani = (Button) findViewById(R.id.lani);
        tlc = (Button) findViewById(R.id.tlc);
        tcu = (Button) findViewById(R.id.tcu);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity3lanishits.this, MainActivity3profile.class);
                startActivity(intentt);


            }
        });

        lani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity3lanishits.this, MainActivityYear.class);
                startActivity(intent);


            }
        });

        tlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(MainActivity3lanishits.this, MainActivityTLC.class);
                startActivity(intentt);
            }
        });


        tcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity3lanishits.this, MainActivityYear.class);
                startActivity(intent);


            }
        });

    }
}
