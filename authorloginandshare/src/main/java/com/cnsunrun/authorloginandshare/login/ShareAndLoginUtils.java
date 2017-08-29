package com.cnsunrun.authorloginandshare.login;

import android.content.Context;

/**
 * Created by ZhouBin on 2017/8/29.
 * Effect:  分享和登录的帮助类
 */

public class ShareAndLoginUtils {

    public static ShareAndLoginUtils shareAndLoginUtils;

    public ShareAndLoginUtils() {
    }

    public synchronized static ShareAndLoginUtils getShareAndLoginUtils() {
        if (shareAndLoginUtils == null) {
            shareAndLoginUtils = new ShareAndLoginUtils();
        }
        return shareAndLoginUtils;
    }

    /**
     * 登录
     *
     * @param context         上下文
     * @param platform        登录类型
     * @param onLoginListener 监听回调
     */
    public static void authorLogin(Context context, String platform, OnLoginListener onLoginListener) {
        LoginApi loginApi = new LoginApi();
        loginApi.login(context);
        loginApi.setPlatform(platform);
        if (onLoginListener != null) {
            loginApi.setOnLoginListener(onLoginListener);
        }
    }

}
