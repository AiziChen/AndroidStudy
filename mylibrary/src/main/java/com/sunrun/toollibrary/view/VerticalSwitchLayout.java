package com.sunrun.toollibrary.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunrun.toollibrary.R;

import java.util.List;

/**
 * Created by zhoubin on 2016/5/26.
 */
public class VerticalSwitchLayout extends LinearLayout implements View.OnClickListener {

    private static final int DEFAULT_SWITCH_DURATION = 250;
    private static final int DEFAULT_IDLE_DURATION = 5000;
    private int switchDuaration = DEFAULT_SWITCH_DURATION;//切换时间
    private int idleDuaration = DEFAULT_IDLE_DURATION;//间隔时间

    private TextView tvTitle, tvContent;

    private List<String[]> arrayList;
    private List<String> strList;
    private ObjectAnimator outAnimator;
    private int contentSize;
    private int currentIndex = 0;//当前显示到第几个文本


    public VerticalSwitchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.layout_vertical_switch, this);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvContent = (TextView) findViewById(R.id.tvContent);

        setOnClickListener(this);


        measure(0, 0);
        int height = getMeasuredHeight();

        final ObjectAnimator inAnimator = ObjectAnimator.ofFloat(tvContent, "translationY", height, 0);
        inAnimator.setDuration(switchDuaration);
        inAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                outAnimator.setStartDelay(idleDuaration);
                outAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        outAnimator = ObjectAnimator.ofFloat(tvContent, "translationY", 0, height);
        outAnimator.setDuration(switchDuaration);
        outAnimator.setStartDelay(idleDuaration);
        outAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                currentIndex = (++currentIndex) % contentSize;
                if (strList != null && strList.size() > 0) {
                    tvContent.setText(Html.fromHtml(strList.get(currentIndex)));
                } else {
                    tvTitle.setText(Html.fromHtml(arrayList.get(currentIndex)[0]));
                    tvContent.setText(Html.fromHtml(arrayList.get(currentIndex)[1]));
                }
                inAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }


    public void setArrayContent(List<String[]> content) {
        arrayList = content;
        contentSize = content.size();
        if (contentSize > 0) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(arrayList.get(0)[0]);
            tvContent.setText(arrayList.get(0)[1]);
            outAnimator.start();
        }
    }

    public void setContent(List<String> content) {
        strList = content;
        contentSize = content.size();
        if (contentSize > 0) {
            tvContent.setText(Html.fromHtml(strList.get(0)));
            outAnimator.start();
        }
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(currentIndex);
        }
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onClick(int index);
    }

}
