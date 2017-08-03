package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amap.api.location.AMapLocation;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.alipay.AliPayUtils;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.LocationMapUtils;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AliPayActivity extends SwipeBackActivity {


    @BindView(R.id.listView)
    ListView listView;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_ali_pay);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("对于控件操作的封装");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {



    }



}
