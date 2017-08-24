package com.cnsunrun.androidstudy.wxpay;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;

import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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


    private Activity context;
    PayReq req;
    IWXAPI msgApi;
    StringBuffer sb;
    Map<String, String> resultunifiedorder;
    //    private String notify_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private String notify_url = "https://pay.weixin.qq.com/index.php/core/info";
    private String orderTitle = "";//ceshi
    private String orderPrice = "";//总金额
    private String outTradeNo = "";//商户订单号
    private String describe = "";//

    public String shopName;//店铺名称
    public String title;//商品名称
    public String price;//商品价格


    public WXPayUtils(Activity context, String notify_url) {
        this.context = context;
        this.notify_url = notify_url;
        req = new PayReq();
        sb = new StringBuffer();
        registerAPP();
    }

    public void registerAPP() {
        msgApi = WXAPIFactory.createWXAPI(context, APP_ID, true);
        msgApi.registerApp(APP_ID);
    }

    public void pay(String orderTitle, String orderPrice, String describe, String orderNum) {
        this.orderTitle = orderTitle;
        this.orderPrice = orderPrice;
        this.outTradeNo = orderNum;
        this.describe = describe;
        GetPrepayIdTask getPrepayId = new GetPrepayIdTask();
        getPrepayId.execute();
    }

    private long genTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    private void genPayReq() {

        String returnCode = resultunifiedorder.get("return_code");
        if ("FAIL".equals(returnCode)) {
            Toast.makeText(context, resultunifiedorder.get("return_msg"), Toast.LENGTH_SHORT).show();
        }
        req.appId = APP_ID;
        req.partnerId = MCH_ID;
        req.prepayId = resultunifiedorder.get("prepay_id");
        req.packageValue = "Sign=WXPay";
        req.nonceStr = genNonceStr();
        req.timeStamp = String.valueOf(genTimeStamp());

        List<NameValuePair> signParams = new LinkedList<NameValuePair>();
        signParams.add(new BasicNameValuePair("appid", req.appId));//api_id
        signParams.add(new BasicNameValuePair("noncestr", req.nonceStr));
        signParams.add(new BasicNameValuePair("package", req.packageValue));
        signParams.add(new BasicNameValuePair("partnerid", req.partnerId));
        signParams.add(new BasicNameValuePair("prepayid", req.prepayId));
        signParams.add(new BasicNameValuePair("timestamp", req.timeStamp));

        req.sign = genAppSign(signParams);

        sb.append("sign\n" + req.sign + "\n\n");
    }

    private String genAppSign(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < params.size(); i++) {
            sb.append(params.get(i).getName());
            sb.append('=');
            sb.append(params.get(i).getValue());
            sb.append('&');
        }
        sb.append("key=");
        sb.append(API_KEY);

        this.sb.append("sign str\n" + sb.toString() + "\n\n");
        String appSign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
        Log.e("TAG", appSign);
        return appSign;
    }

    private void sendPayReq() {

        msgApi.registerApp(APP_ID);
        msgApi.sendReq(req);
        Log.e("TAG", "sendPayReq111: " + msgApi.sendReq(req));
    }

    /**
     * 生成签名
     */

    private String genPackageSign(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < params.size(); i++) {
            sb.append(params.get(i).getName());
            sb.append('=');
            sb.append(params.get(i).getValue());
            sb.append('&');
        }
        sb.append("key=");
        sb.append(API_KEY);


        String packageSign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
        return packageSign;
    }


    private class GetPrepayIdTask extends AsyncTask<Void, Void, Map<String, String>> {

        private ProgressDialog dialog;


        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(context, "提示", "正在获取预支付订单...");
        }

        @Override
        protected void onPostExecute(Map<String, String> result) {
            if (dialog != null) {
                dialog.dismiss();
            }
            sb.append("prepay_id\n" + result.get("prepay_id") + "\n\n");

            if (result.get("err_code") != null && "OUT_TRADE_NO_USED".equals(result.get("err_code").toString())) {
                Toast.makeText(context, result.get("err_code_des").toString(), Toast.LENGTH_LONG).show();
            }
            resultunifiedorder = result;
            Log.e(getClass().getName(), resultunifiedorder.toString());
            Log.e("TAG", resultunifiedorder.toString());
            genPayReq();
            sendPayReq();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Map<String, String> doInBackground(Void... params) {

            String url = String.format("https://api.mch.weixin.qq.com/pay/unifiedorder");
            String entity = genProductArgs();


            byte[] buf = Util.httpPost(url, entity);

            String content = new String(buf);
            Map<String, String> xml = decodeXml(content);
            Log.e("TAG", "doInBackground: " + xml.toString());
            Log.e("TAG", "doInBackground: " + content);
            return xml;
        }
    }

    public Map<String, String> decodeXml(String content) {

        try {
            Map<String, String> xml = new HashMap<String, String>();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new StringReader(content));
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                String nodeName = parser.getName();
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:

                        if ("xml".equals(nodeName) == false) {
                            //实例化student对象
                            xml.put(nodeName, parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                event = parser.next();
            }
            return xml;
        } catch (Exception e) {
        }
        return null;

    }

    private String genProductArgs() {
        StringBuffer xml = new StringBuffer();

        try {
            String nonceStr = genNonceStr();
            xml.append("</xml>");
            List<NameValuePair> packageParams = new LinkedList<NameValuePair>();
            packageParams.add(new BasicNameValuePair("appid", APP_ID));//api_id
            packageParams.add(new BasicNameValuePair("bank_type", "WX")); // 固定为“WX”
//            packageParams.add(new BasicNameValuePair("appkey", WXConstants.WECHAT_API_KEY));
            packageParams.add(new BasicNameValuePair("body", orderTitle));//orderTitle没有数据  为空  测试    + "¥" + orderPrice
//            packageParams.add(new BasicNameValuePair("body", orderTitle));//orderTitle没有数据  为空  测试    + "¥" + orderPrice
//            packageParams.add(new BasicNameValuePair("fee_type", "1"));// 传入参数字符编码：默认GBK
            packageParams.add(new BasicNameValuePair("detail", describe));//商品介绍
            packageParams.add(new BasicNameValuePair("input_charset", "UTF-8"));// 通知URL,支付完成后，接收微信通知结果的URL,需要绝对路径,
            packageParams.add(new BasicNameValuePair("mch_id", MCH_ID));
            packageParams.add(new BasicNameValuePair("nonce_str", nonceStr));
            packageParams.add(new BasicNameValuePair("notify_url", notify_url));
            packageParams.add(new BasicNameValuePair("out_trade_no", outTradeNo));//商户订单号
            packageParams.add(new BasicNameValuePair("spbill_create_ip", getLocalIpAddress(context)));//获取手机的ip地址
            packageParams.add(new BasicNameValuePair("total_fee", String.valueOf((int) (Float.parseFloat(orderPrice) * 100))));// 订单总金额，单位是分
            packageParams.add(new BasicNameValuePair("trade_type", "APP"));
            String sign = genPackageSign(packageParams);
            packageParams.add(new BasicNameValuePair("sign", sign));
            String xmlstring = toXml(packageParams);
            Log.e("TAG", "genProductArgs: " + xmlstring);

            return xmlstring;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析为xml格式
     *
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    private String toXml(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (int i = 0; i < params.size(); i++) {
            sb.append("<" + params.get(i).getName() + ">");
            sb.append(params.get(i).getValue());
            sb.append("</" + params.get(i).getName() + ">");
        }
        sb.append("</xml>");

        //return sb.toString();
        return new String(sb.toString().getBytes(), "ISO8859-1");
    }

    private String genNonceStr() {
        Random random = new Random();
        return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
    }

    /**
     * @param ipInt
     * @return
     */
    public static String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    /**
     * 获取手机的IP
     *
     * @param context
     * @return
     */
    public static String getLocalIpAddress(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int i = wifiInfo.getIpAddress();
            return int2ip(i);
        } catch (Exception ex) {
            return " 获取IP出错鸟!!!!请保证是WIFI,或者请重新打开网络!\n" + ex.getMessage();
        }
    }


}
