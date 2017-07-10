package com.cnsunrun.androidstudy.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.jph.takephoto.model.TImage;

import java.io.File;
import java.util.List;

/**
 * Created by ZhouBin on 2017/7/10.
 * Effect:  选择图片的额adapter
 */

public class ChooseImageAdapter extends BaseQuickAdapter<TImage, BaseViewHolder> {
    public ChooseImageAdapter(List<TImage> data) {
        super(R.layout.item_choose, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TImage item) {
        ImageView imageView = helper.getView(R.id.iv_imageview);
        Glide.with(mContext).load(new File(item.getCompressPath())).into(imageView);
    }
}
