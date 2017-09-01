package com.cnsunrun.androidstudy.base;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.view.TitleBuilder;
import com.jaeger.library.StatusBarUtil;
import com.sunrun.toollibrary.LibActivity;

/**
 * Created by ZhouBin on 2017/8/1.
 * Effect: activity的基类
 */

public abstract class BaseActivity extends LibActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏颜色
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
        //设置状态栏半透明
//        StatusBarUtil.setTranslucent(this, 40);
        //设置状态栏全透明
        StatusBarUtil.setTransparent(this);
    }

    public TitleBuilder initTitle(Object obj) {
        if (obj instanceof String) {
            return new TitleBuilder(this).setTitleText((String) obj);
        } else {
            return new TitleBuilder(this).setTitleText((int) obj);
        }
    }

    public TitleBuilder initCustomTitle(Object obj) {
        return initTitle(obj).setLeftImage(R.drawable.back)
                .setTextColor(getResources().getColor(R.color.white))
                .setTitleBgColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
