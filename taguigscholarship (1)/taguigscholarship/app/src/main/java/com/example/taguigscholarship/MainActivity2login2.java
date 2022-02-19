package com.example.taguigscholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2login2 extends AppCompatActivity {



    EditText username, password;
    Button loin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2login2);

        username = findViewById(R.id.editTextTextUsername);
        password = findViewById(R.id.editTextTextPassword);
        loin = findViewById(R.id.loginbut);


            DB = new DBHelper(this);

            loin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    if(user.equals("")||pass.equals(""))
                        Toast.makeText(MainActivity2login2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    else{
                        Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                        if(checkuserpass){
                            Toast.makeText(MainActivity2login2.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), MainActivity3lanishits.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity2login2.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }
    }


