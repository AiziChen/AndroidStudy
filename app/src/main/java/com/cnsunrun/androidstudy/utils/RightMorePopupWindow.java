package com.cnsunrun.androidstudy.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.cnsunrun.androidstudy.R;

/**
 * Created by ZhouBin on 2017/8/3.
 * Effect:  右上角更多的PopupWindow
 */

public class RightMorePopupWindow extends PopupWindow {

    public RightMorePopupWindow(Context context) {
        super(context);
        View rightPopupWindow = View.inflate(context, R.layout.right_top_popupwindow, null);
        initViews(rightPopupWindow);
        // 设置SelectPicPopupWindow的View
        this.setContentView(rightPopupWindow);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);
    }

    private void initViews(View rightPopupWindow) {
        RelativeLayout re_addfriends = (RelativeLayout) rightPopupWindow.findViewById(R.id.re_addfriends);
        RelativeLayout re_chatroom = (RelativeLayout) rightPopupWindow.findViewById(R.id.re_chatroom);
        RelativeLayout re_scanner = (RelativeLayout) rightPopupWindow.findViewById(R.id.re_scanner);

    }

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, 0, 0);
        } else {
            this.dismiss();
        }
    }
}
