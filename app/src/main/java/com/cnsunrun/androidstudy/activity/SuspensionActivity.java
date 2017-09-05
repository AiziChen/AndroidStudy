package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;

import com.allen.library.SuperTextView;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.view.RadarWaveView;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * superTextView的使用
 */
public class SuspensionActivity extends SwipeBackActivity {

    private static final String TAG = "SuspensionActivity";
    @BindView(R.id.super_tv_01)
    SuperTextView superTv01;
    @BindView(R.id.super_tv_02)
    SuperTextView superTv02;
    @BindView(R.id.super_tv_03)
    SuperTextView superTv03;
    @BindView(R.id.super_tv_04)
    SuperTextView superTv04;
    @BindView(R.id.radar_wave_view)
    RadarWaveView radarWaveView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_suspension);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        initTitle("superTextView的使用");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
    }

    @Override
    protected void setListener() {

    }

    @OnClick({R.id.super_tv_01, R.id.super_tv_02, R.id.super_tv_03, R.id.super_tv_04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.super_tv_01:
                ToastUtils.showToast("点击了01");
                break;
            case R.id.super_tv_02:
                ToastUtils.showToast("点击了02");
                break;
            case R.id.super_tv_03:
                ToastUtils.showToast("点击了03");
                break;
            case R.id.super_tv_04:
                ToastUtils.showToast("点击了04");
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        radarWaveView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        radarWaveView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        radarWaveView.stop();
    }
}