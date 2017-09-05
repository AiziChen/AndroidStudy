package com.cnsunrun.androidstudy.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.view.CircleProgressBarView;
import com.cnsunrun.androidstudy.view.WaveViewByBezier;
import com.cnsunrun.androidstudy.view.WaveViewBySinCos;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 贝塞尔曲线的练习
 */
public class MapActivity extends SwipeBackActivity {

    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_pause)
    TextView tvPause;
    @BindView(R.id.tv_stop)
    TextView tvStop;
    @BindView(R.id.wave_view_bezier)
    WaveViewByBezier waveViewBezier;
    @BindView(R.id.wave_view_besincos)
    WaveViewBySinCos waveViewBesincos;
    @BindView(R.id.circle_progressbar)
    CircleProgressBarView circleProgressbar;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void bindViews() {
        initTitle("贝塞尔曲线的练习");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {


        circleProgressbar.setProgressWithAnimation(60);

    }

    @Override
    protected void setListener() {
        circleProgressbar.setProgressListener(new CircleProgressBarView.ProgressListener() {
            @Override
            public void currentProgressListener(float currentProgress) {

            }
        });
    }

    /**
     * 开始
     */
    private void start() {
        waveViewBezier.startAnimation();
        waveViewBesincos.startAnimation();
        circleProgressbar.startProgressAnimation();


    }

    /**
     * 暂停
     */
    private void pause() {
        waveViewBezier.pauseAnimation();
        waveViewBesincos.pauseAnimation();
        circleProgressbar.pauseProgressAnimation();
    }

    /**
     * 停止
     */
    private void stop() {
        waveViewBezier.stopAnimation();
        waveViewBesincos.stopAnimation();
        circleProgressbar.stopProgressAnimation();
    }

    @OnClick({R.id.tv_start, R.id.tv_pause, R.id.tv_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start:
                start();
                break;
            case R.id.tv_pause:
                pause();
                break;
            case R.id.tv_stop:
                stop();
                break;
        }
    }
}
