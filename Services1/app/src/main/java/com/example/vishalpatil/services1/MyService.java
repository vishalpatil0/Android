package com.example.vishalpatil.services1;

import android.content.Intent;
import android.app.Service;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public IBinder onBind(Intent arg0)
    {
        return null;
    }
    public int onStartCommand(Intent intent,int startId,int flags)
    {
        Toast.makeText(getBaseContext(),"Service Started",Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getBaseContext(),"Service Destroyed",Toast.LENGTH_SHORT).show();
    }
}
