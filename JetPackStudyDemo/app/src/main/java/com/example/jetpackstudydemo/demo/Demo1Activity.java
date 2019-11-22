package com.example.jetpackstudydemo.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.jetpackstudydemo.R;
import com.example.jetpackstudydemo.databinding.ActivityDemo1Binding;

public class Demo1Activity extends AppCompatActivity {
    ViewModelDemo1 viewModelDemo1;
    ActivityDemo1Binding binding;

    // Demo1 使用AndroidViewModel 保存App的数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_demo1);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_demo1);
        viewModelDemo1 = ViewModelProviders.of(this,new SavedStateViewModelFactory(getApplication(),this)).get(ViewModelDemo1.class);
        binding.setDemo1data(viewModelDemo1);
        binding.setLifecycleOwner(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // 在onPause 放在这里比较可靠,如果放在onStop onDestory中有可能是调用不到
        viewModelDemo1.save();
    }
}
