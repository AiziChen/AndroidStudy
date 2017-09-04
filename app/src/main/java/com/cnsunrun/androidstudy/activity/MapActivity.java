package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;

/**
 * 高德地图的实现
 */
public class MapActivity extends SwipeBackActivity {

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_map);

    }

    @Override
    protected void bindViews() {
        //获取地图控件引用
        initTitle("地图使用");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
    }

    @Override
    protected void setListener() {

    }


}
