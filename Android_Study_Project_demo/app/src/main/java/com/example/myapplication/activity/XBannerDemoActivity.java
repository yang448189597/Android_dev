package com.example.myapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.ImageBean;
import com.stx.xhb.androidx.XBanner;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 * @Author: Luke
 * @Date: 2019-08-19 17:03
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class XBannerDemoActivity extends AppCompatActivity {

    String TAG = "XBannerDemoActivity";
    List<ImageBean> imageBeanList = new ArrayList<>();
    @BindView(R.id.xBanner)
    XBanner xbanner;
    @BindView(R.id.image_test)
    ImageView imageTest;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xbanner_layout_activity);
        ButterKnife.bind(this);
        initData();
    }


    protected void initData() {
//        https://www.apiopen.top/meituApi?page=1
        String url = "https://api.apiopen.top/getImages";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String jsonString = response.body().string();
                Log.d(TAG, "onResponse: " + jsonString);


                JSONObject object = JSONObject.parseObject(jsonString);
                JSONArray result = object.getJSONArray("result");

                for (int i = 0; i < result.size(); i++) {
                    String childObjString = result.get(i).toString();
                    JSONObject childObj = JSONObject.parseObject(childObjString);
                    imageBeanList.add(new ImageBean(childObj.getString("id"), childObj.getString("time"), childObj.getString("img")));
                }
                Log.d(TAG, "imageBeanList: " + imageBeanList);


                mHandler.post(() -> {
                    xbanner.setAutoPlayAble(imageBeanList.size() > 1);
                    xbanner.loadImage((banner, model, view, position) -> {
                        Glide.with(XBannerDemoActivity.this).load(imageBeanList.get(position).getImgUrl()).into((ImageView) view);

                    });
                    xbanner.setBannerData(imageBeanList);

                    Glide.with(XBannerDemoActivity.this).load(imageBeanList.get(1).getImgUrl()).into((ImageView) imageTest);
                });

            }

        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        xbanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        xbanner.stopAutoPlay();
    }
}
