package com.cnsunrun.androidstudy.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by ZhouBin on 2017/6/8.
 * Effect: 本地位图压缩解码的工具类
 */

public class BitMapUtils {

    /**
     * @param resources 资源文件
     * @param resId     解码位图id
     * @param reqWidth  指定输出位图的宽度
     * @param reqHeight 指定输出位图的高度
     * @return bitmap对象
     */
    public static Bitmap decodeBitMap(Resources resources, int resId, int reqWidth, int reqHeight) {

        //对位图进行解码的参数设置
        BitmapFactory.Options options = new BitmapFactory.Options();
        //对位图进行解码的过程中，避免申请内存空间
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        //对图片进行一定比例的压缩处理
        options.inSampleSize = calculateInSimpleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false; //真正输出位图
        return BitmapFactory.decodeResource(resources, resId, options);
    }


    /**
     * 对图片进行压缩
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSimpleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        //获得原始图片的宽和高
        int imageWidth = options.outWidth;
        int imageHeight = options.outHeight;
        int inSimpleSize = 1;//设置压缩比例
        if (imageWidth > reqHeight || imageHeight > reqHeight) {
            final int heightRatio = Math.round((float) imageHeight / (float) reqHeight);
            final int widthRatio = Math.round((float) imageWidth / (float) reqWidth);
            inSimpleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSimpleSize;

    }

}
