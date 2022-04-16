package com.example.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button add;
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        editText=findViewById(R.id.editext);
        textView=findViewById(R.id.textview);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=editText.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("string1",msg);
                editor.apply();
            }
        });
        //on launching application chekcing is there is any shared preference available.
        SharedPreferences shrdp=getSharedPreferences("demo",MODE_PRIVATE);
        String temp=shrdp.getString("string1","Nothing in shared preferences please enter some to show here.");
        textView.setText(temp);
    }
}