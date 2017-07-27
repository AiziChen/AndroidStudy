package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.view.CustomRatingBar;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class PopupWindowActivity extends SwipeBackActivity {


    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.RatingBar02)
    MaterialRatingBar RatingBar02;
    @BindView(R.id.RatingBar03)
    MaterialRatingBar RatingBar03;
    @BindView(R.id.almanac_yunshi_treasure)
    CustomRatingBar almanacYunshiTreasure;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_popup_window);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        tvTitle.setText("自定义RatingBar");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        RatingBar02.setRating(2f);
        RatingBar03.setRating(3.5f);
        almanacYunshiTreasure.setActiveSize(4);

    }

    @Override
    protected void setListener() {
        RatingBar03.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ToastUtils.showToast("几颗星=" + rating);
            }
        });

    }


    @OnClick(R.id.iv_arrow_back)
    public void onViewClicked() {
        finish();
    }

}
