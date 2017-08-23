package com.cnsunrun.androidstudy.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.SelectTypeAdapter;
import com.cnsunrun.androidstudy.widgtet.DividerItemDecoration;

import java.util.List;

/**
 * Created by ZhouBin on 2017/8/22.
 * Effect:多项选择的对话框
 */

public class SelectMoreTypeDailog extends Dialog {

    private RecyclerView recyclerView;
    private TextView tvCancel;


    public SelectMoreTypeDailog(Context context, List<String> mData, OnItemClickListener onItemClickListener) {
        super(context);
        Window window = this.getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        View popupView = View.inflate(context, R.layout.select_more_type_dialog, null);
        window.setContentView(popupView);
        initViews(popupView, context, mData, onItemClickListener);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.windowAnimations = R.style.bottomInWindowAnim;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        SelectMoreTypeDailog.this.show();
    }

    /**
     * 初始化控件
     *
     * @param popupView
     */
    private void initViews(View popupView, Context context, List<String> mData, final OnItemClickListener onItemClickListener) {
        recyclerView = (RecyclerView) popupView.findViewById(R.id.recyclerView);
        tvCancel = (TextView) popupView.findViewById(R.id.tv_cancel);

        recyclerView.setAdapter(new SelectTypeAdapter(mData));
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.VERTICAL, false));

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectMoreTypeDailog.this.dismiss();
            }
        });

        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (onItemClickListener != null) {
                    onItemClickListener.onSimpleItemClick(adapter, view, position);

                }
                SelectMoreTypeDailog.this.dismiss();
            }
        });
    }
}
