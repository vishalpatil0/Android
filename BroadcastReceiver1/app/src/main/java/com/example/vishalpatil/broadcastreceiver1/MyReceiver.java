package com.example.vishalpatil.broadcastreceiver1;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public void onReceive(Context context,Intent intent)
    {
        Toast.makeText(context,"Intent Detected",Toast.LENGTH_SHORT).show();
    }
}
