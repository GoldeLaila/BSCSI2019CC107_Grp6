package com.example.taguigscholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2login extends AppCompatActivity {
    Button loin, register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2login);
      loin = (Button) findViewById(R.id.login);
      register = (Button) findViewById(R.id.regis);






        loin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent = new Intent(MainActivity2login.this, MainActivity2login2.class);
                startActivity(intent);

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent();

                intentt = new Intent(MainActivity2login.this, MainActivity2Register.class);
                startActivity(intentt);

            }
        });



    }
}