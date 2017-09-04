package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;

/**
 * 悬浮搜索栏
 */
public class SuspensionActivity extends SwipeBackActivity {

    private static final String TAG = "SuspensionActivity";

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_suspension);
    }

    @Override
    protected void bindViews() {
        initTitle("悬浮栏的练习");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String[] imageList = {
                "http://s1.cdn.xiachufang.com/957171ee064011e7947d0242ac110002_1280w_853h.jpg",
                "http://s2.cdn.xiachufang.com/c7d3fad4876611e6b87c0242ac110003_616w_800h.jpg",
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg",
                "http://s1.cdn.xiachufang.com/3df51d10892e11e6b87c0242ac110003_748w_662h.jpg",
                "http://s2.cdn.xiachufang.com/895d027820d611e7bc9d0242ac110002_1382w_1038h.jpg",
        };

    }

    @Override
    protected void setListener() {

    }

}