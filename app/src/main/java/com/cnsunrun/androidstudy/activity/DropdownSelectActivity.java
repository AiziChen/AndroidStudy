package com.cnsunrun.androidstudy.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.PopupWindowAdapter;
import com.sunrun.toollibrary.utils.PopupUtils;
import com.sunrun.toollibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DropdownSelectActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_knowledge_type)
    TextView tvKnowledgeType;
    @BindView(R.id.tv_knowledge_category)
    TextView tvKnowledgeCategory;
    @BindView(R.id.tv_knowledge_sort)
    TextView tvKnowledgeSort;

    private static final int TYPE_ONE = 1;//知识分类
    private static final int TYPE_TWO = 2;//全部主题
    private static final int TYPE_THREE = 3;//默认排序
    private List<String> mDatas = new ArrayList<>();
    private PopupWindowAdapter adapter;
    boolean isShowDown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown_select);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        mDatas.add("张学友");
        mDatas.add("林忆莲");
        mDatas.add("刘德华");
        mDatas.add("王菲");
        mDatas.add("周迅");
        mDatas.add("邓紫棋");
        adapter = new PopupWindowAdapter(mDatas);
    }

    /**
     * 显示popupwindow
     *
     * @param type
     * @param view
     */
    private void showDownDiaLog(int type, View view) {

        switch (type) {
            case TYPE_ONE:
                try {
                    View popUpView = View.inflate(this, R.layout.include_recyclerview, null);
                    final PopupWindow popupWindow = PopupUtils.generatePop(popUpView);
//                    popupWindow.setAnimationStyle(R.style.bottomInWindowAnim);//从底部弹出
                    popupWindow.setAnimationStyle(R.style.rightInWindowAnim);//从右边弹出
//                    popupWindow.setAnimationStyle(R.style.dialogWindowAnim);//正常弹出
                    //以某个控件的x和y的偏移量位置开始显示窗口
                    popupWindow.showAsDropDown(view, 0, 0);
                    RecyclerView recyclerView = (RecyclerView) popUpView.findViewById(R.id.recyclerview);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DropdownSelectActivity.this, LinearLayout.VERTICAL, false));
                    recyclerView.setAdapter(adapter);
                    recyclerView.addOnItemTouchListener(new OnItemClickListener() {
                        @Override
                        public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                            tvKnowledgeType.setText(mDatas.get(position));
                            tvKnowledgeType.setTextColor(getResources().getColor(R.color.main_color_2));
                            popupWindow.dismiss();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case TYPE_TWO://中间的textview

                try {
                    View popUpView = View.inflate(this, R.layout.include_recyclerview, null);
                    final PopupWindow popupWindow = PopupUtils.generatePop(popUpView);
                    popupWindow.setAnimationStyle(R.style.bottomInWindowAnim);//从底部弹出
//                    popupWindow.setAnimationStyle(R.style.rightInWindowAnim);//从右边弹出
//                    popupWindow.setAnimationStyle(R.style.dialogWindowAnim);//正常弹出
                    //以某个控件的x和y的偏移量位置开始显示窗口
                    popupWindow.showAsDropDown(view, 0, 0);
                    RecyclerView recyclerView = (RecyclerView) popUpView.findViewById(R.id.recyclerview);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DropdownSelectActivity.this, LinearLayout.VERTICAL, false));
                    recyclerView.setAdapter(adapter);
                    recyclerView.addOnItemTouchListener(new OnItemClickListener() {
                        @Override
                        public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                            tvKnowledgeCategory.setText(mDatas.get(position));
                            tvKnowledgeCategory.setTextColor(getResources().getColor(R.color.yellow_80));
                            popupWindow.dismiss();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case TYPE_THREE:
                try {
                    View popupWindowVIew = View.inflate(this, R.layout.include_recyclerview, null);
                    final PopupWindow popupWindow2 = new PopupWindow(popupWindowVIew, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    //点击空白处时，隐藏掉pop窗口
                    popupWindow2.setFocusable(true);
                    popupWindow2.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#56abe4")));
                    //添加弹出、弹入的动画
                    popupWindow2.setAnimationStyle(R.style.dialogWindowAnim);
//                    popupWindow2.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);//相对于父级容器
                    popupWindow2.showAsDropDown(view, 0, 0);  //相对于控件
                    RecyclerView recyclerView2 = (RecyclerView) popupWindowVIew.findViewById(R.id.recyclerview);
                    recyclerView2.setLayoutManager(new LinearLayoutManager(DropdownSelectActivity.this, LinearLayout.VERTICAL, false));
                    recyclerView2.setAdapter(adapter);
//                    if (isShowDown == false) {
//                        tvKnowledgeSort.setTextColor(getResources().getColor(R.color.red));
//                        isShowDown = true;
//                    } else if (isShowDown == true) {
//                        tvKnowledgeSort.setTextColor(getResources().getColor(R.color.black_40));
//                        isShowDown = false;
//                    }
                    recyclerView2.addOnItemTouchListener(new OnItemClickListener() {
                        @Override
                        public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                            tvKnowledgeSort.setText(mDatas.get(position));
                            tvKnowledgeSort.setTextColor(getResources().getColor(R.color.red));
                            popupWindow2.dismiss();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @OnClick({R.id.iv_arrow_back, R.id.layout_knowledge_type, R.id.layout_knowledge_category, R.id.layout_knowledge_sort})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_arrow_back:
                finish();
                break;
            case R.id.layout_knowledge_type:
                showDownDiaLog(TYPE_ONE, view);
                break;
            case R.id.layout_knowledge_category:
                showDownDiaLog(TYPE_TWO, view);
                break;
            case R.id.layout_knowledge_sort:
                showDownDiaLog(TYPE_THREE, view);
                break;
        }
    }
}
