package com.example.chenhaoqiang.test.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenhaoqiang.test.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<String> database;
    public MyAdapter(List<String> database){
        this.database = database;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_item, parent, false);
        MyHolder myHolder = new MyHolder(rootView);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.getShowText().setText(database.get(position));
    }

    @Override
    public int getItemCount() {
        return database.size();
    }

}
