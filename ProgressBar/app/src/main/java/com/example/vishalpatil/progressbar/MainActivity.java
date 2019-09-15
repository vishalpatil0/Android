package com.example.vishalpatil.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.app.ProgressDialog;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress=new ProgressDialog(this);
    }
    public void open(View v) {
        progress.setMessage("Downloading music:)");
        progress.setIndeterminate(true);
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.show();

        final int totalprogress = 100;
         Thread t = new Thread() {
            public void run() {
                int jumptime = 0;
                while (jumptime < totalprogress) {
                    try {
                        sleep(200);
                        jumptime += 5;
                        progress.setProgress(jumptime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

}
