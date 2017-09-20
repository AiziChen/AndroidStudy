package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.AdvancedCountdownTimer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自定义倒计时控件
 */
public class CountDownActivity extends SwipeBackActivity {


    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_stop)
    TextView tvStop;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_stop_time)
    TextView tvStopTime;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义倒计时");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @OnClick({R.id.tv_start, R.id.tv_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start:
                startCountTime();

                break;
            case R.id.tv_stop:

                stopCountDown();
                break;
        }
    }

    AdvancedCountdownTimer timer;

    private void startCountTime() {

        timer = new AdvancedCountdownTimer(900000, 60000) {
            @Override
            public void onTick(long millisUntilFinished, int percent) {
                tvStartTime.setText("还剩" + millisUntilFinished / 60000 + "分钟");
            }

            @Override
            public void onFinish() {
                tvStartTime.setText("倒计时结束");
            }
        };
        timer.start();


    }

    private void stopCountDown() {
        countDownTimer.start();

    }


    private CountDownTimer countDownTimer = new CountDownTimer(900000, 60000) {
        @Override
        public void onTick(long millisUntilFinished) {
            tvStopTime.setText("还剩" + millisUntilFinished / 60000 + "分钟");
        }

        @Override
        public void onFinish() {
            tvStopTime.setText("倒计时结束");
        }
    };


}
