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

public class MainActivityTLC10 extends AppCompatActivity {

    Button button, next, back;
    EditText pa,ti,cn,tp,lt,pp,bk;
    boolean vali = false;
    String lns, fns, mms, ads, dss, brs, tys;
    private String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tlc10);

        button = (Button) findViewById(R.id.profile) ;
        next = (Button) findViewById(R.id.next) ;
        back = (Button) findViewById(R.id.back);
        pa = findViewById(R.id.editTextTextPersonName27);
        ti = findViewById(R.id.editTextTextPersonName28);
        cn = findViewById(R.id.editTextTextPersonName29);
        tp = findViewById(R.id.editTextTextPersonName30);
        lt = findViewById(R.id.editTextTextPersonName24);
        pp = findViewById(R.id.editTextTextPersonName25);
        bk= findViewById(R.id.editTextTextPersonName26);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC10.this, MainActivity3profile.class);
                startActivity(intentt);


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC10.this, MainActivityTLC9.class);
                startActivity(intentt);


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vali = valid();
                if(vali) {
                    URL = "http://"+Final_IP.IP_ADDRESS+"/isko/tlc10.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                        Log.d("res", response);
                        if (response.equals("success")) {
                            Toast.makeText(MainActivityTLC10.this, "Filled up Successfully.", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainActivityTLC10.this, MainActivity3lani9.class);
                            startActivity(intent);
                            finish();
                        } else if (response.equals("failure")) {
                            Toast.makeText(MainActivityTLC10.this, "Something wrong, try again.", Toast.LENGTH_SHORT).show();
                        }
                    }, error -> Toast.makeText(MainActivityTLC10.this, error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                        @Override
                        public Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("pa", fns);
                            data.put("ti", lns);
                            data.put("cn", mms);
                            data.put("tp", ads);

                            data.put("lt", brs);
                            data.put("pp", dss);
                            data.put("bk", tys);



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
        if (pa.length() == 0) {
            pa.setError("Dapat ilagay ang pangalan");
            return false;
        }
        if (ti.length() == 0) {
            ti.setError("Dapat ilagay ang Tirahan");
            return false;
        }

        if (cn.length() == 0) {
            cn.setError("Dapat ilagay ang Contact No.");
            return false;
        }
        if (tp.length() == 0) {
            tp.setError("Dapat ilagay ang Trabaho");
            return false;
        }
        if (lt.length() == 0) {
            lt.setError("Dapat ilagay ang lugay na pinagtrabahuan");
            return false;
        }
        if (pp.length() == 0) {
            pp.setError("Dapat ilagay ang pinakamataas na antas ng pinag-aralan");
            return false;
        }
        else if (bk.length() == 0) {
            bk.setError("Dapat ilagay ang buwanang kita");
            return false;
        }
        return true;
    }
}