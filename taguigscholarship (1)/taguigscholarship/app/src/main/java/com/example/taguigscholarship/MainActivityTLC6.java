package com.example.taguigscholarship;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivityTLC6 extends AppCompatActivity {
    Button button, next, back;
    EditText shs,pp,sa,ys;
    boolean vali = false;
    String lns, fns, mms, ads, brs;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tlc6);

        button = (Button) findViewById(R.id.profile) ;
        next = (Button) findViewById(R.id.next) ;
        back = (Button) findViewById(R.id.back);
        shs = findViewById(R.id.editTextTextPersonName27);
        pp = findViewById(R.id.editTextTextPersonName28);
        sa = findViewById(R.id.editTextTextPersonName29);
        ys = findViewById(R.id.editTextTextPersonName30);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC6.this, MainActivity3profile.class);
                startActivity(intentt);


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC6.this, MainActivityTLC5.class);
                startActivity(intentt);


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vali = valid();
                if(vali) {
                    fns = shs.getText().toString();
                    lns = pp.getText().toString();
                    mms = sa.getText().toString();
                    ads = ys.getText().toString();

                    URL = "http://"+Final_IP.IP_ADDRESS+"/isko/tlc6.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                        Log.d("res", response);
                        if (response.equals("success")) {
                            Toast.makeText(MainActivityTLC6.this, "Filled up Successfully.", Toast.LENGTH_SHORT).show();

                            Intent intentt = new Intent(MainActivityTLC6.this, MainActivityTLC7.class);
                            startActivity(intentt);
                            finish();

                        } else if (response.equals("failure")) {
                            Toast.makeText(MainActivityTLC6.this, "Something wrong, try again.", Toast.LENGTH_SHORT).show();
                        }
                    }, error -> Toast.makeText(MainActivityTLC6.this, error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                        @Override
                        public Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("g4", fns);
                            data.put("pp", lns);
                            data.put("sa", mms);
                            data.put("ys", ads);

                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }

            }
        });

    }
    private boolean valid() {
        if (shs.length() == 0) {
            shs.setError("Last Name is required");
            return false;
        }
        if (pp.length() == 0) {
            pp.setError("Last Name is required");
            return false;
        }
        if (sa.length() == 0) {
            sa.setError("Last Name is required");
            return false;
        }
        else if (ys.length() == 0) {
            ys.setError("Last Name is required");
            return false;
        }
        return true;
    }
}