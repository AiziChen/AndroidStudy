package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.utils.AreaCityDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 省市区选择
 */
public class CountDownActivity extends BaseActivity {


    @BindView(R.id.tv_select_city)
    TextView tvSelectCity;
    private String mProvince;
    private String mCity;
    private String mArea;

    private AreaCityDialog areaDialog;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("省市区选择");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }


    @OnClick(R.id.tv_select_city)
    public void onViewClicked() {
        showAreaDialog();
    }


    private void showAreaDialog() {
        if (areaDialog == null) {
            areaDialog = new AreaCityDialog(this);
            areaDialog.setOnSelectedAreaListener(new AreaCityDialog.OnSelectedAreaListener() {
                @Override
                public void onSelectedAreaSuccess(String[] code, String province, String city, String area) {
                    mProvince = province;
                    mCity = city;
                    mArea = area;
                    tvSelectCity.setText(code[1]);
                }
            });
        }
        areaDialog.show();
    }
}
