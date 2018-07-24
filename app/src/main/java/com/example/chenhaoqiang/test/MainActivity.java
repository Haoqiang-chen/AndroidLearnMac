package com.example.chenhaoqiang.test;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chenhaoqiang.test.eventbus.EventBusActivity;
import com.example.chenhaoqiang.test.eventbus.MessageEvent;
import com.example.chenhaoqiang.test.json.CreatJson;
import com.example.chenhaoqiang.test.json.GsonTest;
import com.example.chenhaoqiang.test.recyclerview.RecyclerActivity;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private Button btnSecond,btnThird, btnRecyclerView, btnEventBus;
    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("create", "create");
        btnSecond = findViewById(R.id.button_second);
        btnSecond.setOnClickListener(toSecond);
        requestAllPremission();
        btnThird = findViewById(R.id.button_third);
        btnThird.setOnClickListener(toThird);
        btnRecyclerView = findViewById(R.id.button_recyclerview);
        btnRecyclerView.setOnClickListener(toSecyclerView);
        txtShow = findViewById(R.id.show);
        txtShow.setText("@ ·");
        btnEventBus = findViewById(R.id.button_eventbus);
        btnEventBus.setOnClickListener(toEventBus);
        EventBus.getDefault().postSticky(new MessageEvent("StickyEvent"));
        /*JSON Test*/
        CreatJson creatJson = new CreatJson();
        /*GSON 学习*/
        GsonTest gsonTest = new GsonTest();

        /*测试类型转换*/
        long x = 10280000;
        long y = 10250000;
        double z = (x -y)/ 500000;
        int c = 100;
        int s = (int)(z * c);

        BigDecimal xx = new BigDecimal(Long.toString(x));
        BigDecimal yy = new BigDecimal(Long.toString(y));
        BigDecimal zz = xx.subtract(yy);
        BigDecimal i = new BigDecimal(Long.toString(500000));
        BigDecimal zzz = zz.divide(i);
        BigDecimal cc = new BigDecimal(Integer.toString(c));
        BigDecimal ss = zzz.multiply(cc);
        int sum = ss.intValue();


    }
    private View.OnClickListener toEventBus = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EventBusActivity.lanuch(MainActivity.this);
        }
    };
    private View.OnClickListener toSecond = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            i.setClass(MainActivity.this, SecondActivity.class);
            startActivity(i);
        }
    };

    private View.OnClickListener toThird = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            i.setClass(MainActivity.this, ThirdActivity.class);
            startActivity(i);
        }
    };
    private View.OnClickListener toSecyclerView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            i.setClass(MainActivity.this, RecyclerActivity.class);
            startActivity(i);
        }
    };
    /*申请权限*/
    public void requestAllPremission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e("start", "start");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.e("Restart", "Restart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e("resume", "resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e("pause", "pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e("stop", "stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("destroy", "destroy");
    }
}
