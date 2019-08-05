package com.example.myapplication.activity;

import android.os.Bundle;
import android.view.Window;

import com.example.myapplication.R;
import com.example.myapplication.common.BaseActivity;
import com.example.myapplication.common.ToolBarOptions;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 2019-08-03 17:07
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class TabLayoutDemoActivity extends BaseActivity {
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    @BindView(R.id.mToolBar)
    Toolbar mToolBar;
    @BindView(R.id.tab_main)
    TabLayout tabMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;

    @Override
    protected void initView() {

//        setSupportActionBar(mToolBar);

        ToolBarOptions options = new ToolBarOptions();
        options.titleId = R.string.empty;
        setToolBar(R.id.mToolBar, options);
        toolbar.setNavigationIcon(R.drawable.nim_actionbar_black_back_icon);
        toolbar.getBackground().setAlpha(0);
//        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.color_login_background));

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpMain.setAdapter(myFragmentPagerAdapter);

        tabMain.setupWithViewPager(vpMain);

        one = tabMain.getTabAt(0);
        two = tabMain.getTabAt(1);
        three = tabMain.getTabAt(2);


    }

    @Override
    protected void initData() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.tab_layout_demo;
    }


}
