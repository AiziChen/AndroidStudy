package com.sunrun.toollibrary.utils;

import android.widget.Toast;

import com.sunrun.toollibrary.LibApplication;

public class ToastUtils {

    private static Toast mToast;

     /**
     * 显示Toast
     */
    public static void showToast( CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(LibApplication.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }


}
