package com.example.vishalpatil.fragment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration config=getResources().getConfiguration();
        FragmentManager fragmentmanager=getFragmentManager();
        FragmentTransaction fragmenttransaction=fragmentmanager.beginTransaction();
        if(config.orientation==Configuration.ORIENTATION_LANDSCAPE)
        {
            LM_Fragement ls_fragement=new LM_Fragement();
            fragmenttransaction.replace(android.R.id.content,ls_fragement);
        }
        else
        {
            PM_Fragement pm_fragement=new PM_Fragement();
            fragmenttransaction.replace(android.R.id.content,pm_fragement);
        }
        fragmenttransaction.commit();
    }
}
