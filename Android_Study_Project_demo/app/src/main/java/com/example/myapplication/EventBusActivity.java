package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        messageView.setText("Message from SecondActivity:"+messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消事件
        EventBus.getDefault().unregister(this);
    }
}
