package com.example.chenhaoqiang.test.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewStub;
import android.widget.Button;

import com.example.chenhaoqiang.test.R;

public class LayoutLearnActivity extends AppCompatActivity {

    private Button btnVs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_learn);
        initView();

    }

    private void initView(){
        btnVs = findViewById(R.id.btn_show_viewstub);
        btnVs.setOnClickListener(v -> v = ((ViewStub)findViewById(R.id.vs)).inflate());
    }
}
