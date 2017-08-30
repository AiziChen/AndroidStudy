package com.cnsunrun.androidstudy.zxing;

/**
 * Created by ZhouBin on 2017/8/30.
 * Effect: 二维码生成和帮助的类
 */

public class ZXingUtils {

    private static ZXingUtils zXingUtils;

    public static synchronized ZXingUtils getzXingUtils() {
        if (zXingUtils == null) {
            zXingUtils = new ZXingUtils();
        }
        return zXingUtils;
    }

}
