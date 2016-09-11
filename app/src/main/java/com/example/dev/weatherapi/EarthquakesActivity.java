package com.example.dev.weatherapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class EarthquakesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquakes);
        Intent i = getIntent(); //recieve text from previous activity
        String minmag = i.getExtras().getString("key"); //store magnitude from main activity to min mag
        RequestQueue queue = Volley.newRequestQueue(this);   // make a request queue object

        String url = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&limit=100&minmagnitude="+minmag; // append minmag to original url
        //define a string request object to get response from url

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            //define what happens when response is recieved correctly
            ArrayList<Earthquakes> earthquakes;
            @Override
            public void onResponse(String response) {

                earthquakes = QueryUtils.extractData(response); // getting arraylist from QueryUtils' method
                connect(earthquakes);

            }
            //define what happens when an error occurs
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest); // pass the object to queue for making connection
    }
    public void connect(ArrayList<Earthquakes> earthquakes){
        EarthquakeAdapter adapter = new EarthquakeAdapter(EarthquakesActivity.this, earthquakes); //setthing arrayAdapter to display data on arrayList
        ListView ev = (ListView)findViewById(R.id.list); //defining List
        ev.setAdapter(adapter); //setting Adapter on List

    }
}
