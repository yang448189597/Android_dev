package com.example.myapplication.activity;

import com.example.myapplication.fragment.tab_layout_demo_fragment.Fragment1;
import com.example.myapplication.fragment.tab_layout_demo_fragment.Fragment2;
import com.example.myapplication.fragment.tab_layout_demo_fragment.Fragment3;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/*
 * @Author: Luke
 * @Date: 2019-08-05 16:07
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"Tab 1", "Tab 2", "Tab 3"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new Fragment2();
        } else if (position == 2) {
            return new Fragment3();
        }
        return new Fragment1();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
