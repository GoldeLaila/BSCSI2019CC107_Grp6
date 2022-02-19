package com.example.taguigscholarship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3lani9 extends AppCompatActivity {
    Button profile, done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3lani9);
        profile = (Button) findViewById(R.id.profile);
        done = (Button)findViewById(R.id.done);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(MainActivity3lani9.this, MainActivity3profile.class);
                startActivity(intentt);
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity3lani9.this, MainActivity3lanishits.class);
                startActivity(intentt);
                finish();


            }
        });


    }
}