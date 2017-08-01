package com.cnsunrun.androidstudy.adapter;

import android.content.Context;
import android.widget.ImageView;

/**
 * 作者：ZhouBin  2017/5/4 14:20
 * 邮箱：1021237228@qq.com
 * 作用：生成九宫格图片的adapter
 */

public abstract class NineGridImageViewAdapter<T> {
    public abstract void onDisplayImage(Context context, ImageView imageView, T t);

    public ImageView generateImageView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }
}
