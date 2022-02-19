package com.example.taguigscholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTLC extends AppCompatActivity {
    Button button, next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tlc);

        button = (Button) findViewById(R.id.profile) ;
        next = (Button) findViewById(R.id.next) ;
        back = (Button) findViewById(R.id.back);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC.this, MainActivity3profile.class);
                startActivity(intentt);


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC.this, MainActivity3lanishits.class);
                startActivity(intentt);


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC.this, MainActivityTLC2.class);
                startActivity(intentt);


            }
        });

    }
}