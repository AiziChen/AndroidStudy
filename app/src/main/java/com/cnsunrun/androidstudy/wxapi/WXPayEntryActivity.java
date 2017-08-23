package com.cnsunrun.androidstudy.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.wxpay.WXPayUtils;
import com.sunrun.toollibrary.utils.ToastUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by ZhouBin on 2017/7/26.
 * Effect: 微信支付的回调类
 */

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI iwxapi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iwxapi = WXAPIFactory.createWXAPI(this, ConstantValue.WX_APP_ID);
        iwxapi.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        iwxapi.handleIntent(intent, this);
    }


    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            if (baseResp.errCode == 0) {
                ToastUtils.showToast("支付成功!");
            } else if (baseResp.errCode == -2) {
                ToastUtils.showToast("取消支付!");
            } else {
                ToastUtils.showToast("支付失败!");
            }
        }
        finish();


    }
}
