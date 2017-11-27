package com.cnsunrun.androidstudy.adapter;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.cnsunrun.androidstudy.widgtet.RoundImageView;

import java.util.List;

/**
 * Created by ZhouBin on 2017/6/7.
 * Effect:CridView的adapter
 */

public class CardViewAdapter extends BaseQuickAdapter<ProductMes, BaseViewHolder> {


    public CardViewAdapter(List<ProductMes> data) {
        super(R.layout.item_cridview, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductMes item) {
        RoundImageView imageView = helper.getView(R.id.iv_roundimage);
        Glide.with(mContext).load(item.getImageUrl()).into(imageView);
        helper.setText(R.id.tv_message, item.getProductMes());

    }
}
