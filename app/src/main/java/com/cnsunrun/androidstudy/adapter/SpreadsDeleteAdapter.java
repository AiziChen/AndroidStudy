package com.cnsunrun.androidstudy.adapter;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.cnsunrun.androidstudy.widgtet.RoundImageView;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by ZhouBin on 2017/8/28.
 * Effect: 侧滑删除的adapter
 */

public class SpreadsDeleteAdapter extends BaseQuickAdapter<ProductMes, BaseViewHolder> {
    public SpreadsDeleteAdapter(List<ProductMes> data) {
        super(R.layout.item_spread_delete, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductMes item) {
        RoundImageView imageView = helper.getView(R.id.iv_roundimage);
        Glide.with(mContext).load(item.getImageUrl()).into(imageView);
        Logger.d("ImageUrl==" + item.getImageUrl());
        helper.setText(R.id.tv_message, item.getProductMes());
    }
}
