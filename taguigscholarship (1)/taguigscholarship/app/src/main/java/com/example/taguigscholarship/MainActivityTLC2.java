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

public class MainActivityTLC2 extends AppCompatActivity {
    EditText ln, fn, mm, ad, ds, br, ty, gender, age, ed, cn, rg, bd, cs, bp;

    boolean fall = false;

    String lns, fns, mms, ads, dss, brs, tys, genders, ages, eds, cns, rgs, bds, css, bps;
    private String URL;
    Button button, next, back;
    boolean isAllFieldsCheck = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tlc2);

        button = (Button) findViewById(R.id.profile) ;
        next = (Button) findViewById(R.id.next) ;
        back = (Button) findViewById(R.id.back);
        ln = findViewById(R.id.editTextTextPersonName);
        fn = findViewById(R.id.editTextTextPersonName2);
        mm = findViewById(R.id.editTextTextPersonName3);
        ds = findViewById(R.id.editTextTextPersonName6);
        ad = findViewById(R.id.editTextTextPersonName4);
        br = findViewById(R.id.editTextTextPersonName5);
        ty = findViewById(R.id.editTextTextPersonName7);
        gender = findViewById(R.id.editTextTextPersonName8);
        age = findViewById(R.id.editTextTextPersonName9);
        ed = findViewById(R.id.editTextTextPersonName10);
        cn = findViewById(R.id.editTextTextPersonName11);
        rg = findViewById(R.id.editTextTextPersonName12);
        bd = findViewById(R.id.editTextTextPersonName13);
        cs = findViewById(R.id.editTextTextPersonName14);
        bp = findViewById(R.id.editTextTextPersonName15);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC2.this, MainActivity3profile.class);
                startActivity(intentt);


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivityTLC2.this, MainActivityTLC.class);
                startActivity(intentt);


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsCheck = CheckAllFields();
                if (isAllFieldsCheck) {
                    fns = ln.getText().toString();
                    lns = fn.getText().toString();
                    mms = mm.getText().toString();
                    ads = ds.getText().toString();
                    brs = ad.getText().toString();
                    dss = br.getText().toString();
                    tys = ty.getText().toString();
                    genders = gender.getText().toString();
                    css = age.getText().toString();
                    ages = ed.getText().toString();
                    bps = cn.getText().toString();
                    eds = rg.getText().toString();
                    cns = bd.getText().toString();
                    rgs = cs.getText().toString();
                    bds = bp.getText().toString();

                    URL = "http://"+Final_IP.IP_ADDRESS+"/isko/tlc2.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                        Log.d("res", response);
                        if (response.equals("success")) {


                                Toast.makeText(MainActivityTLC2.this, "Filled up Successfully.", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(MainActivityTLC2.this, MainActivityTLC3.class);
                                startActivity(intent);
                                finish();


                        } else if (response.equals("failure")) {
                            Toast.makeText(MainActivityTLC2.this, "Something wrong, try again.", Toast.LENGTH_SHORT).show();
                        }
                    }, error -> Toast.makeText(MainActivityTLC2.this, error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                        @Override
                        public Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("ln", fns);
                            data.put("fn", lns);
                            data.put("mn", mms);
                            data.put("ds", ads);

                            data.put("ad", brs);
                            data.put("br", dss);
                            data.put("ty", tys);

                            data.put("gender", genders);
                            data.put("age", css);
                            data.put("ed", ages);
                            data.put("cn", bps);

                            data.put("rg", eds);
                            data.put("bd", cns);
                            data.put("cs", rgs);
                            data.put("bp", bds);

                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);

                    Toast.makeText(MainActivityTLC2.this, "Filled up Successfully.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivityTLC2.this, MainActivityTLC3.class);
                    startActivity(intent);
                    finish();



            }
        };


    });



}

    private boolean CheckAllFields() {
        if (ln.length() == 0) {
            ln.setError("Last Name is required");
            return false;
        }
        if (fn.length() == 0) {
            fn.setError("First Name is required");
            return false;
        }
        if (mm.length() == 0) {
            mm.setError("Middle Name is required");
            return false;
        }
        if (ad.length() == 0) {
            ad.setError("Adress is required");
            return false;
        }
        if (ds.length() == 0) {
            ds.setError("District is required");
            return false;
        }
        if (br.length() == 0) {
            br.setError("Barangay is required");
            return false;
        }
        if (ty.length() <= 3) {
            ty.setError("Living in Taguig must be 3years or more");
            return false;
        }
        if (gender.length() == 0) {
            gender.setError("Gender is required");
            return false;
        }
        if (age.length() == 0) {
            age.setError("Age is required");
            return false;
        }
        if (ed.length() == 0) {
            ed.setError("Email Address is required");
            return false;
        }
        if (cn.length() < 11) {
            cn.setError("Contact number must be 11 numbers");
            return false;
        }
        if (rg.length() == 0) {
            rg.setError("Religion is required");
            return false;
        }
        if (bd.length() == 0) {
            bd.setError("Birth Date is required");
            return false;
        }
        if (cs.length() == 0) {
            cs.setError("Civil Status is required");
            return false;
        } else if (bp.length() == 0) {
            bp.setError("Place of Birth is required");
            return false;
        }
        return true;


    }}