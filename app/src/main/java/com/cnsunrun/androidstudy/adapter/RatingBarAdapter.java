package com.cnsunrun.androidstudy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.model.RatingBarModel;

import java.util.List;

/**
 * Created by ZhouBin on 2017/6/9.
 * Effect: 评分条的adapter
 */

public class RatingBarAdapter extends BaseQuickAdapter<RatingBarModel, BaseViewHolder> {
    public RatingBarAdapter(List<RatingBarModel> data) {
        super(R.layout.item_rating, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RatingBarModel item) {

        helper.setText(R.id.tv_message, item.getProjectName())
                .setRating(R.id.ratingBar, item.getStoreScore());

    }
}
