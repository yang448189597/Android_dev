package com.example.myapplication;

import com.example.myapplication.common.BaseActivity;
import com.example.myapplication.fragment.app_fragment.DemosFragment;
import com.example.myapplication.fragment.app_fragment.FirstFragment;
import com.example.myapplication.fragment.app_fragment.HomeFragment;
import com.example.myapplication.fragment.app_fragment.SettingFragment;
import com.example.myapplication.view.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.stl_main)
    CommonTabLayout stlMain;

    private ArrayList<Fragment> mFragments;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private String[] mTitles_2 = {"首页", "内容", "实例","设置"};

    private int[] mIconUnselectIds = {
            R.mipmap.home_icon, R.mipmap.bluetooth_icon,R.mipmap.demo_icon,
            R.mipmap.face};

    private int[] mIconSelectIds = {
            R.mipmap.home_icon, R.mipmap.bluetooth_icon,
            R.mipmap.demo_icon, R.mipmap.face};

    @Override
    protected void initView() {

        for (int i = 0; i < mTitles_2.length; i++) {
            mTabEntities.add(new TabEntity(mTitles_2[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }


        mFragments = new ArrayList<>();
        mFragments.add(new FirstFragment());
        mFragments.add(new HomeFragment());
        mFragments.add(new DemosFragment());
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

    @Override
    protected void initData() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
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
