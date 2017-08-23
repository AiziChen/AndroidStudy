package com.cnsunrun.androidstudy.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;

import java.util.List;

/**
 * Created by ZhouBin on 2017/8/23.
 * Effect:  水平的布局视图的adapter
 */

public class HorizontalViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public HorizontalViewAdapter(List<String> data) {
        super(R.layout.item_horizotal_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.iv_product_image));

    }
}
