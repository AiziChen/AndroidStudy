package com.cnsunrun.androidstudy.base;

import android.app.Application;

import com.sunrun.toollibrary.LibApplication;
import com.sunrun.toollibrary.utils.FileUtils;


/**
 * Created by ZhouBin on 2017/6/7.
 * Effect:BaseApplication
 */

public class BaseApplication extends LibApplication {

    public static BaseApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        FileUtils.init("android");
    }


    public synchronized static BaseApplication getInstance() {
        return instance;

    }
}
