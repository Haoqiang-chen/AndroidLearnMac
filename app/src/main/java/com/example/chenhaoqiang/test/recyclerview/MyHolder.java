package com.example.chenhaoqiang.test.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chenhaoqiang.test.R;

/**
 * ViewHolder理解为view的持有者，用于描述RecyclerView中相应位置上的Item View 或者 元数据，主要是用于获取Item的控件
 *
 * @author chenhaoqiang
 * @date 2018/7/12
 */
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
