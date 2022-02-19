package com.example.taguigscholarship;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3lani5 extends AppCompatActivity {
    Button next, back, profile;
    RadioGroup semm, honorr,ladd;
    EditText course, yl, ue, cd,ns, sd;
    boolean validated = false;
    String lns, fns, mms, ads, brs;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3lani5);
        profile = (Button) findViewById(R.id.profile);
        next = (Button) findViewById(R.id.next);
        back= (Button) findViewById(R.id.back);
        semm = findViewById(R.id.sem);
        honorr = findViewById(R.id.honor);
        ladd = findViewById(R.id.lad);
        course = findViewById(R.id.editTextTextPersonName16);
        yl = findViewById(R.id.editTextTextPersonName17);
        ue = findViewById(R.id.editTextTextPersonName18);
        cd = findViewById(R.id.editTextTextPersonName19);
        ns = findViewById(R.id.editTextTextPersonName20);
        sd = findViewById(R.id.editTextTextPersonName21);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(MainActivity3lani5.this, MainActivity3profile.class);
                startActivity(intentt);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validated = validate();

                if(validated){
                    fns = yl.getText().toString();
                    lns = ue.getText().toString();
                    mms = cd.getText().toString();
                    ads = ns.getText().toString();
                    brs = sd.getText().toString();

                    URL = "http://"+Final_IP.IP_ADDRESS+"/isko/lani5.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                        Log.d("res", response);
                        if (response.equals("success")) {
                            Toast.makeText(MainActivity3lani5.this, "Filled up Successfully.", Toast.LENGTH_SHORT).show();

                            Intent intentt = new Intent(MainActivity3lani5.this, MainActivity3lani6.class);
                            startActivity(intentt);
                            finish();

                        } else if (response.equals("failure")) {
                            Toast.makeText(MainActivity3lani5.this, "Something wrong, try again.", Toast.LENGTH_SHORT).show();
                        }
                    }, error -> Toast.makeText(MainActivity3lani5.this, error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                        @Override
                        public Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("yl", fns);
                            data.put("ue", lns);
                            data.put("cd", mms);
                            data.put("ns", ads);

                            data.put("sd", brs);


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

                Intent intentt = new Intent(MainActivity3lani5.this, MainActivity3lani4.class);
                startActivity(intentt);

            }
        });


    }



    private boolean validate() {
        int isSelected = semm.getCheckedRadioButtonId();
        int isSelected1 = honorr.getCheckedRadioButtonId();
        int isSelected2 = ladd.getCheckedRadioButtonId();
        if (isSelected2 == -1) {
            Toast.makeText(MainActivity3lani5.this,"You have not selected in Ladderized",Toast.LENGTH_LONG ).show();
            return false;
        }
        if (isSelected1 == -1) {
            Toast.makeText(MainActivity3lani5.this,"You have not selected in Honor",Toast.LENGTH_LONG ).show();
            return false;
        }
          if (isSelected == -1) {
            Toast.makeText(MainActivity3lani5.this ,"You have not selected in Sem",Toast.LENGTH_LONG ).show();
            return false;
        }
        if (yl.length()  <= 1) {
            yl.setError("Year level must be 1 to 5 is required");
            return false;
        }
        if (ue.length() >= 15) {
            ue.setError("No. of Unite Enrolled must be minimuin of 15 required");
            return false;
        }
        if (cd.length() == 0) {
            cd.setError("Course is required");
            return false;
        }
        if (ns.length() == 0) {
            ns.setError("Name of School is required");
            return false;
        }
        else if (sd.length() == 0) {
            sd.setError("School Address is required");
            return false;
        }


         return true;
    }
}