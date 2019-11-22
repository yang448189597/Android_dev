package com.example.socre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

        useSharePreference();

        useMyData();

    }

    private void useMyData() {
//        getApplicationContext()可以理解为指向APP的顶级引用，一个全局的，单个的，
        // 不能传递this ,如果传递进去，Activity 消失，Mydata，还持有外部对象的引用，会导致资源浪费，无法回收
        MyData myData = new MyData(getApplicationContext());
        myData.number = 1111111;
        myData.save();
        int y = myData.load();
        String TAG = "mylog";
        Log.d(TAG,"useMyData: "+ y);
    }

    private void useSharePreference() {
        // 两种方式，第一种 getPreferences 以当前类名建一个文件夹存数据
//        SharedPreferences shp = getPreferences(Context.MODE_PRIVATE);

        // 第二种  getSharePreferences 传进去一个文件夹名字的参数
        SharedPreferences shp = getSharedPreferences("MY_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt("NUMBER",1111);
        editor.apply();

        // 第二个参数是缺省值，避免value里面没有值，所以给一个默认值
        int x = shp.getInt("NUMBER",0);
        String TAG = "mylog";
        Log.d(TAG,"onCreate: "+ x);


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
