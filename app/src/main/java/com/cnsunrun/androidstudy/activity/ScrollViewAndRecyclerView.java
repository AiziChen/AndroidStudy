package com.cnsunrun.androidstudy.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.AlerDialogUtils;
import com.cnsunrun.androidstudy.utils.InputKeyBoardUtil;
import com.cnsunrun.androidstudy.view.PasswordEditText;
import com.cnsunrun.androidstudy.view.gridpasswordview.GridPasswordView;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 输入密码框
 */
public class ScrollViewAndRecyclerView extends SwipeBackActivity {


    @BindView(R.id.pwd_layout)
    GridPasswordView pwdLayout;
    @BindView(R.id.password_edit_text)
    PasswordEditText passwordEditText;
    @BindView(R.id.tv_type_one)
    TextView tvTypeOne;
    @BindView(R.id.tv_type_two)
    TextView tvTypeTwo;
    @BindView(R.id.tv_type_three)
    TextView tvTypeThree;

    AlertDialog passwordDialog;

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
        String password = pwdLayout.getPassWord();


    }

    @Override
    protected void setListener() {
        pwdLayout.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onTextChanged(String psw) {

            }

            @Override
            public void onInputFinish(String psw) {
                ToastUtils.showToast("密码是:" + psw);

            }
        });

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
        View passwordView = View.inflate(mContext, R.layout.include_password_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(passwordView);
        final TextView tvTitle = (TextView) passwordView.findViewById(R.id.tv_title);
        PasswordEditText passwordEdit = (PasswordEditText) passwordView.findViewById(R.id.password_edit_text);
//        builder.setCancelable(false);//点击空白是否消失
        passwordDialog = builder.create();
        passwordDialog.show();
        passwordEdit.setOnPasswordFullListener(new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                ToastUtils.showToast("密码是:" + password);
                tvTitle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        passwordDialog.dismiss();
                    }
                }, 1000);

            }
        });

    }
}
