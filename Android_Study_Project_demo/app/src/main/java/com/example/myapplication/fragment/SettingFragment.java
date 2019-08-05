package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.myapplication.R;
import com.example.myapplication.activity.DemoButtonActivity;
import com.example.myapplication.activity.GithubWebActivity;
import com.example.myapplication.activity.TabLayoutDemoActivity;
import com.example.myapplication.view.CircleImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * @Author: Luke
 * @Date: 2019-07-29 15:47
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class SettingFragment extends Fragment {
    @BindView(R.id.head_view)
    CircleImageView headView;
    @BindView(R.id.setting)
    RelativeLayout setting;
    @BindView(R.id.about)
    RelativeLayout about;
    @BindView(R.id.gitHub)
    RelativeLayout gitHub;
    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.demo_button)
    RelativeLayout demoButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.setting_fragment_layout, null);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @OnClick({R.id.head_view, R.id.setting, R.id.about, R.id.gitHub, R.id.back,R.id.demo_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.demo_button:
                startActivity(new Intent(getContext(), DemoButtonActivity.class));
                break;
            case R.id.head_view:
                break;
            case R.id.setting:
                startActivity(new Intent(getContext(), TabLayoutDemoActivity.class));
                break;
            case R.id.about:
                break;
            case R.id.gitHub:
                startActivity(new Intent(getContext(), GithubWebActivity.class));
                break;
            case R.id.back:
                break;
        }
    }

}
