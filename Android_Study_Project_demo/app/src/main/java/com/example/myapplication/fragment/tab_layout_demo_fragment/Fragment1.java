package com.example.myapplication.fragment.tab_layout_demo_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
 * @Author: Luke
 * @Date: 2019-08-05 16:08
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class Fragment1 extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        initdata();
        mRecyclerView.setAdapter(new MyAdapter(mDatas));
        return view;
    }
    private void initdata() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 45; i++) {
            mDatas.add("item" + i);
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<String> mDatas;

        //创建构造参数，用来接受数据集
        public MyAdapter(List<String> datas) {
            this.mDatas = datas;
        }

        //创建ViewHolder
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //加载布局文件，记得传入parent而不是null
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycle, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        //绑定ViewHolder
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //将数据填充到具体的view中
            holder.tv.setText(mDatas.get(position));
        }


        @Override
        public int getItemCount() {
            return mDatas.size();
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.recycle_tv);

        }
    }
}
