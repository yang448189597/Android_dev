package com.example.myapplication.activity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.R;
import com.example.myapplication.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 2019-08-14 20:27
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class LottieDemoActivity extends BaseActivity {
    @BindView(R.id.lottie_view)
    LottieAnimationView lottieView;

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.lottie_demo_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
