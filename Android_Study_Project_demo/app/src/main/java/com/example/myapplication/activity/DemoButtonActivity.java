package com.example.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.common.BaseActivity;
import com.example.myapplication.common.ToolBarOptions;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * @Author: Luke
 * @Date: 2019-08-02 16:00
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class DemoButtonActivity extends BaseActivity {

    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.nice_spinner_1)
    NiceSpinner niceSpinner1;

    @BindView(R.id.nice_spinner_2)
    NiceSpinner niceSpinner2;


    private List<Map<String, Object>> data;
    private SimpleAdapter adapter;


    @Override
    protected void initView() {


        ToolBarOptions options = new ToolBarOptions();
        options.titleId = R.string.demo_button;
        setToolBar(R.id.toolbar, options);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.nim_actionbar_black_back_icon);
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.color_login_background));


        // 安卓 自带的 Spinner
        //1.添加一个下拉列表的数据源
        data = new ArrayList<>();
        getdata();
        //2.为下拉列表定义一个适配器
        adapter = new SimpleAdapter(this, data, R.layout.simple_list_item_1, new String[]{"image", "text"}, new int[]{R.id.image, R.id.textview});
        //3.为适配器设置下拉列表的样式
        adapter.setDropDownViewResource(R.layout.simple_list_item_1);
        //4.给下拉列表添加适配器
        spinner.setAdapter(adapter);

        spinner.setBackgroundResource(R.drawable.spinner_background_selector);
        //5.为下来列表设置各种响应事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText("您选择的是:" + adapter.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tv.setText("None");
            }
        });


        // nice-spinner

        List<String> dataset1 = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner1.attachDataSource(dataset1);
        niceSpinner1.setBackgroundResource(R.drawable.spinner_background_selector);
        niceSpinner1.setOnSpinnerItemSelectedListener((parent, view, position, id) -> {
            String item = (String) parent.getItemAtPosition(position);
            tv.setText("您选择的是:" + item);
        });


        List<String> dataset2 = new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5"));
        niceSpinner2.attachDataSource(dataset2);
        niceSpinner2.setBackgroundResource(R.drawable.spinner_background_selector);
        niceSpinner2.setOnSpinnerItemSelectedListener((parent, view, position, id) -> {
            String item = (String) parent.getItemAtPosition(position);
            tv.setText("您选择的是:" + item);
        });


    }

    private void getdata() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("imag", R.mipmap.ic_launcher);
        map1.put("text", "北京");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("imag", R.mipmap.ic_launcher);
        map2.put("text", "上海");
        Map<String, Object> map3 = new HashMap<>();
        map3.put("imag", R.mipmap.ic_launcher);
        map3.put("text", "深圳");
        Map<String, Object> map4 = new HashMap<>();
        map4.put("imag", R.mipmap.ic_launcher);
        map4.put("text", "广州");
        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
    }


    @Override
    protected void initData() {


    }

    @Override
    public int getContentViewResId() {
        return R.layout.demo_button_layout;
    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                break;
            case R.id.btn_2:
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                break;
            case R.id.btn_5:
                break;
            case R.id.btn_6:
                break;
        }
    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String cityName = data.get(i);
//        tv.setText("你选择的城市是：" + cityName);
//
//    }

//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}
