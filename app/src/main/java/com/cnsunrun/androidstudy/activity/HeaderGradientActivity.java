package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.authorloginandshare.login.OnLoginListener;
import com.cnsunrun.authorloginandshare.login.ShareAndLoginUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * shareSDk封装
 */
public class HeaderGradientActivity extends SwipeBackActivity {

    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_login_qq)
    TextView tvLoginQq;
    @BindView(R.id.tv_login_weixin)
    TextView tvLoginWeixin;
    @BindView(R.id.tv_login_weibo)
    TextView tvLoginWeibo;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_header_gradient);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }


    @OnClick({R.id.tv_share, R.id.tv_login_qq, R.id.tv_login_weixin, R.id.tv_login_weibo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_share:
                showShareWindow();
                break;
            case R.id.tv_login_qq:
                loginFormQQ();
                break;
            case R.id.tv_login_weixin:
                loginFormWeiXin();
                break;
            case R.id.tv_login_weibo:
                loginFormWeiBo();
                break;
        }
    }

    /**
     * 微博登录
     */
    private void loginFormWeiBo() {
    }

    /**
     * 微信登录
     */
    private void loginFormWeiXin() {
    }

    /**
     * QQ登录
     */
    private void loginFormQQ() {
        ShareAndLoginUtils.authorLogin(mContext, "", new OnLoginListener() {
            @Override
            public void authorizeSuccess(String platform, HashMap<String, Object> res) {
            }

            @Override
            public void getProfileError(String info) {

            }

            @Override
            public void authorizeCancel() {

            }
        });
    }

    /**
     * 分享
     */
    private void showShareWindow() {
    }
}
