package com.cnsunrun.androidstudy.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.RatingBar;

import com.cnsunrun.androidstudy.R;

public class YellowRatingBar extends RatingBar {
    public YellowRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getProgressDrawable().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
    }

    public YellowRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YellowRatingBar(Context context) {
        this(context, null);
    }
}
