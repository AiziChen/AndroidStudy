package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.PasswordDialog;
import com.cnsunrun.androidstudy.utils.PasswordPopupWindow;
import com.cnsunrun.androidstudy.view.CustomerKeyboard;
import com.cnsunrun.androidstudy.view.PasswordEditText;
import com.cnsunrun.androidstudy.view.gridpasswordview.GridPasswordView;
import com.sunrun.toollibrary.utils.InputMethodUtils;
import com.sunrun.toollibrary.utils.PopupUtils;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 输入密码框
 */
public class ScrollViewAndRecyclerView extends SwipeBackActivity {


    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
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
        tvTitle.setText("密码输入框");
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


    @OnClick({R.id.iv_arrow_back, R.id.tv_type_one, R.id.tv_type_two, R.id.tv_type_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_arrow_back:
                finish();
                break;
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
        PasswordPopupWindow popupwindow = new PasswordPopupWindow(mContext);
        popupwindow.showPopupWindow(view);
        popupwindow.setTitle("输入密码");
        final PasswordEditText password_edit_text = popupwindow.getPasswordEdit();
        popupwindow.setPasswordClickListeners(new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                ToastUtils.showToast("密码是:" + password);
            }
        });
        popupwindow.customKeyBoard(new CustomerKeyboard.CustomerKeyboardClickListener() {
            @Override
            public void click(String number) {
                password_edit_text.addpassword(number);
            }

            @Override
            public void delete() {
                password_edit_text.deleteLastPassword();
            }
        });

    }

    private void showTypeTwo(View view) {

        final PasswordDialog dialog = new PasswordDialog(mContext);
        dialog.setTitle("请输入订单交易密码");
//        dialog.setCancelable(false);
        dialog.show();
        dialog.setPasswordClickListeners(new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                ToastUtils.showToast("密码是:" + password);
                tvTitle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 1500);
            }
        });
    }

    private void showTypeOne() {
        View passwordView = View.inflate(mContext, R.layout.include_password_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(passwordView);
        final TextView tvTitle = (TextView) passwordView.findViewById(R.id.tv_title);
        PasswordEditText passwordEdit = (PasswordEditText) passwordView.findViewById(R.id.password_edit_text);
//        builder.setCancelable(false);
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
                }, 1500);

            }
        });

    }
}
