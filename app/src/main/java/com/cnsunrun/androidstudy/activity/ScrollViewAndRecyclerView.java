package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.utils.AlerDialogUtils;
import com.cnsunrun.androidstudy.utils.InputKeyBoardUtil;
import com.cnsunrun.androidstudy.view.PasswordEditText;
import com.cnsunrun.androidstudy.view.PayPsdInputView;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 输入密码框
 */
public class ScrollViewAndRecyclerView extends BaseActivity {


    @BindView(R.id.password_edit_text)
    PasswordEditText passwordEditText;
    @BindView(R.id.pay_psd_input_view)
    PayPsdInputView payPsdInputView;
    @BindView(R.id.tv_type_one)
    TextView tvTypeOne;
    @BindView(R.id.tv_type_two)
    TextView tvTypeTwo;
    @BindView(R.id.tv_type_three)
    TextView tvTypeThree;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_scroll_view_and_recycler_view);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("密码输入框");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {


    }

    @Override
    protected void setListener() {

        passwordEditText.setOnPasswordFullListener(new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                ToastUtils.showToast("密码是:" + password);
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            InputKeyBoardUtil.hideCloseKeyboard(v, ev, this);
        }
        return super.dispatchTouchEvent(ev);
    }


    @OnClick({R.id.tv_type_one, R.id.tv_type_two, R.id.tv_type_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_type_one:
                showTypeOne();
                break;
            case R.id.tv_type_two:
                showTypeTwo(view);
                break;
            case R.id.tv_type_three:
                showTypeThree(view);
                break;
        }
    }

    private void showTypeThree(View view) {

        AlerDialogUtils.passwordEditDialog(mContext, new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                ToastUtils.showToast("密码是:" + password);
            }
        });

    }

    private void showTypeTwo(View view) {

        AlerDialogUtils.passwordDialog(mContext, new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                ToastUtils.showToast("密码是:" + password);
            }
        });
    }

    private void showTypeOne() {

    }

}
