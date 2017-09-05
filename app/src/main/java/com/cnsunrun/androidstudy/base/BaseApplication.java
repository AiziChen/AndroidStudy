package com.cnsunrun.androidstudy.base;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.sunrun.toollibrary.LibApplication;
import com.sunrun.toollibrary.utils.FileUtils;


/**
 * Created by ZhouBin on 2017/6/7.
 * Effect:BaseApplication
 */

public class BaseApplication extends LibApplication {


    /**
     * SHA1:83:25:E8:0A:C4:29:BB:B1:00:67:13:22:9F:E6:C4:71:C2:8D:57:4F
     * MD5:
     */

    public static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        FileUtils.init("android");
        MultiDex.install(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public synchronized static BaseApplication getInstance() {
        return instance;

    }
}
