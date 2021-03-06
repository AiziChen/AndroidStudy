package com.cnsunrun.androidstudy.utils;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.sunrun.toollibrary.utils.ToastUtils;

/**
 * Created by ZhouBin on 2017/8/1.
 * Effect: 地图定位的辅助类
 */

public class LocationMapUtils {

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    private Context mContext;

    public LocationMapUtils(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 初始化定位信息
     *
     * @param aMapLocationListener
     */
    public void initOnLocationMap(AMapLocationListener aMapLocationListener) {
        locationClient = new AMapLocationClient(mContext);
        //设置定位参数
        locationOption = getDefaultOption();
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(aMapLocationListener);
        // 开始定位
        locationClient.startLocation();
    }

    /**
     * 默认的定位参数
     */
    private AMapLocationClientOption getDefaultOption() {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(true);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
    }

    /**
     * 定位的回调
     */
    public static class LocationChangeListener implements AMapLocationListener {

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (null != aMapLocation) {
                if (aMapLocation.getErrorCode() == 0) { //errCode等于0代表定位成功，其他的为定位失败
                } else {
                    ToastUtils.showToast("定位失败:" + aMapLocation.getErrorCode() + aMapLocation.getErrorInfo());
                }
            } else {
                ToastUtils.showToast("定位失败:loc is null");
            }
        }

    }

    /**
     * 停止定位
     */
    private void stopLocation() {
        locationClient.stopLocation();
    }

    /**
     * 销毁定位
     */
    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }

}
