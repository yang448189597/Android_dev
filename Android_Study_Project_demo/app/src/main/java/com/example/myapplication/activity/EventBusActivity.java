package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.EventBus.MessageEvent;
import com.example.myapplication.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 * @Author: Luke
 * @Date: 2019-07-19 14:35
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class EventBusActivity extends AppCompatActivity{

    TextView messageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventbus_activity_one);
        // 注册事件
        EventBus.getDefault().register(this);

        messageView = findViewById(R.id.message_view);
        Button nextBtn = findViewById(R.id.next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventBusActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    // EventBus 中四种线程模型 Posting Main Background Async
    // post 如果使用事件处理函数指定了post 线程模型，那么该事件就会在这个线程中运行，事件的发布和接受在统一线程
    // main 在UI线程中执行，主要用于更新UI，不能使用耗时操

    // BackgroundThread 那么如果事件是在UI线程中发布出来的，那么该事件处理函数就会在新的线程中运行，如果事件本来就是子线程中发布出来的，那么该事件处理函数直接在发布事件的线程中执行。
    // 在此事件处理函数中禁止进行UI更新操作。

    // Async 无论在哪个线程发布，该事件处理都会在新的线程中执行，禁止UI更新操作

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        messageView.setText("Message from SecondActivity:"+messageEvent.getMessage());
    }


//    @Subscribe(threadMode = ThreadMode.ASYNC)
//    public void onMessageEvent(MessageEvent messageEvent){
//        messageView.setText("Message from SecondActivity:"+messageEvent.getMessage());
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消事件
        EventBus.getDefault().unregister(this);
    }
}
