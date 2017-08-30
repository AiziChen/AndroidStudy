package com.cnsunrun.authorloginandshare.login;

import android.content.Context;
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
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;

public class LoginApi implements Callback {
    private static final int MSG_AUTH_CANCEL = 1;
    private static final int MSG_AUTH_ERROR = 2;
    private static final int MSG_AUTH_COMPLETE = 3;

    private OnLoginListener loginListener;
    private Context context;
    private Handler handler;

    public LoginApi() {
        handler = new Handler(Looper.getMainLooper(), this);
    }

    /**
     * 设置监听
     *
     * @param login
     */
    public void setOnLoginListener(OnLoginListener login) {
        this.loginListener = login;
    }

    /**
     * 登录授权
     *
     * @param context  上下文
     * @param platform 类型
     */
    public void login(Context context, String platform) {
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
                    msg.obj = new Object[]{plat, res};
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
                Toast.makeText(context, "登录取消", Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_AUTH_ERROR: {
                // 失败
                Throwable t = (Throwable) msg.obj;
                String text = "error: " + t.getMessage();
                t.printStackTrace();
                if (loginListener != null) {
                    loginListener.getProfileError(text);
                }
            }
            break;
            case MSG_AUTH_COMPLETE: { // 成功
                Object[] objs = (Object[]) msg.obj;
                Platform plat = (Platform) objs[0];
                @SuppressWarnings("unchecked")
                HashMap<String, Object> res = (HashMap<String, Object>) objs[1];
                if (plat.isAuthValid()) {// 判断授权是否有效
                    PlatformDb platDB = plat.getDb();// 获取数平台数据DB
                    if (loginListener != null) {
                        loginListener.authorizeSuccess(plat, platDB);

                    }
                }

            }
            break;
        }
        return false;
    }

}
