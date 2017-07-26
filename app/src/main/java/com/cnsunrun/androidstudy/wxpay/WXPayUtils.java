package com.cnsunrun.androidstudy.wxpay;

import android.app.Activity;
import android.content.Context;

import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

/**
 * Created by ZhouBin on 2017/7/26.
 * Effect:  微信支付的工具类
 */

public class WXPayUtils {
    /**
     * 微信支付 APP_ID
     */
    public static final String APP_ID = ConstantValue.WX_APP_ID;

    /**
     * 微信支付 商户号
     */
    public static final String MCH_ID = ConstantValue.PARTNER_ID;
    /**
     * 微信支付 API密钥
     */
    public static final String API_KEY = ConstantValue.API_KEY;


    private WeakReference<Activity> mActivity;
    private IWXAPI msgApi;
    private PayReq payReq;

    public WXPayUtils(Activity activity) {
        mActivity = new WeakReference<Activity>(activity);
        msgApi = WXAPIFactory.createWXAPI(activity, null);
        msgApi.registerApp(APP_ID);
        payReq = new PayReq();
    }


    /**
     * 生成随机字符串
     *
     * @return
     */
    private String genNonceStr() {
        Random random = new Random();
        return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
    }

    /**
     * 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    private String getWXOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);
        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }
}
