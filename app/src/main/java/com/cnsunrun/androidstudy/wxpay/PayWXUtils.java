package com.cnsunrun.androidstudy.wxpay;

import android.app.Activity;
import android.util.Log;

import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.sunrun.toollibrary.utils.ToastUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONObject;

/**
 * Created by ZhouBin on 2017/8/24.
 * Effect:  微信支付的工具类
 */

public class PayWXUtils {

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


    private Activity mContext;
    private IWXAPI msgApi;
    private PayReq payReq;

    public PayWXUtils(Activity context) {
        mContext = context;
        msgApi = WXAPIFactory.createWXAPI(context, null);
        msgApi.registerApp(APP_ID);
        payReq = new PayReq();
    }


    public void wXPay(String urlCallBack) {
        try {
            byte[] buf = Util.httpGet(urlCallBack);
            if (buf != null && buf.length > 0) {
                String content = new String(buf);
                Log.e("get server pay params:", content);
                JSONObject json = new JSONObject(content);
                if (null != json && !json.has("retcode")) {
                    PayReq req = new PayReq();
                    //req.appId = "wxf8b4f85f3a794e77";  // 测试用appId
                    req.appId = json.getString("appid");
                    req.partnerId = json.getString("partnerid");
                    req.prepayId = json.getString("prepayid");
                    req.nonceStr = json.getString("noncestr");
                    req.timeStamp = json.getString("timestamp");
                    req.packageValue = json.getString("package");
                    req.sign = json.getString("sign");
                    req.extData = "app data"; // optional
                    ToastUtils.showToast("正常调起支付");
                    // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
                    msgApi.sendReq(req);
                } else {
                    Log.d("PAY_GET", "返回错误" + json.getString("retmsg"));
                    ToastUtils.showToast("返回错误" + json.getString("retmsg"));
                }
            } else {
                Log.d("PAY_GET", "服务器请求错误");
                ToastUtils.showToast("服务器请求错误");
            }
        } catch (Exception e) {
            Log.e("PAY_GET", "异常：" + e.getMessage());
            ToastUtils.showToast("异常：" + e.getMessage());
        }

    }

}
