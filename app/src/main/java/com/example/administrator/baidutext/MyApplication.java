package com.example.administrator.baidutext;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Administrator on 2017/1/16.
 */

public class MyApplication extends Application {
    private  static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();

    }
    public static  Context getContext(){
        return context;
    }
}
