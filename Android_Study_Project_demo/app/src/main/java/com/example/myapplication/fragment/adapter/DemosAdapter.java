package com.example.myapplication.fragment.adapter;

import com.example.myapplication.R;
import com.example.myapplication.model.DemosItem;
import com.example.myapplication.view.RecyclerView.adapter.BaseQuickAdapter;
import com.example.myapplication.view.RecyclerView.adapter.BaseViewHolder;

import java.util.List;

import androidx.annotation.Nullable;

/*
 * @Author: Luke
 * @Date: 2019-08-08 11:44
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class DemosAdapter extends BaseQuickAdapter<DemosItem, BaseViewHolder> {

    public DemosAdapter(int layoutResId, @Nullable List<DemosItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DemosItem item) {
        helper.setText(R.id.text,item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResourse());

    }
}
