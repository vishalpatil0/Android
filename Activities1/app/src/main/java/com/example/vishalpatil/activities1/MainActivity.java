package com.example.vishalpatil.activities1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String msg="Android :";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg,"The OnCreate() event");
        Toast.makeText(getBaseContext(),"Activity Created",Toast.LENGTH_SHORT).show();
    }
    protected void onStart()
    {
        super.onStart();
        Log.d(msg,"The onStart() event");
        Toast.makeText(getBaseContext(),"Activity Started",Toast.LENGTH_SHORT).show();

    }
    protected void onResume()
    {
        super.onResume();
        Log.d(msg,"The onResume() event");
        Toast.makeText(getBaseContext(),"Activity Resumed",Toast.LENGTH_SHORT).show();
    }
    protected void onPause()
    {
        super.onPause();
        Log.d(msg,"The onPause() event");
        Toast.makeText(getBaseContext(),"Activity Paused",Toast.LENGTH_SHORT).show();
    }
    protected void onStop()
    {
        super.onStop();
        Log.d(msg,"The onStop() event");
        Toast.makeText(getBaseContext(),"Activity Stopped",Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(msg,"The onDestroy() event");
        Toast.makeText(getBaseContext(),"Activity Destroyed",Toast.LENGTH_SHORT).show();
    }
}
