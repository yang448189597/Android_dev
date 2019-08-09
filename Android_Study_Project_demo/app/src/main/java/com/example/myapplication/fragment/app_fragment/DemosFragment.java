package com.example.myapplication.fragment.app_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.activity.DemoButtonActivity;
import com.example.myapplication.activity.EventBusActivity;
import com.example.myapplication.activity.TabLayoutDemoActivity;
import com.example.myapplication.activity.TestActivity;
import com.example.myapplication.fragment.adapter.DemosAdapter;
import com.example.myapplication.model.DemosItem;
import com.example.myapplication.view.RecyclerView.adapter.BaseQuickAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 2019-08-08 11:21
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class DemosFragment extends Fragment {

    private static final Class<?>[] ACTIVITY = {DemoButtonActivity.class, EventBusActivity.class, TestActivity.class, TabLayoutDemoActivity.class,
            DemoButtonActivity.class, EventBusActivity.class, TestActivity.class, TabLayoutDemoActivity.class,
            DemoButtonActivity.class, EventBusActivity.class, TestActivity.class, TabLayoutDemoActivity.class};
    private static final String[] TITLE = {"Demo1", "Demo2", "Demo3", "Demo4","Demo1", "Demo2", "Demo3", "Demo4","Demo1", "Demo2", "Demo3", "Demo4"};
    private static final int[] IMG = {R.mipmap.demo_1,R.mipmap.demo_2,R.mipmap.demo_3,R.mipmap.demo_4,
            R.mipmap.demo_1,R.mipmap.demo_2,R.mipmap.demo_3,R.mipmap.demo_4,
            R.mipmap.demo_1,R.mipmap.demo_2,R.mipmap.demo_3,R.mipmap.demo_4};
    private ArrayList<DemosItem> mDataList;

    @BindView(R.id.demos_recyclerView)
    RecyclerView demosRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.demos_fragment_layout, null);
        ButterKnife.bind(this, mView);
        initView();
        initAdapter();
        return mView;
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            DemosItem item = new DemosItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResourse(IMG[i]);
            mDataList.add(item);
        }
    }

    private void initView() {
        demosRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    private void initAdapter() {
        BaseQuickAdapter demoAdapter = new DemosAdapter(R.layout.demos_item_view,mDataList);
        demoAdapter.openLoadAnimation();
            View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) demosRecyclerView.getParent(), false);
        demoAdapter.addHeaderView(top);
        demoAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getActivity(), ACTIVITY[position]);
            startActivity(intent);
        });

        demosRecyclerView.setAdapter(demoAdapter);


    }


}
