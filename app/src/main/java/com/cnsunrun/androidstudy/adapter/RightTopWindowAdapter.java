package com.cnsunrun.androidstudy.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.sunrun.toollibrary.utils.ImageLoaderUtils;

import java.util.List;


/**
 * Created by ZhouBin on 2017/9/1.
 * Effect: 右上角window的adapter
 */

public class RightTopWindowAdapter extends BaseQuickAdapter<ProductMes, BaseViewHolder> {
    public RightTopWindowAdapter(List<ProductMes> data) {
        super(R.layout.right_top_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductMes item) {
        ImageView imageView = helper.getView(R.id.iv_left_imageView);
        ImageLoaderUtils.displayAvatar(item.getImageUrl(), imageView);
        helper.setText(R.id.tv_right_text, item.getProductMes());
        View view = helper.getView(R.id.tv_divide);
        int position = helper.getLayoutPosition();
        if (position == mData.size() - 1) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }

    }
}
