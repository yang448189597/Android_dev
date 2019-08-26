package com.example.myapplication.activity;

import com.example.myapplication.R;
import com.example.myapplication.common.BaseActivity;

import io.flutter.facade.FlutterFragment;

/*
 * @Author: Luke
 * @Date: 2019-08-26 16:11
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class FlutterDemoActivity extends BaseActivity {
    @Override
    protected void initView() {
        FlutterFragment flutterFragment = new FlutterFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flutter_demo,flutterFragment).commit();


    }

    @Override
    protected void initData() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.flutter_demo_layout;
    }
}
