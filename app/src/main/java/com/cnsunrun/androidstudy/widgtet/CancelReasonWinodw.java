package com.cnsunrun.androidstudy.widgtet;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;


/**
 * Created by ZhouBin on 2017/7/12.
 * Effect: 取消原因的popupWindow
 */

public class CancelReasonWinodw extends PopupWindow {
    Context mContext;

    private TextView tv_cancel, tv_commfit, tv_reason_one, tv_reason_two;


    public CancelReasonWinodw(Context context, String[] titles) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mView = inflater.inflate(R.layout.cancel_task_reason, null);
        tv_cancel = (TextView) mView.findViewById(R.id.tv_cancel);
        tv_commfit = (TextView) mView.findViewById(R.id.tv_commfit);
        tv_reason_one = (TextView) mView.findViewById(R.id.tv_reason_one);
        tv_reason_two = (TextView) mView.findViewById(R.id.tv_reason_two);
        tv_reason_one.setText(titles[0]);
        tv_reason_two.setText(titles[1]);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.Animation);
        this.setAnimationStyle(R.style.Popupwindow);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }


    public void commfitClickListaner(View.OnClickListener onClickListener) {
        tv_commfit.setOnClickListener(onClickListener);
    }

    public void reasonOneClickListaner(View.OnClickListener onClickListener) {
        tv_reason_one.setOnClickListener(onClickListener);
    }

    public void reasonTwoClickListaner(View.OnClickListener onClickListener) {
        tv_reason_two.setOnClickListener(onClickListener);
    }

}
