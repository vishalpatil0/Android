package com.example.vishalpatil.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String msg="Vishal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg,"The onCreate() event");
        Toast.makeText(MainActivity.this,"Oncreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg,"The onStart() event");
        Toast.makeText(MainActivity.this,"OnStart",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg,"The onResume() event");
        Toast.makeText(MainActivity.this,"OnResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg,"The onPause() event");
        Toast.makeText(MainActivity.this,"onPause",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg,"The onStop() event");
        Toast.makeText(MainActivity.this,"OnStop",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg,"The onDestroy() event");
        Toast.makeText(MainActivity.this,"OnDestroy",Toast.LENGTH_SHORT).show();
    }

}
