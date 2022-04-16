package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<String> arrayList;
    private ItemClickListener itemClickListener;
    private LayoutInflater layoutInflater;

    public MyRecyclerViewAdapter(Context context, ArrayList<String> arrayList)
    {
        this.layoutInflater=LayoutInflater.from(context);
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
// stores and recycles views as they are scrolled off screen
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView myTextView;

    ViewHolder(View itemView) {
        super(itemView);
        myTextView = itemView.findViewById(R.id.textview);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }
}
