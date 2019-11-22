package com.example.jetpackstudydemo.demo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.jetpackstudydemo.R;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/*
 * @Author: Luke
 * @Date: 2019-11-22 15:38
 * @Sign: Cherish life and keep away from bugs!
 * @Project: JetPackStudyDemo
 */
@SuppressWarnings("ConstantConditions")
// 如果出现警告，在确保当前问题不会出现的情况下可以选择以上方式在当前类中忽略该警告
public class ViewModelDemo1 extends AndroidViewModel {

    // 或者 定义一个 Context context （application  是继承 context ）
    // context 顶级类
    // Application application; /Context context;
    //
    //    void foo (){
    //        context.getSharedPreferences("aaa",Context.MODE_PRIVATE);
    //    }
    //  这是第一种方式 继承ViewModel 然后通过以上方式也可以实现数据的全局存储

    // 第二种方式 直接继承 AndroidViewModel
    private SavedStateHandle handle;
    private String key = getApplication().getResources().getString(R.string.demo_1_key);
    private String shpName = getApplication().getResources().getString(R.string.demo_1_shp_name);

    public ViewModelDemo1(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)) {
            load();
        }

    }

    // public private protected
    // public 全局可见 公开化 private 只在当前类中使用可见 proteced 当前类和自己的子类
    // 如果不加修饰词的话，默认作用域是是在当前的package

    public LiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = shp.getInt(key, 0);
        handle.set(key, x);
    }

    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key, getNumber().getValue() == null ? 0 :getNumber().getValue());
        editor.apply();
    }

    public void add(int x) {
        handle.set(key, getNumber().getValue() + x);
        // 如果放在这里保存 是比较消耗时间 是个耗时操作 不建议
//        save();
    }
}
