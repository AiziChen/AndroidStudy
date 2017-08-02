package com.cnsunrun.androidstudy.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.view.PasswordEditText;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect: 密码输入的dialog
 */

public class PasswordDialog extends Dialog {
    private Window window;
    private Display display;
    private TextView tvTitle;
    private PasswordEditText passwordEdit;

    public PasswordDialog(Context context) {
        super(context);
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        initViews(context);
    }

    //初始化控件
    private void initViews(Context context) {
        View passwordView = View.inflate(context, R.layout.include_password_dialog, null);
        tvTitle = (TextView) passwordView.findViewById(R.id.tv_title);
        passwordEdit = (PasswordEditText) passwordView.findViewById(R.id.password_edit_text);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(passwordView);
        window = getWindow();
        window.setWindowAnimations(android.R.style.Animation_InputMethod);
        window.getDecorView().setBackgroundResource(android.R.color.transparent);
        setWidth((int) (display.getWidth() * 0.9));
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
    }

    /**
     * 设置宽度
     *
     * @param width
     * @return
     */
    private PasswordDialog setWidth(int width) {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = width;
        window.setAttributes(lp);
        return this;

    }

    /**
     * 输入框监听回调
     *
     * @param passwordFullListener
     */
    public void setPasswordClickListeners(PasswordEditText.PasswordFullListener passwordFullListener) {
        passwordEdit.setOnPasswordFullListener(passwordFullListener);
    }

}
