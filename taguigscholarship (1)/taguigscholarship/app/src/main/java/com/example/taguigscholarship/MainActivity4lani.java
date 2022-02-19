package com.example.taguigscholarship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4lani extends AppCompatActivity {
    Button button, continu, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4lani);
        button = (Button) findViewById(R.id.profile);
       continu = (Button) findViewById(R.id.button5);
       exit = (Button)findViewById(R.id.button6);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity4lani.this, MainActivity3profile.class);
                startActivity(intentt);

            }
        });

        continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity4lani.this, MainActivity3lanishits.class);
                startActivity(intentt);

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity4lani.this, MainActivity2login2.class);
                startActivity(intentt);

            }
        });

    }
}