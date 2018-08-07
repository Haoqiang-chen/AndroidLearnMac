package com.example.chenhaoqiang.test.recyclerview;

import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;


import com.example.chenhaoqiang.test.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity implements RecyclerViewItemClickCallBack {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<String> database = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerview_list);

        /*在使用Recyclerview时需要设置布局管理器：分为线性、网格、瀑布管理器*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        /*网格布局，无分割线*/
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        /*瀑布布局可以实现网格布局的样式*/
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        /*使用recyclerView.addItemDecoration（）来为Item添加分割线*/
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        initDatabase();
        myAdapter = new MyAdapter(this, database);
        /*RecyclerView需要自己实现监听接口*/
        myAdapter.setRecyclerViewItemClickCallBack(this);
        recyclerView.setAdapter(myAdapter);


    }

    private void initDatabase() {
        for (int i = 0; i < 100; i++) {
            database.add("Item" + Integer.toString(i + 1));
        }
    }

    @Override
    public void onItemclick(int position) {
        Toast.makeText(this, "Click " + Integer.toString(position), Toast.LENGTH_SHORT).show();
        myAdapter.addItem(position);
        if (position == 0) {
            recyclerView.scrollToPosition(0);//为了显示在第一个Item之前添加的Item
        }
    }

    @Override
    public void onTiemLongClick(int position) {
        myAdapter.deleteItem(position);
    }
}
