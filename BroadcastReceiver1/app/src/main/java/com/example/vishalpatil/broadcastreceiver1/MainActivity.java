package com.example.vishalpatil.broadcastreceiver1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void broadcastIntent(View view)
    {
        Intent intent=new Intent();
        intent.setAction("com.example.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}
