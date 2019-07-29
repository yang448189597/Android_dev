package com.example.myapplication;

import android.os.Bundle;

import com.example.myapplication.fragment.FirstFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.SettingFragment;
import com.example.myapplication.view.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.stl_main)
    CommonTabLayout stlMain;

    private ArrayList<Fragment> mFragments;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private String[] mTitles_2 = {"首页", "内容", "设置"};

    private int[] mIconUnselectIds = {
            R.mipmap.home_icon, R.mipmap.bluetooth_icon,
            R.mipmap.face};

    private int[] mIconSelectIds = {
            R.mipmap.home_icon, R.mipmap.bluetooth_icon,
            R.mipmap.face};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; i < mTitles_2.length; i++) {
            mTabEntities.add(new TabEntity(mTitles_2[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }



        mFragments = new ArrayList<>();
        mFragments.add(new FirstFragment());
        mFragments.add(new HomeFragment());
        mFragments.add(new SettingFragment());

        vpMain.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        stlMain.setTabData(mTabEntities);
        stlMain.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpMain.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                stlMain.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        stlMain.setCurrentTab(0);

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles_2[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}
