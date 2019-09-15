package com.example.vishalpatil.activity4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public IBinder onBind(Intent arg0)
    {
        return null;
    }
    public int onStartCommand(Intent intent,int flags,int startID)
    {
        Toast.makeText(this,"service started",Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"destr",Toast.LENGTH_SHORT).show();
    }
}
