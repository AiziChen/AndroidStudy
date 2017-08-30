package com.cnsunrun.androidstudy.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 二维码的生成和扫描
 */
public class ZXingActivity extends SwipeBackActivity {


    @BindView(R.id.tv_creat_ercode)
    TextView tvCreatErcode;
    @BindView(R.id.tv_saomiao_ercode)
    TextView tvSaomiaoErcode;
    @BindView(R.id.iv_ercode_image)
    ImageView ivErcodeImage;

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


    }

    //生成二维码
    private void creatErCode() {
        String textMes = "生成一个漂亮的二维码";
        Bitmap bitMap = encodeAsBitmap(textMes);
        ivErcodeImage.setImageBitmap(bitMap);

    }

    /**
     * 生成二维码
     *
     * @param str
     * @return
     */
    private Bitmap encodeAsBitmap(String str) {
        Bitmap bitmap = null;
        BitMatrix result = null;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            result = multiFormatWriter.encode(str, BarcodeFormat.QR_CODE, 200, 200);
            // 使用 ZXing Android Embedded 要写的代码
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae) {
            return null;
        }
        return bitmap;
    }

}
