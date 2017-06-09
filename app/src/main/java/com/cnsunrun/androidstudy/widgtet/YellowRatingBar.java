package com.cnsunrun.androidstudy.widgtet;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.RatingBar;

import com.cnsunrun.androidstudy.R;

/**
 * Created by ZhouBin on 2017/6/9.
 * Effect:
 */

public class YellowRatingBar extends RatingBar {
    public YellowRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getProgressDrawable().setColorFilter(getResources().getColor(R.color.main_color), PorterDuff.Mode.SRC_ATOP);
    }

    public YellowRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YellowRatingBar(Context context) {
        this(context, null);
    }
}
