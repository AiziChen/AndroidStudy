package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.widgtet.RatingBar;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends SwipeBackActivity {

    @BindView(R.id.ratingBar01)
    RatingBar ratingBar01;
    @BindView(R.id.ratingBar02)
    RatingBar ratingBar02;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义RatingBar");


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        ratingBar02.setStar(4.5f);

    }

    @Override
    protected void setListener() {
        ratingBar01.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                ToastUtils.showToast("星数是:" + ratingCount);
            }
        });

    }
}
