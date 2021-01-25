package com.example.dashboard_java;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class searchpage extends AppCompatActivity {

	ListView listView;
	Toolbar toolbar;
    List<Model> modelList = new ArrayList<>();

    Model model;
	Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_main);
		listView = findViewById(R.id.listView);
		fetchData();

		toolbar=findViewById(R.id.toolbar);
		this.setSupportActionBar(toolbar);
		this.getSupportActionBar().setTitle("");

	}

private void fetchData() {
        // The Link Through Which We Can Fetch Data
        String url = "https://disease.sh/v3/covid-19/countries\n";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object2 = array.optJSONObject(i);


                            String country = object2.getString("country");
                            String active = object2.getString("active");
                            String cases = object2.getString("cases");
                            String deaths = object2.getString("deaths");
                            String recovered = object2.getString("recovered");
                            String todayCases = object2.getString("todayCases");
                            String todayDeaths = object2.getString("todayDeaths");
                            String confRec = object2.getString("recovered");


                            model = new Model(country, cases, deaths, recovered, active,
                                    todayCases, todayDeaths, confRec);
                            // placing data into the app using AdapterClass
                            modelList.add(model);


                            adapter = new Adapter(searchpage.this, modelList);
                            listView.setAdapter(adapter);
                        }

                }   catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // In case of error it will run
                Toast.makeText(searchpage.this,"Turn on mobile data", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem=menu.findItem(R.id.search_view);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.search_view){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}