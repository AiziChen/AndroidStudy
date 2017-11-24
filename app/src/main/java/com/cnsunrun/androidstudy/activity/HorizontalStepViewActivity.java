package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.githang.stepview.StepView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalStepViewActivity extends BaseActivity {


    @BindView(R.id.step_view)
    StepView stepView;

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

        stepView.setSteps(Arrays.asList("张靓颖", "霉霉", "贾斯汀", "阿黛尔", "水果姐"));
        stepView.selectedStep(3);
    }

    @Override
    protected void setListener() {

    }
}
