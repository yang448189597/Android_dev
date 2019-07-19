package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 * @Author: Luke
 * @Date: 2019-07-19 14:53
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventbus_second_layout);

        final EditText messageET = findViewById(R.id.message_et);

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageET.getText().toString();
                if(TextUtils.isEmpty(message)){
                    message = "message default";
                }

                // post 消息
                EventBus.getDefault().post(new MessageEvent(message));

            }
        });
    }
}
