package com.example.myapplication.fragment.app_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.fragment.adapter.MyPagerAdapter;
import com.example.myapplication.fragment.home_fragment.LabelViewDemoFragment;
import com.example.myapplication.fragment.home_fragment.SimpleCardFragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 2019-07-29 15:47
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.tab_view)
    SegmentTabLayout tabView;
    @BindView(R.id.home_viewPager)
    ViewPager homeViewPager;
    @BindView(R.id.home_fragment_layout)
    LinearLayout homeFragmentLayout;

    private String[] mTitles = {"LabelView","CustomView", "MoreView","...."};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View mView = inflater.inflate(R.layout.home_fragment_layout, null);
        ButterKnife.bind(this, mView);

        mFragments.add(new LabelViewDemoFragment());
        mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + mTitles[1]));
        mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + mTitles[2]));
        mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + mTitles[3]));

        initViewPager();
        return mView;
    }

    private void initViewPager() {
        homeViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), mFragments, mTitles));
        tabView.setTabData(mTitles);
        tabView.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                homeViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        homeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabView.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
