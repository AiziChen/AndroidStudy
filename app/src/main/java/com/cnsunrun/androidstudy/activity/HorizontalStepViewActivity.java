package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.anton46.stepsview.StepsView;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalStepViewActivity extends BaseActivity {

    @BindView(R.id.stepsView)
    StepsView stepsView;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_horizontal_step_view);
        ButterKnife.bind(this);


    }

    @Override
    protected void bindViews() {
        initTitle("水平进度步骤");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String[] steps = {"刘德华", "周星驰", "成龙", "张曼玉", "林青霞"};

        stepsView.setLabels(steps)
                .setBarColorIndicator(mContext.getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(mContext.getResources().getColor(R.color.orange))
                .setLabelColorIndicator(mContext.getResources().getColor(R.color.orange))
                .setCompletedPosition(3)
                .drawView();
    }

    @Override
    protected void setListener() {

    }
}
