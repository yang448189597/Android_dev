package com.example.socre;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * @Author: Luke
 * @Date: 2019-11-22 11:36
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Socre
 */
public class MyData {
    private Context context;

    public MyData(Context context){
        this.context = context;
    }

    public int number;
    public void save(){
        String name = context.getResources().getString(R.string.DLY_DATA);
        SharedPreferences shp  = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        String key = context.getResources().getString(R.string.DLY_KEY);
        editor.putInt(key,number);
        editor.apply();
    }

    public int  load(){
        String name = context.getResources().getString(R.string.DLY_DATA);
        SharedPreferences shp  = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        String key = context.getResources().getString(R.string.DLY_KEY);

        int x = shp.getInt(key,context.getResources().getInteger(R.integer.defValue));
        number = x;
        return x;
    }
}
