package com.example.socre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.socre.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);

    }
}
