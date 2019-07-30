package com.example.myapplication.fragment.home_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.TestBean;
import com.example.myapplication.view.LabelView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * @Author: Luke
 * @Date: 2019-07-29 20:58
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */
public class LabelViewDemoFragment extends Fragment {


    @BindView(R.id.btn_none)
    Button btn_None;
    @BindView(R.id.btn_single)
    Button btn_Single;
    @BindView(R.id.btn_single_irrevocably)
    Button btn_SingleIrrevocably;
    @BindView(R.id.btn_multi)
    Button btn_Multi;
    @BindView(R.id.btn_multi_5)
    Button btn_Multi_5;
    @BindView(R.id.btn_multi_1)
    Button btnMulti1;
    @BindView(R.id.btn_multi_compulsory)
    Button btnMultiCompulsory;
    @BindView(R.id.btn_indicator)
    Button btnIndicator;
    @BindView(R.id.btn_un_select)
    Button btnUnSelect;
    @BindView(R.id.btn_click)
    Button btnClick;
    @BindView(R.id.labels)
    LabelView labels;
    @BindView(R.id.home_fragment_layout)
    LinearLayout homeFragmentLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View mView = inflater.inflate(R.layout.home_label_fragment_layout, null);
        ButterKnife.bind(this, mView);


        ArrayList<TestBean> testList = new ArrayList<>();
        testList.add(new TestBean("Android", 1));
        testList.add(new TestBean("IOS", 2));
        testList.add(new TestBean("前端", 3));
        testList.add(new TestBean("后台", 4));
        testList.add(new TestBean("微信开发", 5));
        testList.add(new TestBean("游戏开发", 6));
        testList.add(new TestBean("Java", 7));
        testList.add(new TestBean("JavaScript", 8));
        testList.add(new TestBean("C++", 9));
        testList.add(new TestBean("PHP", 10));
        testList.add(new TestBean("Python", 11));
        testList.add(new TestBean("Swift", 12));
        testList.add(new TestBean("Dart", 13));
        testList.add(new TestBean("Flutter", 14));
        testList.add(new TestBean("Vue", 15));
        testList.add(new TestBean("React Native", 16));
        labels.setLabels(testList, new LabelView.LabelTextProvider<TestBean>() {
            @Override
            public CharSequence getLabelText (TextView label, int position, TestBean data){
                return data.getName();
            }
        });

        // 设置最大显示行数，小于等于0则不限行数。
//        labelsView.setMaxLines(1);

        labels.clearAllSelect();
        return mView;
    }

    @OnClick({R.id.btn_none, R.id.btn_single, R.id.btn_single_irrevocably, R.id.btn_multi, R.id.btn_multi_5, R.id.btn_multi_1, R.id.btn_multi_compulsory, R.id.btn_indicator, R.id.btn_un_select, R.id.btn_click})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_none:
                labels.setSelectType(LabelView.SelectType.NONE);
                break;

            case R.id.btn_single:
                labels.setSelectType(LabelView.SelectType.SINGLE);
                break;

            case R.id.btn_single_irrevocably:
                labels.setSelectType(LabelView.SelectType.SINGLE_IRREVOCABLY);
                break;

            case R.id.btn_multi:
                labels.setSelectType(LabelView.SelectType.MULTI);
                labels.setMaxSelect(0);
                labels.setMinSelect(0);
                break;

            case R.id.btn_multi_5:
                labels.setSelectType(LabelView.SelectType.MULTI);
                labels.setMaxSelect(5);
                labels.setMinSelect(0);
                break;

            case R.id.btn_multi_1:
                labels.setSelectType(LabelView.SelectType.MULTI);
                labels.setMaxSelect(0);
                labels.setMinSelect(1);
                break;

            case R.id.btn_multi_compulsory:
                labels.setSelectType(LabelView.SelectType.MULTI);
                labels.setMaxSelect(0);
                labels.setMinSelect(0);
                labels.setCompulsorys(0, 1);
                break;

            case R.id.btn_indicator:

                labels.setIndicator(!labels.isIndicator());
                if (labels.isIndicator()) {
                    ((TextView) view).setText("取消指示器模式");
                } else {
                    ((TextView) view).setText("指示器模式");
                }
                break;

            case R.id.btn_un_select:
                labels.clearAllSelect();
                break;

            case R.id.btn_click:
                labels.setSelectType(LabelView.SelectType.NONE);
                labels.setOnLabelClickListener(new LabelView.OnLabelClickListener() {
                    @Override
                    public void onLabelClick(TextView label, Object data, int position) {
                        Toast.makeText(getActivity(), position + " : " + data,
                                Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }
}
