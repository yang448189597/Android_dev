package com.example.myapplication.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.myapplication.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Author: Luke
 * @Date: 2019-08-02 14:37
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Unbinder mBinder;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResId());
        mBinder = ButterKnife.bind(this);
        initStatus();
        initView();
        initData();
    }

    private void initStatus() {}

    //对于方法中具体的操作不明确时，使用abstract方法；;
    protected abstract void initView();
    protected abstract void initData();
    public abstract int getContentViewResId();

    //启动Activity
    protected void startActivity(Class<?> clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        mBinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public void setToolBar(int toolBarId, ToolBarOptions options) {
        toolbar = (Toolbar) findViewById(toolBarId);
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.black));
        if (options.titleId != 0) {
            toolbar.setTitle(options.titleId);
        }
        if (!TextUtils.isEmpty(options.titleString)) {
            toolbar.setTitle(options.titleString);
        }

        setSupportActionBar(toolbar);

        if (options.isNeedNavigate) {
            toolbar.setNavigationIcon(options.navigateId);
            toolbar.setNavigationOnClickListener(v -> onNavigateUpClicked());
        }
    }

    public void onNavigateUpClicked() {
        onBackPressed();
    }
}
