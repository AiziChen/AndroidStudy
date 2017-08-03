package com.cnsunrun.androidstudy.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;


public class TitleBuilder {

    private View viewTitle;
    private TextView tvTitle;
    private ImageView ivLeft;
    private ImageView ivRight;
    private ImageView ivRight2;
    private TextView tvLeft;
    private TextView tvRight;
    private Activity context;

    /**
     * 在activity中
     *
     * @param context
     */
    public TitleBuilder(final Activity context) {
        this.context = context;
        viewTitle = context.findViewById(R.id.rl_titlebar);
        tvTitle = (TextView) viewTitle.findViewById(R.id.titlebar_tv);
        ivLeft = (ImageView) viewTitle.findViewById(R.id.titlebar_iv_left);
        ivRight = (ImageView) viewTitle.findViewById(R.id.titlebar_iv_right);
        ivRight2 = (ImageView) viewTitle.findViewById(R.id.titlebar_iv_right2);
        tvLeft = (TextView) viewTitle.findViewById(R.id.titlebar_tv_left);
        tvRight = (TextView) viewTitle.findViewById(R.id.titlebar_tv_right);
        ivLeft.setOnClickListener(new ExitListener());
    }

    /**
     * 针对fragment
     *
     * @param context
     */
    public TitleBuilder(View context) {
        viewTitle = context.findViewById(R.id.rl_titlebar);
        tvTitle = (TextView) viewTitle.findViewById(R.id.titlebar_tv);
        ivLeft = (ImageView) viewTitle.findViewById(R.id.titlebar_iv_left);
        ivRight = (ImageView) viewTitle.findViewById(R.id.titlebar_iv_right);
        tvLeft = (TextView) viewTitle.findViewById(R.id.titlebar_tv_left);
        tvRight = (TextView) viewTitle.findViewById(R.id.titlebar_tv_right);
        ivLeft.setOnClickListener(new ExitListener((Activity) context.getContext()));
        ivRight2 = (ImageView) viewTitle.findViewById(R.id.titlebar_iv_right2);
    }

    //设置字体颜色
    public TitleBuilder setTextColor(int color) {
        tvLeft.setTextColor(color);
        tvTitle.setTextColor(color);
        tvRight.setTextColor(color);
        return this;
    }

    //设置背景颜色
    public TitleBuilder setTitleBgColor(int color) {
        viewTitle.setBackgroundColor(color);
        return this;
    }

    //设置内容(String类型)
    public TitleBuilder setTitleText(String text) {
        tvTitle.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tvTitle.setText(text);
        return this;
    }

    //设置内容(int类型)
    public TitleBuilder setTitleText(int res) {
        tvTitle.setVisibility(res == 0 ? View.GONE : View.VISIBLE);
        tvTitle.setText(res);
        return this;
    }

    //设置字体颜色
    public TitleBuilder setTitleTextColor(int color) {
        tvTitle.setTextColor(color);
        return this;
    }

    //设置标题的监听
    public TitleBuilder setTitleOnClickListener(OnClickListener onClickListener) {
        tvTitle.setOnClickListener(onClickListener);
        return this;
    }

    // left左边的图片
    public TitleBuilder setLeftImage(int resId) {
        ivLeft.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        ivLeft.setImageResource(resId);
        return this;
    }

    //没有返回键
    public TitleBuilder noLeftBack() {
        ivLeft.setVisibility(View.GONE);
        return this;
    }

    //左边的内容
    public TitleBuilder setLeftText(String text) {
        tvLeft.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tvLeft.setText(text);
        return this;
    }

    //设置左边的图片
    public TitleBuilder setLeftDrawable(Drawable drawable) {
        // 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        tvLeft.setCompoundDrawables(drawable, null, null, null);
        return this;
    }

    //左边的监听
    public TitleBuilder setLeftOnClickListener(OnClickListener listener) {
        if (ivLeft.getVisibility() == View.VISIBLE) {
            if (listener != null) {
                ivLeft.setOnClickListener(listener);
            } else {
                ivLeft.setOnClickListener(new ExitListener());
            }
        } else if (tvLeft.getVisibility() == View.VISIBLE) {
            if (listener != null) {
                tvLeft.setOnClickListener(listener);
            } else {
                tvLeft.setOnClickListener(new ExitListener());
            }
        }
        return this;
    }

    // right 右边的图片
    public TitleBuilder setRightImage(int resId) {
        ivRight.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        ivRight.setImageResource(resId);
        return this;
    }

    // 显示右边图片
    public TitleBuilder setRightImageVisib(int visibility) {
        ivRight.setVisibility(visibility);
        return this;
    }

    //右边第二张图片
    public TitleBuilder setRight2Image(int resId) {
        ivRight2.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        ivRight2.setImageResource(resId);
        return this;
    }

    //右边的内容
    public TitleBuilder setRightText(String text) {
        tvRight.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tvRight.setText(text);
        return this;
    }

    //右边的内容显示
    public TitleBuilder setRightTextVisib(int visibility) {
        tvRight.setVisibility(visibility);
        return this;
    }


    //获取右边的内容
    public String getRightText() {
        return tvRight.getText().toString();
    }

    //右边的图片
    public TitleBuilder setRightDrawable(Drawable drawable) {
        // 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        tvRight.setCompoundDrawables(null, null, drawable, null);
        return this;
    }

    //右边的监听
    public TitleBuilder setRightOnClickListener(OnClickListener listener) {
        if (ivRight.getVisibility() == View.VISIBLE) {
            ivRight.setOnClickListener(listener);
        } else if (tvRight.getVisibility() == View.VISIBLE) {
            tvRight.setOnClickListener(listener);
        }
        return this;
    }

    //右边的监听2
    public TitleBuilder setRight2OnClickListener(OnClickListener listener) {
        ivRight2.setVisibility(View.VISIBLE);
        ivRight2.setOnClickListener(listener);
        return this;
    }

    //隐藏标题栏
    public void hideViewTitle() {
        viewTitle.setVisibility(View.GONE);
    }

    //显示标题栏
    public void showViewTitle() {
        viewTitle.setVisibility(View.VISIBLE);
    }

    private class ExitListener implements OnClickListener {
        private Activity mActivity;

        public ExitListener() {
        }

        public ExitListener(Activity activity) {
            mActivity = activity;
        }

        @Override
        public void onClick(View v) {
            if (context == null)
                context = mActivity;
            context.finish();
        }
    }


}
