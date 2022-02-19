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

public class MainActivity3lani8 extends AppCompatActivity {
    Button next, back, profile;
    EditText elem, pp, sa, ys;

    String lns, fns, mms, ads, brs;
    private String URL;
    boolean vali = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3lani8);
        profile = (Button) findViewById(R.id.profile);
        next = (Button)findViewById(R.id.next);
        back = (Button)findViewById(R.id.back);
        elem = findViewById(R.id.editTextTextPersonName27);
        pp = findViewById(R.id.editTextTextPersonName28);
        sa = findViewById(R.id.editTextTextPersonName29);
        ys = findViewById(R.id.editTextTextPersonName30);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(MainActivity3lani8.this, MainActivity3profile.class);
                startActivity(intentt);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vali = valid();
                if (vali) {
                    fns = elem.getText().toString();
                    lns = pp.getText().toString();
                    mms = sa.getText().toString();
                    ads = ys.getText().toString();

                    URL = "http://"+Final_IP.IP_ADDRESS+"/isko/lani8.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                        Log.d("res", response);
                        if (response.equals("success")) {
                            Toast.makeText(MainActivity3lani8.this, "Filled up Successfully.", Toast.LENGTH_SHORT).show();

                            Intent intentt = new Intent(MainActivity3lani8.this, MainActivity3lani9.class);
                            startActivity(intentt);
                            finish();

                        } else if (response.equals("failure")) {
                            Toast.makeText(MainActivity3lani8.this, "Something wrong, try again.", Toast.LENGTH_SHORT).show();
                        }
                    }, error -> Toast.makeText(MainActivity3lani8.this, error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                        @Override
                        public Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("elem", fns);
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity3lani8.this, MainActivity3lani7.class);
                startActivity(intentt);

            }
        });
    }
    private boolean valid() {
        if (elem.length() == 0) {
            elem.setError("Last Name is required");
            return false;
        }
        if (pp.length() == 0) {
            pp.setError("Last Name is required");
            return false;
        }
        if (sa.length() == 0) {
            sa.setError("Last Name is required");
            return false;
        } else if (ys.length() == 0) {
            ys.setError("Last Name is required");
            return false;
        }
        return true;
    }
}