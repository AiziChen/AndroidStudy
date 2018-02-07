package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.widgtet.CircularStatisticsView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GesturesMonitorActivity extends BaseActivity {


    @BindView(R.id.csView)
    CircularStatisticsView csView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_gestures_monitor);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义控件");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        csView.setCircleWidth(30f);
        csView.setPercentage(40f,60f);


    }

    @Override
    protected void setListener() {


    }


}
