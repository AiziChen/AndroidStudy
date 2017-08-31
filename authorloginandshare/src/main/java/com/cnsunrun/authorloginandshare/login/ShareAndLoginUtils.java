package com.cnsunrun.authorloginandshare.login;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;


/**
 * Created by ZhouBin on 2017/8/29.
 * Effect:  分享和登录的帮助类
 */

public class ShareAndLoginUtils {

    public static final String WX_LOGIN = "wx_login";
    public static final String QQ_LOGIN = "qq_login";
    public static final String WB_LOGIN = "wb_login";

    public static ShareAndLoginUtils shareAndLoginUtils;

    public ShareAndLoginUtils() {
    }

    public static synchronized ShareAndLoginUtils getShareAndLoginUtils() {
        if (shareAndLoginUtils == null) {
            shareAndLoginUtils = new ShareAndLoginUtils();
        }
        return shareAndLoginUtils;
    }

    /**
     * 获取授权并登录
     *
     * @param context              上下文
     * @param type                 类型
     * @param confirmLoginListener 登录的回调
     */
    public static void authorLogin(final Context context, String type, final ConfirmLoginListener confirmLoginListener) {
        LoginApi loginApi = new LoginApi();
        if (TextUtils.isEmpty(type)) return;
        if (type.equals(WX_LOGIN)) {  //微信
            loginApi.login(context, Wechat.NAME);
        } else if (type.endsWith(QQ_LOGIN)) { //QQ
            loginApi.login(context, QQ.NAME);
        } else if (type.equals(WB_LOGIN)) {   //微博
            loginApi.login(context, SinaWeibo.NAME);
        }
        loginApi.setOnLoginListener(new OnLoginListener() {
            @Override
            public void authorizeSuccess(Platform platform, PlatformDb platDB) {
                if (confirmLoginListener != null) {
                    confirmLoginListener.confirmLogin(platDB.getToken(), platDB.getUserId(), platDB.getUserName(), platDB.getUserIcon(), platDB.getUserGender());
                }
            }

            @Override
            public void getProfileError(String info) {
                Toast.makeText(context, "授权失败" + info, Toast.LENGTH_LONG).show();
            }
        });
    }

    public interface ConfirmLoginListener {
        void confirmLogin(String userToken, String UserId, String UserName, String UserIcon, String UserGender);
    }

    private ConfirmLoginListener confirmLoginListener;

    public void setConfirmLoginListener(ConfirmLoginListener confirmLoginListener) {
        this.confirmLoginListener = confirmLoginListener;
    }
}
