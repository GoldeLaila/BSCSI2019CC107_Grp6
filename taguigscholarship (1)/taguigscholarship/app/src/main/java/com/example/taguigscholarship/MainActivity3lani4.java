package com.example.taguigscholarship;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity3lani4 extends AppCompatActivity {
    public static int randm;
    EditText ln, fn, mm, ad, ds, br, ty, gender, age, ed, cn, rg, bd, cs, bp, code1;
    String strRan;

    String lns, fns, mms, ads, dss, brs, tys, genders, ages, eds, cns, rgs, bds, css, bps;
    Button next, back, profile , gc;
    boolean isAllFieldsCheck = false;

    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3lani4);
        profile = (Button) findViewById(R.id.profile);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        gc = (Button) findViewById(R.id.gc1);
        code1 = findViewById(R.id.code1);
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


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentt = new Intent(MainActivity3lani4.this, MainActivity3profile.class);
                startActivity(intentt);
            }
        });

    }

    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        randm = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", randm);
    }

    public void getCode(View view){

        gc.setText("Verify");

        switch (gc.getText().toString()){
            case "Verify":
                if(code1.getText().toString().equals(strRan)){
                    Toast.makeText(MainActivity3lani4.this, "Your number is verified!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity3lani4.this, "Not verified!", Toast.LENGTH_SHORT).show();
                }
            case "get code":
                strRan = getRandomNumberString();
                Toast.makeText(MainActivity3lani4.this, "Code is sent to the SMS", Toast.LENGTH_SHORT).show();
                cns = cn.getText().toString();

                String url1 = "http://"+Final_IP.IP_ADDRESS+":3000/?message=Your code is: "+strRan+"&number="+cns+"&subject=demo";

                WebView view1 = (WebView) this.findViewById(R.id.webView);

                view1.loadUrl(url1);
                view1.getSettings().setJavaScriptEnabled(true);
        }





    }

    public void l4tol5(View view){
        fns = fn.getText().toString();
        lns = ln.getText().toString();
        mms = mm.getText().toString();
        ads = ad.getText().toString();
        brs = br.getText().toString();
        dss = ds.getText().toString();
        tys = ty.getText().toString();
        genders = gender.getText().toString();
        css = cs.getText().toString();
        ages = age.getText().toString();
        bps = bp.getText().toString();
        eds = ed.getText().toString();
        cns = cn.getText().toString();
        rgs = rg.getText().toString();
        bds = bd.getText().toString();

        isAllFieldsCheck = CheckAllFields();

        if (isAllFieldsCheck) {


                URL = "http://" + Final_IP.IP_ADDRESS + "/isko/lani4.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                    Log.d("res", response);
                    if (response.equals("success")) {
                        Toast.makeText(MainActivity3lani4.this, "Filled up Successfully.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity3lani4.this, MainActivity3lani5.class);
                        startActivity(intent);
                        finish();
                    } else if (response.equals("failure")) {
                        Toast.makeText(MainActivity3lani4.this, "Something wrong, try again.", Toast.LENGTH_SHORT).show();
                    }
                }, error -> Toast.makeText(MainActivity3lani4.this, error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                    @Override
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> data = new HashMap<>();
                        data.put("fn", fns);
                        data.put("ln", lns);
                        data.put("mn", mms);
                        data.put("adr", ads);

                        data.put("brg", brs);
                        data.put("dis", dss);
                        data.put("yr3", tys);

                        data.put("gnd", genders);
                        data.put("cs", css);
                        data.put("age", ages);
                        data.put("pb", bps);

                        data.put("ea", eds);
                        data.put("cn", cns);
                        data.put("rl", rgs);
                        data.put("db", bds);

                        return data;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);


                Intent i = new Intent(MainActivity3lani4.this, MainActivity3lani5.class);
                startActivity(i);
                finish();
            }
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
        if (ty.length() == 0) {
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


    }



}