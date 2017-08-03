package com.cnsunrun.androidstudy.utils;

import android.app.Dialog;
import android.content.Context;

import com.cnsunrun.androidstudy.R;

/**
 * Created by ZhouBin on 2017/8/3.
 * Effect: dialog的工具类
 */

public class DialogUtils {

    private static DialogUtils dialogUtils;

    public synchronized static DialogUtils getInstance() {
        if (dialogUtils == null) {
            dialogUtils = new DialogUtils();
        }
        return dialogUtils;
    }

    public static Dialog determineDialog(Context context) {
        Dialog dialog = new Dialog(context, R.style.NoTitleDialog);


        return null;

    }


}
