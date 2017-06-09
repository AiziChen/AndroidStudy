package com.cnsunrun.androidstudy.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by ZhouBin on 2017/6/9.
 * Effect: 使用glide加载banner图片
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Logger.d("imageUrl==" + path);
        Glide.with(context).load(path).into(imageView);
    }


}
