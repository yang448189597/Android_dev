package com.example.myapplication.fragment.tab_layout_demo_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 * @Author: Luke
 * @Date: 2019-08-05 16:11
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class Fragment3 extends Fragment {

    private int mPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);
    }
}
