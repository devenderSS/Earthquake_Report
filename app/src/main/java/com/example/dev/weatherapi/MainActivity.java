package com.example.dev.weatherapi;

import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et = (EditText)findViewById(R.id.editText);// refers to an editable text field
        Button bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() { // On clicking go button
            @Override
            public void onClick(View v) {
                String minMag = et.getText().toString(); // get text from text field
                Intent i = new Intent(MainActivity.this,EarthquakesActivity.class); // add intent to open next activity
                i.putExtra("key", minMag);//pass a string to next activity
                startActivity(i);//start next activity
            }
        });



    }





}
