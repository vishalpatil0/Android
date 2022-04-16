package com.example.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity {

    private Button arrayObject,stringObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        arrayObject=findViewById(R.id.arrayObject);
        arrayObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChoiceActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        stringObject=findViewById(R.id.stringObject);
        stringObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChoiceActivity.this,StringObjectActivity.class);
                startActivity(i);
            }
        });
    }
}