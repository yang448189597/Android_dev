package com.example.socre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.socre.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;
    public final static String KEY_ATEAM_SCORE = "a_team_score";
    public final static String KEY_BTEAM_SCORE = "b_team_score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        // 初始化viewModel
        myViewModel = ViewModelProviders.of(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);

    }

    // 当操作返回键的时候，APP的当前界面不应该被销毁，应该是返回主界面，网易云 qq 都是类似的操作习惯 从而数据也可以在其中处理保存，不会丢失
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
             Intent home = new Intent(Intent.ACTION_MAIN);
             home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             home.addCategory(Intent.CATEGORY_HOME);
             startActivity(home);
             return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
