package com.example.chenhaoqiang.test.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chenhaoqiang.test.R;

public class MyHolder extends RecyclerView.ViewHolder {
    
    private TextView showText;
    public MyHolder(View itemView) {
        super(itemView);
        showText = itemView.findViewById(R.id.recyclerview_list_item);
    }

    public TextView getShowText() {
        return showText;
    }
}
