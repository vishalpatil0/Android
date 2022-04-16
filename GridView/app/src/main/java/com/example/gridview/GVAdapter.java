package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class GVAdapter extends ArrayAdapter<CourseModel> {
    public GVAdapter(@NonNull Context context, ArrayList<CourseModel> courseModelArrayList)
    {
        super(context,0,courseModelArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        CourseModel courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.textView);
        courseTV.setText(courseModel.getCourse_name());
        return listitemView;
    }
}
