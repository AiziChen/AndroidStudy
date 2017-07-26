package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.alipay.AliPayUtils;
import com.cnsunrun.androidstudy.wxpay.WXPayUtils;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AliPayActivity extends AppCompatActivity {

    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_alipay)
    TextView tvAlipay;
    @BindView(R.id.tv_wxpay)
    TextView tvWxpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali_pay);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        tvTitle.setText("对于支付的封装");

    }

    @OnClick({R.id.iv_arrow_back, R.id.tv_alipay, R.id.tv_wxpay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_arrow_back:
                finish();
                break;
            case R.id.tv_alipay:
                toSendAliPay();
                break;
            case R.id.tv_wxpay:
                toSendWxPay();
                break;
        }
    }

    /**
     * 支付宝支付
     */
    private void toSendAliPay() {

        String orderTitle = "测试支付宝";
        String orderNumber = "2017072656974848";
        String totalPrice = "0.01";
        String callUrl = "http://test.cnsunrun.com/shunshou//Api/Pay/Callback/ali_callback";

        AliPayUtils alipay = new AliPayUtils(AliPayActivity.this);

        alipay.requestPay(orderTitle, orderNumber, totalPrice, callUrl);

        alipay.setPayListener(new AliPayUtils.OnAlipayListener() {
            @Override
            public void onSuccess() {
                super.onSuccess();
                ToastUtils.showToast("支付成功!");
            }

            @Override
            public void onCancel() {
                super.onCancel();
                ToastUtils.showToast("取消支付!");
            }
        });
    }

    /**
     * 微信支付
     */
    private void toSendWxPay() {


        WXPayUtils wxPayUtils = new WXPayUtils(AliPayActivity.this);


    }


}
