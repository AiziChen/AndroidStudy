package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;

/**
 * 状态栏的问题
 */
public class StatusBarActivity extends SwipeBackActivity {


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_status_bar);
    }

    @Override
    protected void bindViews() {
        initTitle("状态栏的问题");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
