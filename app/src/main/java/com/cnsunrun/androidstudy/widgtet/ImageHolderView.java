package com.cnsunrun.androidstudy.widgtet;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.sunrun.toollibrary.utils.ImageLoaderUtils;

/**
 * Created by ZhouBin on 2017/6/9.
 * Effect: 加载轮播图片
 */

public class ImageHolderView implements Holder<String> {

    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        ImageLoaderUtils.displayImage(data, imageView);
    }
}
