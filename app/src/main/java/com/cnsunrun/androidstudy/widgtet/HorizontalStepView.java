package com.cnsunrun.androidstudy.widgtet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.cnsunrun.androidstudy.R;

/**
 * Created by : Z_B on 2017/11/23.
 * Effect : 自定义水平的步骤条
 */

public class HorizontalStepView extends LinearLayout {
    public HorizontalStepView(Context context) {
        this(context, null);
    }

    public HorizontalStepView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalStepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View customView = View.inflate(context, R.layout.horizontal_step_view_layout, this);
    }
}
