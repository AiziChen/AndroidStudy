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

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.SelectTypeAdapter;
import com.cnsunrun.androidstudy.widgtet.VerticalItemDecoration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhouBin on 2017/8/22.
 * Effect:多项选择的对话框
 */

public class SelectMoreTypeDailog extends Dialog {

    private RecyclerView recyclerView;
    private TextView tvCancel;
    private Context mContext;


    public SelectMoreTypeDailog(Context context) {
        super(context);
        Window window = this.getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        View popupView = View.inflate(context, R.layout.select_more_type_dialog, null);
        window.setContentView(popupView);
        initViews(popupView, context);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.windowAnimations = R.style.bottomInWindowAnim;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    /**
     * 初始化控件
     *
     * @param popupView
     */
    private void initViews(View popupView, Context context) {
        mContext = context;
        recyclerView = (RecyclerView) popupView.findViewById(R.id.recyclerView);
        tvCancel = (TextView) popupView.findViewById(R.id.tv_cancel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectMoreTypeDailog.this.dismiss();
            }
        });

        List<String> mData = Arrays.asList("语文", "数学", "英语", "物理", "化学", "生物", "政治");
        recyclerView.setAdapter(new SelectTypeAdapter(mData));
        recyclerView.addItemDecoration(new VerticalItemDecoration(mContext, mContext.getResources().getColor(R.color.line_bg_dark), 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.VERTICAL, false));

    }
}
