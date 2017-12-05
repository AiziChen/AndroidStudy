package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.dialog_fragment.DialogFragmentHelper;
import com.cnsunrun.androidstudy.dialog_fragment.IDialogResultListener;
import com.githang.stepview.StepView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HorizontalStepViewActivity extends BaseActivity {


    @BindView(R.id.step_view)
    StepView stepView;
    @BindView(R.id.tv_tye_one)
    TextView tvTyeOne;
    @BindView(R.id.tv_type_two)
    TextView tvTypeTwo;
    @BindView(R.id.tv_type_three)
    TextView tvTypeThree;

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


    @OnClick({R.id.tv_tye_one, R.id.tv_type_two, R.id.tv_type_three})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tye_one:
                Calendar calendar = Calendar.getInstance();
                DialogFragmentHelper.showDateDialog(getSupportFragmentManager(), "选择时间", calendar, new IDialogResultListener<Calendar>() {
                    @Override
                    public void onDataResult(Calendar result) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dateStr = sdf.format(result.getTime());
                        showToast(dateStr);
                    }
                }, false);
                break;
            case R.id.tv_type_two:
                DialogFragmentHelper.showPasswordInsertDialog(getSupportFragmentManager(), "输入密码", new IDialogResultListener<String>() {
                    @Override
                    public void onDataResult(String result) {
                        showToast(result);
                    }
                }, true);
                break;
            case R.id.tv_type_three:
                Calendar calendarOne = Calendar.getInstance();
                DialogFragmentHelper.showTimeDialog(getSupportFragmentManager(), "选择时间", calendarOne, new IDialogResultListener<Calendar>() {
                    @Override
                    public void onDataResult(Calendar result) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dateStr = sdf.format(result.getTime());
                        showToast(dateStr);
                    }
                }, false);
                break;
        }
    }
}
