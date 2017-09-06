package com.cnsunrun.androidstudy.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;


/**
 * 自定义BezierViewPager
 */
public class BezierViewPagerActivity extends SwipeBackActivity implements QRCodeView.Delegate {

    @BindView(R.id.zxingview)
    QRCodeView mQRCodeView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_bezier_view_pager);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("BGAQRCode_ZXing");
        mQRCodeView.setDelegate(this);
        mQRCodeView.startSpotAndShowRect();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        vibrate();
        mQRCodeView.startSpot();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
