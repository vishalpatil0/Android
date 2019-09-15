package com.example.vishalpatil.services1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View v)
    {
        startService(new Intent(getBaseContext(),MyService.class));
    }
    public void stopService(View v)
    {
        stopService(new Intent(getBaseContext(),MyService.class));
    }
}
