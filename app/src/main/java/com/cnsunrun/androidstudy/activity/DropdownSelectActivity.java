package com.cnsunrun.androidstudy.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.dialog.CommonDialog;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.utils.RightMorePopupWindow;
import com.cnsunrun.androidstudy.view.TitleBuilder;
import com.cnsunrun.androidstudy.wxpay.PayWXUtils;
import com.cnsunrun.androidstudy.wxpay.WXPayUtils;
import com.sunrun.toollibrary.utils.PopupUtils;
import com.sunrun.toollibrary.utils.ToastUtils;
import com.sunrun.toollibrary.view.IosDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.amap.api.col.bz.P;

/**
 * popupWindow的练习和封装
 */
public class DropdownSelectActivity extends SwipeBackActivity {

    private static final int TYPE_ONE = 1;//知识分类
    private static final int TYPE_TWO = 2;//全部主题
    private static final int TYPE_THREE = 3;//默认排序
    @BindView(R.id.tv_knowledge_type)
    TextView tvKnowledgeType;
    @BindView(R.id.layout_knowledge_type)
    LinearLayout layoutKnowledgeType;
    @BindView(R.id.tv_knowledge_category)
    TextView tvKnowledgeCategory;
    @BindView(R.id.layout_knowledge_category)
    LinearLayout layoutKnowledgeCategory;
    @BindView(R.id.tv_knowledge_sort)
    TextView tvKnowledgeSort;
    @BindView(R.id.layout_knowledge_sort)
    LinearLayout layoutKnowledgeSort;
    @BindView(R.id.tv_type_one)
    TextView tvTypeOne;
    @BindView(R.id.tv_type_two)
    TextView tvTypeTwo;
    @BindView(R.id.tv_type_three)
    TextView tvTypeThree;
    private List<String> mDatas = new ArrayList<>();
    private PopupWindowAdapter adapter;

    AlertDialog cusAlertDialog;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_dropdown_select);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void bindViews() {
        TitleBuilder titleBuilder = new TitleBuilder(this);
        titleBuilder.setTitleText("PopupWindow的练习");
        titleBuilder.setRightImageVisib(View.VISIBLE);
        titleBuilder.setRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopPopup(v);

            }
        });

    }

    /**
     * 右上角的popupWindow
     *
     * @param view
     */
    private void showTopPopup(View view) {
        RightMorePopupWindow rightMorePopupWindow = new RightMorePopupWindow(this);
        rightMorePopupWindow.showPopupWindow(view);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }


    private void initView() {
        initTitle("选择性提示框的练习");
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


    @OnClick({R.id.layout_knowledge_type, R.id.layout_knowledge_category, R.id.layout_knowledge_sort, R.id.tv_type_one, R.id.tv_type_two, R.id.tv_type_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_knowledge_type:
                showDownDiaLog(TYPE_ONE, view);
                break;
            case R.id.layout_knowledge_category:
                showDownDiaLog(TYPE_TWO, view);
                break;
            case R.id.layout_knowledge_sort:
                showDownDiaLog(TYPE_THREE, view);
                break;
            case R.id.tv_type_one:
                showDialogOne();
                break;
            case R.id.tv_type_two:
                final IosDialog dailog = new IosDialog(mContext).builder();
                dailog.setMsg("提现帐号")
                        .setEditHint("请输入提现帐号")
                        .setEditTextSize(14)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String result = dailog.getResult();
                                ToastUtils.showToast(result);
                            }
                        }).show();

                break;
            case R.id.tv_type_three:
                showDialogThree();
                break;
        }
    }

    private void showDialogThree() {
        final CommonDialog.Builder builder = new CommonDialog.Builder(DropdownSelectActivity.this);
        builder.setView(R.layout.dialog_customer_keyboard).fromBottom().fullWidth().create().show();

        builder.getView(R.id.delete_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
    }

    /**
     * 微信支付
     */
    private void showDialogOne() {
        String callBackUrl = ConstantValue.WX_ORDER_CALLBACK;
        String title = "微信支付";
        String orderPrice = "0.01";
        String describe = "订单支付";
        String orderNumber = "2017080410248504";
        WXPayUtils wxPayUtils = new WXPayUtils(this, callBackUrl);
        wxPayUtils.pay(title, orderPrice, describe, orderNumber);
//        PayWXUtils payWXUtils=new PayWXUtils(this);
//        payWXUtils.wXPay(callBackUrl);


    }
}
