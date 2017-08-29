package com.cnsunrun.authorloginandshare.login;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.mob.MobApplication;
import com.mob.MobSDK;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;

import static android.R.attr.orientation;

public class LoginApi implements Callback {
    private static final int MSG_AUTH_CANCEL = 1;
    private static final int MSG_AUTH_ERROR = 2;
    private static final int MSG_AUTH_COMPLETE = 3;

    private OnLoginListener loginListener;
    private String platform;
    private Context context;
    private Handler handler;

    public LoginApi() {
        handler = new Handler(Looper.getMainLooper(), this);
    }

    /**
     * 设置类型
     *
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 设置监听
     *
     * @param login
     */
    public void setOnLoginListener(OnLoginListener login) {
        this.loginListener = login;
    }

    public void login(Context context) {
        this.context = context.getApplicationContext();
        if (platform == null) {
            return;
        }
        //初始化SDK
        if (!(context instanceof MobApplication)) {
            MobSDK.init(context.getApplicationContext());
        }
        Platform plat = ShareSDK.getPlatform(platform);
        if (plat == null) {
            return;
        }
        if (plat.isAuthValid()) {
            plat.removeAccount(true);
            return;
        }
        //使用SSO授权，通过客户单授权
        plat.SSOSetting(false);
        plat.setPlatformActionListener(new PlatformActionListener() {
            public void onComplete(Platform plat, int action, HashMap<String, Object> res) {
                if (action == Platform.ACTION_USER_INFOR) {  // 成功
                    Message msg = new Message();
                    msg.what = MSG_AUTH_COMPLETE;
                    msg.arg2 = action;
                    msg.obj = new Object[]{plat.getName(), res};
                    handler.sendMessage(msg);
                }
            }

            public void onError(Platform plat, int action, Throwable t) {
                if (action == Platform.ACTION_USER_INFOR) {  // 失败
                    Message msg = new Message();
                    msg.what = MSG_AUTH_ERROR;
                    msg.arg2 = action;
                    msg.obj = t;
                    handler.sendMessage(msg);
                }
                t.printStackTrace();
            }

            public void onCancel(Platform plat, int action) {
                if (action == Platform.ACTION_USER_INFOR) {   // 取消
                    Message msg = new Message();
                    msg.what = MSG_AUTH_CANCEL;
                    msg.arg2 = action;
                    msg.obj = plat;
                    handler.sendMessage(msg);
                }
            }
        });
        plat.showUser(null);
    }

    /**
     * 处理操作结果
     */
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_AUTH_CANCEL: {
                // 取消
                Toast.makeText(context, "canceled", Toast.LENGTH_SHORT).show();
                if (loginListener != null) {
                    loginListener.authorizeCancel();
                }
            }
            break;
            case MSG_AUTH_ERROR: {
                // 失败
                Throwable t = (Throwable) msg.obj;
                String text = "caught error: " + t.getMessage();
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                t.printStackTrace();
                if (loginListener != null) {
                    loginListener.getProfileError(text);
                }
            }
            break;
            case MSG_AUTH_COMPLETE: {
                // 成功
                Object[] objs = (Object[]) msg.obj;
                String plat = (String) objs[0];
                @SuppressWarnings("unchecked")
                HashMap<String, Object> res = (HashMap<String, Object>) objs[1];
                if (loginListener != null) {
                    loginListener.authorizeSuccess(plat, res);
                }
            }
            break;
        }
        return false;
    }

}
