package com.example.chenhaoqiang.test.eventbus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chenhaoqiang.test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBusActivity extends AppCompatActivity {

    private Button btnPublisher, btnSubscriber;
    private TextView textShow;

    public static void lanuch(Context context){
        Intent toThere = new Intent(context, EventBusActivity.class);
        context.startActivity(toThere);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        EventBus.getDefault().register(this);
    }

    private void initView(){
        btnPublisher = findViewById(R.id.button_publisher);
        btnSubscriber = findViewById(R.id.button_subscriber);
        textShow = findViewById(R.id.text_show);
        btnPublisher.setOnClickListener(postMessage);
    }

    @Subscribe
    public void subscriber(MessageEvent messageEvent){
        textShow.setText(messageEvent.getMessage());
    }

    View.OnClickListener postMessage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MessageEvent messageEvent = new MessageEvent("This is a MessageEvent");
            EventBus.getDefault().post(messageEvent);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
