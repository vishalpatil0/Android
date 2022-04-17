package com.example.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectRequest extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object_request);
        textView=(TextView) findViewById(R.id.textview);

        RequestQueue requestQueue; //request queue object is defined from RequestQueue class provided volley library.
        requestQueue= Volley.newRequestQueue(getApplicationContext()); //got initialized with this activity.

        com.android.volley.toolbox.JsonObjectRequest jsonObjectRequest=new com.android.volley.toolbox.JsonObjectRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos/1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String temp=response.getString("title");
                    textView.setText(temp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String temp=error.toString();
                textView.setText(temp);
            }
        });
        //Adding jsonobject to request to get executed
        requestQueue.add(jsonObjectRequest);
    }
}