package com.cnsunrun.androidstudy.utils;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.cnsunrun.androidstudy.view.CustomerKeyboard;
import com.cnsunrun.androidstudy.view.PasswordEditText;

import java.util.List;

/**
 * Created by ZhouBin on 2017/8/25.
 * Effect: dialog的封装工具类
 */

public class AlerDialogUtils {


    public static AlerDialogUtils alerDialogUtils;

    public AlerDialogUtils() {
    }

    public static synchronized AlerDialogUtils getInstance() {
        if (alerDialogUtils == null) {
            alerDialogUtils = new AlerDialogUtils();
        }
        return alerDialogUtils;
    }

    /**
     * 默认的样式
     *
     * @param context              上下文
     * @param passwordFullListener 忘记密码按钮的监听
     * @return
     */
    public static PasswordDialog passwordDialog(Context context, PasswordEditText.PasswordFullListener passwordFullListener) {
        return passwordDialog(context, null, null, false, false, passwordFullListener, null);
    }

    /**
     * 只输入标题
     *
     * @param context              上下文
     * @param Title                标题
     * @param passwordFullListener 忘记密码按钮的监听
     * @return
     */
    public static PasswordDialog passwordDialog(Context context, String Title, PasswordEditText.PasswordFullListener passwordFullListener) {

        return passwordDialog(context, Title, null, false, false, passwordFullListener, null);
    }

    /**
     * 输入标题和提示信息
     *
     * @param context              上下文
     * @param Title                标题
     * @param hitMessage           提示信息
     * @param passwordFullListener 忘记密码按钮的监听
     * @return
     */
    public static PasswordDialog passwordDialog(Context context, String Title, String hitMessage, PasswordEditText.PasswordFullListener passwordFullListener) {

        return passwordDialog(context, Title, hitMessage, false, false, passwordFullListener, null);
    }

    /**
     * 修改标题和显示忘记密码
     *
     * @param context              上下文
     * @param Title                标题
     * @param isShowForgot         是否显示忘记密码按钮
     * @param passwordFullListener 密码输入框的监听
     * @param onClickListener      忘记密码按钮的监听
     * @return
     */
    public static PasswordDialog passwordDialog(Context context, String Title, boolean isShowForgot, PasswordEditText.PasswordFullListener passwordFullListener, View.OnClickListener onClickListener) {

        return passwordDialog(context, Title, null, false, isShowForgot, passwordFullListener, onClickListener);
    }

    /**
     * 修改标题,显示提示信息,显示忘记密码
     *
     * @param context              上下文
     * @param Title                标题
     * @param hitMessage           提示信息
     * @param isShowForgot         是否显示忘记密码按钮
     * @param passwordFullListener 密码输入框的监听
     * @param onClickListener      忘记密码按钮的监听
     * @return
     */
    public static PasswordDialog passwordDialog(Context context, String Title, String hitMessage, boolean isShowForgot, PasswordEditText.PasswordFullListener passwordFullListener, View.OnClickListener onClickListener) {

        return passwordDialog(context, Title, hitMessage, false, isShowForgot, passwordFullListener, onClickListener);
    }

    /**
     * 全部都显示
     *
     * @param context              上下文
     * @param Title                标题
     * @param hitMessage           提示信息
     * @param isShowCancel         是否显示取消按钮
     * @param isShowForgot         是否显示忘记密码按钮
     * @param passwordFullListener 密码输入框的监听
     * @param onClickListener      忘记密码按钮的监听
     * @return
     */
    public static PasswordDialog passwordDialog(Context context, String Title, String hitMessage, boolean isShowCancel, boolean isShowForgot, final PasswordEditText.PasswordFullListener passwordFullListener, final View.OnClickListener onClickListener) {
        final PasswordDialog passwordDialog = new PasswordDialog(context);
        passwordDialog.setTitle(Title);
        passwordDialog.setHitMessage(hitMessage);
        passwordDialog.setShowCancelView(isShowCancel);
        if (isShowForgot == true) {
            passwordDialog.showBottomTextView(isShowForgot);
            passwordDialog.setForgotPasswordClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.onClick(v);
                    }
                    passwordDialog.dismiss();
                }
            });
        }
        passwordDialog.setPasswordClickListeners(new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                if (passwordFullListener != null) {
                    passwordFullListener.passwordFull(password);
                }
                passwordDialog.dismiss();
            }
        });
        return passwordDialog;
    }

    /**
     * 自定义键盘的密码输入框
     *
     * @param context              上下文
     * @param passwordFullListener 密码输入框的监听
     * @return
     */
    public static PasswordEditDialog passwordEditDialog(Context context, final PasswordEditText.PasswordFullListener passwordFullListener) {

        return passwordEditDialog(context, null, passwordFullListener);
    }

    /**
     * 自定义键盘的密码输入框
     *
     * @param context              上下文
     * @param title                标题
     * @param passwordFullListener 密码输入框的监听
     * @return
     */
    public static PasswordEditDialog passwordEditDialog(Context context, String title, final PasswordEditText.PasswordFullListener passwordFullListener) {
        final PasswordEditDialog passwordEditDialog = new PasswordEditDialog(context);
        passwordEditDialog.setTitle(title);
        final PasswordEditText password_edit_text = passwordEditDialog.getPasswordEdit();
        passwordEditDialog.setPasswordClickListeners(new PasswordEditText.PasswordFullListener() {
            @Override
            public void passwordFull(String password) {
                if (passwordFullListener != null) {
                    passwordFullListener.passwordFull(password);
                }
                passwordEditDialog.dismiss();
            }
        });
        passwordEditDialog.customKeyBoard(new CustomerKeyboard.CustomerKeyboardClickListener() {
            @Override
            public void click(String number) {
                password_edit_text.addpassword(number);
            }

            @Override
            public void delete() {
                password_edit_text.deleteLastPassword();
            }

        });
        return passwordEditDialog;
    }

    /**
     * 右上角的popupWindow
     *
     * @param context             上下文
     * @param mDatas              数据
     * @param view                显示的控件
     * @param onItemClickListener 点击回调
     * @return
     */
    public static RightMorePopupWindow rightMorePopupWindow(Context context, List<ProductMes> mDatas, View view, OnItemClickListener onItemClickListener) {
        RightMorePopupWindow rightMorePopupWindow = new RightMorePopupWindow(context, mDatas, onItemClickListener);
        rightMorePopupWindow.showPopupWindow(view);
        return rightMorePopupWindow;
    }


    /**
     * 选择方式
     *
     * @param context
     * @param onButtonClickListener
     */
    public static void SelectItemDailog(Context context, final SelectItemDailog.OnButtonClickListener onButtonClickListener) {
        final SelectItemDailog selectItemDailog = new SelectItemDailog(context);
        selectItemDailog.setOnButtonClickListener(new SelectItemDailog.OnButtonClickListener() {
            @Override
            public void selectItemOne() {
                if (onButtonClickListener != null) {
                    onButtonClickListener.selectItemOne();
                }
                selectItemDailog.dismiss();
            }

            @Override
            public void selectItemTwo() {
                if (onButtonClickListener != null) {
                    onButtonClickListener.selectItemTwo();
                }
                selectItemDailog.dismiss();
            }
        });
    }

}
