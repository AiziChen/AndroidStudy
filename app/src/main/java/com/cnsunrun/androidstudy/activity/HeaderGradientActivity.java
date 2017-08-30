package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.authorloginandshare.login.ShareAndLoginUtils;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
        initTitle("shareSDK的封装");
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
        ShareAndLoginUtils.authorLogin(mContext, ShareAndLoginUtils.WB_LOGIN, new ShareAndLoginUtils.ConfirmLoginListener() {
            @Override
            public void confirmLogin(String userToken, String UserId, String UserName, String UserIcon, String UserGender) {
                ToastUtils.showToast("登录成功");
            }

        });
    }

    /**
     * 微信登录
     */
    private void loginFormWeiXin() {
        ShareAndLoginUtils.authorLogin(mContext, ShareAndLoginUtils.WX_LOGIN, new ShareAndLoginUtils.ConfirmLoginListener() {
            @Override
            public void confirmLogin(String userToken, String UserId, String UserName, String UserIcon, String UserGender) {
                ToastUtils.showToast("登录成功");
            }

        });
    }

    /**
     * QQ登录
     */
    private void loginFormQQ() {

        ShareAndLoginUtils.authorLogin(mContext, ShareAndLoginUtils.QQ_LOGIN, new ShareAndLoginUtils.ConfirmLoginListener() {
            @Override
            public void confirmLogin(String userToken, String UserId, String UserName, String UserIcon, String UserGender) {
                ToastUtils.showToast("登录成功");
            }


        });
    }

    /**
     * 分享
     */
    private void showShareWindow() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不     调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(this);

    }
}
