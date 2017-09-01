package com.cnsunrun.androidstudy.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.RightTopWindowAdapter;
import com.cnsunrun.androidstudy.model.ProductMes;

import java.util.List;

/**
 * Created by ZhouBin on 2017/8/3.
 * Effect:  右上角更多的PopupWindow
 */

public class RightMorePopupWindow extends PopupWindow {

    public RightMorePopupWindow(Context context, List<ProductMes> mDatas, OnItemClickListener onItemClickListener) {
        super(context);
        View rightPopupWindow = View.inflate(context, R.layout.right_top_popupwindow, null);
        initViews(context, rightPopupWindow, mDatas, onItemClickListener);
        this.setContentView(rightPopupWindow);
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        ColorDrawable dw = new ColorDrawable(0000000000);
        this.setBackgroundDrawable(dw);
        this.setAnimationStyle(R.style.AnimationPreview);
    }

    /**
     * 初始化控件
     *
     * @param context
     * @param rightPopupWindow
     * @param mDatas
     * @param onItemClickListener
     */
    private void initViews(Context context, View rightPopupWindow, List<ProductMes> mDatas, final OnItemClickListener onItemClickListener) {
        RecyclerView recyclerView = (RecyclerView) rightPopupWindow.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new RightTopWindowAdapter(mDatas));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.VERTICAL, false));
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (onItemClickListener != null) {
                    onItemClickListener.onSimpleItemClick(adapter, view, position);
                }
                RightMorePopupWindow.this.dismiss();
            }
        });

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
