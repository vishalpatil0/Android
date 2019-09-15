package com.example.vishalpatil.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    @Override
    public IBinder onBind(Intent arg0)
    {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId)
    {
        Toast.makeText(this,"Service started",Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"service destroy",Toast.LENGTH_LONG).show();
    }
}
