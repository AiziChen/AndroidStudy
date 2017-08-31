package com.cnsunrun.androidstudy.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 二维码的扫描
 */
public class ZXingTwoActivity extends SwipeBackActivity implements DecoratedBarcodeView.TorchListener {

    @BindView(R.id.tv_saomiao_code)
    TextView tvSaomiaoCode;
    @BindView(R.id.dbv_custom)
    DecoratedBarcodeView dbvCustom;
    private CaptureManager captureManager;
    private boolean isLightOn = false;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_zxing_two);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        initTitle("二维码的扫描");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        // 如果没有闪光灯功能，就去掉相关按钮
        if (!hasFlash()) {
            tvSaomiaoCode.setVisibility(View.GONE);
        }
        //重要代码，初始化捕获
        captureManager = new CaptureManager(this, dbvCustom);
        captureManager.initializeFromIntent(getIntent(), savedInstanceState);
        captureManager.decode();

        dbvCustom.setTorchListener(this);

    }

    @Override
    protected void setListener() {

    }

    // 判断是否有闪光灯功能
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    @OnClick(R.id.tv_saomiao_code)
    public void onViewClicked() {
        if (isLightOn) {
            dbvCustom.setTorchOff();
        } else {
            dbvCustom.setTorchOn();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        captureManager.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return dbvCustom.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    public void onTorchOn() {
        Toast.makeText(this, "torch on", Toast.LENGTH_LONG).show();
        isLightOn = true;
    }

    @Override
    public void onTorchOff() {
        Toast.makeText(this, "torch off", Toast.LENGTH_LONG).show();
        isLightOn = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

}
