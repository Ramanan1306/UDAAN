package com.example.dashboard_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView Cases, Active, Recovered, TotalDeaths;


    private LinearLayout search, healthinfo, does, dont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        {
            does = findViewById(R.id.does);
            dont = findViewById(R.id.dont);
            search = findViewById(R.id.search);
            healthinfo = findViewById(R.id.healthinfo);


            healthinfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, com.example.dashboard_java.healthinfo.class);
                    startActivity(intent);
                }
            });

            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, countrypage.class);
                    startActivity(intent);
                }
            });

            does.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, dopage.class);
                    startActivity(intent);
                }
            });

            dont.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, more_pg.class);
                    startActivity(intent);
                }
            });

        }
//the below part is collecting the the world covid status
        // that we have given in .XML file
        Cases = findViewById(R.id.allcases);
        Recovered = findViewById(R.id.allrec);
        Active = findViewById(R.id.allactive);
        TotalDeaths = findViewById(R.id.alldeath);

        // Creating a method fetchdata()
        fetchData();
    }


    private void fetchData() {
        // The Link Through Which We Can Fetch Data
        String url = "https://disease.sh/v3/covid-19/all\n";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object2 = new JSONObject(response.toString());
                    Cases.setText(object2.getString("cases"));
                    Active.setText(object2.getString("active"));
                    Recovered.setText(object2.getString("recovered"));
                    TotalDeaths.setText(object2.getString("deaths"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // In case of error it will run
                Toast.makeText(MainActivity.this, "something wents wrong", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    //main page double click back button
    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}



