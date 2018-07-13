package com.example.chenhaoqiang.test.eventbus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenhaoqiang.test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {

    private Button btnPublisher, btnStickyEvent;
    private TextView textShow;

    public static void lanuch(Context context) {
        Intent toThere = new Intent(context, EventBusActivity.class);
        context.startActivity(toThere);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        /*将此Activity注册为订阅者即subscriber*/
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        btnPublisher = findViewById(R.id.button_publisher);
        btnStickyEvent = findViewById(R.id.button_stickyevent);
        textShow = findViewById(R.id.text_show);
        btnPublisher.setOnClickListener(postMessage);
    }

    /**线程模式：EventBus支持订阅者处理事件的方法在不同于发布事件所在线程的线程中执行
     * ThreadMode.POSTING：默认的线程模式，订阅者方法将在发布事件所在线程中执行
     * ThreadMode.MAIN：订阅者方法将在主线程中被调用
     * ThreadMode.MAIN_ORDERED：订阅者方法将在主线程中被调用，事件会先进入队列再发送给订阅者，使得事件保持串行执行
     * ThreadMode.BACKGROUND：若发布事件位于主线程，则启动一个后台进程按顺序分发事件，若发布事件位于其他进程则订阅者方法直接在该进程中被调用
     * ThreadMode.ASYNC：订阅者方法将在一个单独的线程中被调用,EventBus使用线程池来重用线程*/
    /*subscriber定义事件的处理方法即订阅者方法 使用@Subscribe注解进行定义*/
    @Subscribe
    public void subscriber(MessageEvent messageEvent) {
        textShow.setText(messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void subDefault(MessageEvent messageEvent){
        Log.e("sub", messageEvent.getMessage() + "  posting  " + Thread.currentThread().getName());
    }

    /**在订阅者方法拥有相同的线程模式下可以为订阅者方法设置优先级，默认优先级为0，数值越高优先级越高，高优先级的订阅者方法将优先收到事件
    * 在POSTING线程模式下还可以取消事件的传递*/
    @Subscribe(threadMode = ThreadMode.POSTING, priority = 1)
    public void subDefaultPriority(MessageEvent messageEvent){
        Log.e("sub", messageEvent.getMessage() + "  postingPriority  " + Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void subMain(MessageEvent messageEvent){
        Log.e("sub", messageEvent.getMessage() +  "  main  " + Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void subMainOrdered(MessageEvent messageEvent){
        Log.e("sub", messageEvent.getMessage() +  "  mainOrdered  " + Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void subBackground(MessageEvent messageEvent){
        Log.e("sub", messageEvent.getMessage() +  "  background  " + Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void subAsync(MessageEvent messageEvent){
        Log.e("sub", messageEvent.getMessage() +  "  async  " + Thread.currentThread().getName());
    }

    /**粘性事件
     * 对于普通事件，若先发布事件然后再订阅事件则订阅者收不到该事件
     * 粘性事件：将一个事件定义为粘性事件，则EventBus将在内存中对该事件进行缓存，此时若有订阅者订阅了该事件则订阅者可以收到该事件*/
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void recieveStickyEvent(MessageEvent messageEvent){
        Toast.makeText(this, messageEvent.getMessage() + Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
    }
    View.OnClickListener postMessage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*publisher发布事件*/
            MessageEvent messageEvent = new MessageEvent("This is a MessageEvent");
            EventBus.getDefault().post(messageEvent);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        /*将此Activity取消注册为订阅者即subscriber*/
        EventBus.getDefault().unregister(this);
    }
}
