package com.example.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.common.BaseActivity;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.interfaces.OnCancelListener;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * @Author: Luke
 * @Date: 2019-08-05 20:08
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class XPopupDemoActivity extends BaseActivity {
    @BindView(R.id.xPopup_btn_1)
    Button xPopupBtn1;
    @BindView(R.id.xPopup_btn_2)
    Button xPopupBtn2;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.xpopup_demo_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.xPopup_btn_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xPopup_btn_1:
                BasePopupView popupView = new XPopup.Builder(this).asLoading();
                popupView.show();
                break;
        }
    }

    @OnClick(R.id.xPopup_btn_2)
    public void onViewClicked() {
        OnConfirmListener confirmListener = () -> {
            Toast.makeText(this,"ySE",Toast.LENGTH_SHORT).show();
        };
        OnCancelListener cancelListener = () -> Toast.makeText(getBaseContext(),"No",Toast.LENGTH_SHORT).show();
        BasePopupView popupView = new XPopup.Builder(this).asConfirm("请确认","你确认继续操作嘛？","YES","No",confirmListener,cancelListener,false);
        popupView.show();
    }
}
