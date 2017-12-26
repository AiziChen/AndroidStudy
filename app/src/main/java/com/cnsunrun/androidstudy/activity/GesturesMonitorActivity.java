package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GesturesMonitorActivity extends BaseActivity {


    @BindView(R.id.tv_text_one)
    TextView tvTextOne;
    @BindView(R.id.tv_text_two)
    TextView tvTextTwo;

    public static final int TYPE_ONE_CODE = 0X08;
    public static final int TYPE_TWO_CODE = 0X09;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_gestures_monitor);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("手势监听");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {


    }


    @OnClick({R.id.tv_text_one, R.id.tv_text_two})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_text_one:
                setViewOnClick((TextView) view, TYPE_ONE_CODE);
                break;
            case R.id.tv_text_two:
                setViewOnClick((TextView) view, TYPE_TWO_CODE);
                break;
        }
    }


    /**
     * 手势的监听
     *
     * @param textView
     * @param type
     */
    public void setViewOnClick(TextView textView, final int type) {

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP://松开事件发生后执行代码的区域
                        if (type == TYPE_ONE_CODE) {
                            showToast("松开了按钮一");
                        } else {
                            showToast("松开了按钮二");
                        }
                        break;
                    case MotionEvent.ACTION_DOWN://按住事件发生后执行代码的区域
                        if (type == TYPE_ONE_CODE) {
                            showToast("按下了按钮一");
                        } else {
                            showToast("按下了按钮二");
                        }
                        break;

                    case MotionEvent.ACTION_MOVE: // 移动的时候执行
                        if (type == TYPE_ONE_CODE) {
                            showToast("移动了按钮一");
                        } else {
                            showToast("移动了按钮二");
                        }
                        break;

                    default:

                        break;
                }
                return true;
            }
        });

    }
}
