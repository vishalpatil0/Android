package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView) findViewById(R.id.gridView);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("DSA"));
        courseModelArrayList.add(new CourseModel("JAVA"));
        courseModelArrayList.add(new CourseModel("C++"));
        courseModelArrayList.add(new CourseModel("Python"));
        courseModelArrayList.add(new CourseModel("Javascript"));
        courseModelArrayList.add(new CourseModel("DSA"));
        GVAdapter gvAdapter=new GVAdapter(this,courseModelArrayList);
        gridView.setAdapter(gvAdapter);
    }
}