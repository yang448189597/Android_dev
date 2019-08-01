package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.fragment.adapter.MyPagerAdapter;
import com.example.myapplication.fragment.home_fragment.SimpleCardFragment;
import com.flyco.tablayout.SlidingTabLayout;
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
public class FirstFragment extends Fragment {
    @BindView(R.id.tl_1)
    SlidingTabLayout tl1;
    @BindView(R.id.vp)
    ViewPager vp;


    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    private MyPagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fist_fragment_layout, null);
        ButterKnife.bind(this, mView);

        mAdapter = new MyPagerAdapter(getChildFragmentManager(), mFragments, mTitles);

        vp.setAdapter(mAdapter);

        tl1.setViewPager(vp);

        tl1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tl1.setCurrentTab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return mView;
    }
}
