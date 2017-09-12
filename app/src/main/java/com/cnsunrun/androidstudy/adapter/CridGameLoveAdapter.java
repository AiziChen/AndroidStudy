package com.cnsunrun.androidstudy.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.model.ProductMes;

import java.util.List;

/**
 * Created by ZhouBin on 2017/9/12.
 * Effect: 卡片式的adapter
 */

public class CridGameLoveAdapter extends BaseQuickAdapter<ProductMes, BaseViewHolder> {
    public CridGameLoveAdapter(List<ProductMes> data) {
        super(R.layout.item_games_love, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductMes item) {
        helper.setText(R.id.tvName, item.getProductMes())
                .setText(R.id.tvPrecent, helper.getLayoutPosition() + "/" + mData.size());
        Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.iv));

    }
}
