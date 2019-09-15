package com.example.vishalpatil.smsmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.telephony.SmsManager;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText mob;
    EditText mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Send SMS","");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        mob=(EditText)findViewById(R.id.mob);
        mess=(EditText)findViewById(R.id.mess);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendsms();
            }
        });
    }
    protected void sendsms()
    {
        String s1=mob.getText().toString();
        String s2=mess.getText().toString();
        try {
            SmsManager smsmanager = SmsManager.getDefault();
            smsmanager.sendTextMessage(s1, null, s2, null, null);
            Toast.makeText(getApplicationContext(), "Sms sent", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
