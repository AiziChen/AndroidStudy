package com.cnsunrun.androidstudy.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.widgtet.CancelReasonWinodw;
import com.cnsunrun.androidstudy.widgtet.FinishProjectPopupWindows;
import com.sunrun.toollibrary.LibActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupWindowActivity extends LibActivity {

    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_show_popupwindow)
    TextView tvShowPopupwindow;
    @BindView(R.id.tv_show_popupwindow2)
    TextView tvShowPopupwindow2;
    private FinishProjectPopupWindows mFinishProjectPopupWindow;
    private CancelReasonWinodw popupWindow;

    private String[] titles = {"需求已经完成", "不需要帮助了"};

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_popup_window);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        tvTitle.setText("popupWindow的练习使用");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mFinishProjectPopupWindow.dismiss();
            switch (v.getId()) {
                case R.id.popupwindow_Button_saveProject:
                    showToast("点击了保存");
                    break;
                case R.id.popupwindow_Button_abandonProject:
                    showToast("点击了放弃");
                    break;
                case R.id.popupwindow_cancelButton:
                    showToast("点击了取消");
                    mFinishProjectPopupWindow.dismiss();
                    break;
            }

        }

    };

    @OnClick({R.id.iv_arrow_back, R.id.tv_show_popupwindow, R.id.tv_show_popupwindow2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_arrow_back:
                finish();
                break;
            case R.id.tv_show_popupwindow:
                mFinishProjectPopupWindow = new FinishProjectPopupWindows(PopupWindowActivity.this, itemsOnClick);
                mFinishProjectPopupWindow.showAtLocation(PopupWindowActivity.this.findViewById(R.id.activity_popup_window),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;

            case R.id.tv_show_popupwindow2:
                if (popupWindow != null && popupWindow.isShowing()) {
                    return;
                }
                popupWindow = new CancelReasonWinodw(mContext, titles);
                popupWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                popupWindow.commfitClickListaner(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("点击了确定");

                    }
                });
                popupWindow.reasonOneClickListaner(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("点击了原因1");
                    }
                });
                popupWindow.reasonTwoClickListaner(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("点击了原因2");
                    }
                });
                break;
        }
    }
}
