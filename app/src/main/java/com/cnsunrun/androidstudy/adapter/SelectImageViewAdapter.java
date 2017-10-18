package com.cnsunrun.androidstudy.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.lzy.imagepicker.bean.ImageItem;

import java.util.List;

/**
 * Created by ZhouBin on 2017/9/11.
 * Effect: 多图片选择的adapter
 */

public class SelectImageViewAdapter extends BaseQuickAdapter<ImageItem, BaseViewHolder> {
    public SelectImageViewAdapter(List<ImageItem> data) {
        super(R.layout.item_contant_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ImageItem item) {
        Glide.with(mContext).load(item.path).into((ImageView) helper.getView(R.id.iv_imageView));

    }
}
