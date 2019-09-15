package com.example.vishalpatil.email;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
    protected void sendEmail()
    {
        Log.i("Send Email","");
        String[] TO={"dvp298200@gmail.com"};
        String[] CC={"vishalgpatil10@gmail.com"};
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/palin");

        emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
        emailIntent.putExtra(Intent.EXTRA_CC,CC);
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Yor email text goes here");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your subject");
        try{
            startActivity(Intent.createChooser(emailIntent,"send email...."));
            finish();
            Log.i("Finished sending email","");
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(MainActivity.this,"No client found",Toast.LENGTH_SHORT).show();
        }
    }
}
