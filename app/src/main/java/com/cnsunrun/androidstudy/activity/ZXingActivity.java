package com.cnsunrun.androidstudy.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.QRCodeUtils;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.sunrun.toollibrary.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

/**
 * 二维码的生成
 */
public class ZXingActivity extends SwipeBackActivity {


    @BindView(R.id.tv_creat_ercode)
    TextView tvCreatErcode;
    @BindView(R.id.tv_saomiao_ercode)
    TextView tvSaomiaoErcode;
    @BindView(R.id.tv_ercode_mess)
    TextView tvErcodeMessage;
    @BindView(R.id.iv_ercode_image)
    ImageView ivErcodeImage;

    private int type = 1;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_zxing);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("二维码的生成和扫描");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        creatErCode();
    }

    @Override
    protected void setListener() {

    }


    @OnClick({R.id.tv_creat_ercode, R.id.tv_saomiao_ercode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_creat_ercode:
                //生成二维码
                creatErCode();
                break;
            case R.id.tv_saomiao_ercode:
                //扫描二维码
                saoMiaoErCode();
                break;
        }
    }

    //扫描二维码
    private void saoMiaoErCode() {
        new IntentIntegrator(this)
                .setOrientationLocked(false)
                .setCaptureActivity(ZXingTwoActivity.class) // 设置自定义的activity是CustomActivity
                .initiateScan(); // 初始化扫描
    }

    //生成二维码
    private void creatErCode() {
        if (type == 1) {
            Bitmap bitmap = QRCodeUtils.createQRCodeWithLogo(getString(R.string.er_code_mes),
                    BitmapFactory.decodeResource(getResources(), R.drawable.ic_def_head));
            ivErcodeImage.setImageBitmap(bitmap);
            type = 2;
        } else if (type == 2) {
            String textMes = "Happy birthday, my dear!Although not always accompany in your side, but can't I moments of one's affection for you. You are a good girl, is worth me to care, although I couldn't say a special moving down to coax you happy, but I will use my practical action to prove my love for you!";
            Bitmap bitmap = QRCodeUtils.createQRCode(textMes);
            ivErcodeImage.setImageBitmap(bitmap);
            type = 3;
        } else {
            String mess = getString(R.string.er_code_mes);
            Bitmap bitmap = QRCodeEncoder.syncEncodeQRCode(mess, CommonUtil.dip2px(mContext, 150), getResources().getColor(R.color.black), BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_def_head));
            ivErcodeImage.setImageBitmap(bitmap);
            type = 1;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "内容为空", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "扫描成功", Toast.LENGTH_LONG).show();
                String ScanResult = intentResult.getContents();
                tvErcodeMessage.setText(ScanResult);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
