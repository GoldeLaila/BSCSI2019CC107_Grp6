package com.example.taguigscholarship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3lani2 extends AppCompatActivity {
    Button next, back, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3lani2);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        profile = (Button)findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(MainActivity3lani2.this, MainActivity3profile.class);
                startActivity(intentt);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity3lani2.this, MainActivity3lani3.class);
                startActivity(intentt);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity3lani2.this, MainActivity3lanishits.class);
                startActivity(intentt);

            }
        });


    }
}