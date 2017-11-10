package com.cnsunrun.androidstudy.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.dao.RegionDao;
import com.cnsunrun.androidstudy.model.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhouBin on 2017/9/29.
 * Effect:  省市区三级选择的控件
 * 有bug,会出现下标越界的情况，数据库查询的结果
 */

public class AreaCityDialog {
    private List<Region> provinces;
    private List<Region> cities;
    private List<Region> areas;
    private Dialog dialog;
    private String mProvince;
    private String mCity;
    private String mArea;

    public AreaCityDialog(Context context) {
        createAreaDialog(context);
    }

    private void createAreaDialog(Context context) {
        dialog = new Dialog(context);
        dialog.show();
        WindowManager windowManager = dialog.getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Window win = dialog.getWindow();
        win.setWindowAnimations(android.R.style.Animation_Translucent);
        WindowManager.LayoutParams lp = win.getAttributes();
        win.setBackgroundDrawableResource(android.R.color.transparent);
        lp.width = (display.getWidth()); //设置宽度
        win.setAttributes(lp);
        View areaView = View.inflate(context, R.layout.dialog_select_area, null);
        final com.wx.wheelview.widget.WheelView wvProvince = (com.wx.wheelview.widget.WheelView) areaView.findViewById(R.id.wvProvince);
        final com.wx.wheelview.widget.WheelView wvCity = (com.wx.wheelview.widget.WheelView) areaView.findViewById(R.id.wvCity);
        com.wx.wheelview.widget.WheelView wvArea = (com.wx.wheelview.widget.WheelView) areaView.findViewById(R.id.wvArea);
        TextView tvEnter = (TextView) areaView.findViewById(R.id.tvEnter);

        provinces = RegionDao.getProvinces();
        cities = RegionDao.queryCities(provinces.get(0).AdCode);
        areas = RegionDao.queryAreas(cities.get(0).CityCode);
        com.wx.wheelview.adapter.ArrayWheelAdapter provinceAdapter = new com.wx.wheelview.adapter.ArrayWheelAdapter(context);
        final com.wx.wheelview.adapter.ArrayWheelAdapter cityAdapter = new com.wx.wheelview.adapter.ArrayWheelAdapter(context);
        final com.wx.wheelview.adapter.ArrayWheelAdapter areaAdapter = new com.wx.wheelview.adapter.ArrayWheelAdapter(context);
//            设置省市区初始数据
        wvProvince.setWheelAdapter(provinceAdapter);
        wvProvince.setWheelData(getAddressTitle(provinces));
        wvCity.setWheelAdapter(cityAdapter);
        wvCity.setWheelData(getAddressTitle(cities));
        wvArea.setWheelAdapter(areaAdapter);
        wvArea.setWheelData(getAddressTitle(areas));
        //区code和省市区文字
        final String[] code = {areas.get(0).AdCode, getAddressText(0, 0, 0), provinces.get(0).CityCode};
        wvProvince.setSkin(com.wx.wheelview.widget.WheelView.Skin.Holo);
        wvCity.setSkin(com.wx.wheelview.widget.WheelView.Skin.Holo);
        wvArea.setSkin(com.wx.wheelview.widget.WheelView.Skin.Holo);

        wvProvince.setOnWheelItemSelectedListener(new com.wx.wheelview.widget.WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onItemSelected(int position, Object o) {
                cities.clear();
                cities.addAll(RegionDao.queryCities(provinces.get(position).AdCode));
                cityAdapter.setData(getAddressTitle(cities));
                areas.clear();
                try {
                    areas.addAll(RegionDao.queryAreas(cities.get(0).CityCode));
                    code[0] = areas.get(0).AdCode;
                    code[1] = getAddressText(position, 0, 0);
                    code[2] = provinces.get(position).CityCode;
                } catch (Exception e) {
                    //没有城市和区
                    code[0] = provinces.get(position).AdCode;
                    code[1] = provinces.get(position).Name;
                    code[2] = provinces.get(position).CityCode;
                }
                areaAdapter.setData(getAddressTitle(areas));

            }
        });
        wvCity.setOnWheelItemSelectedListener(new com.wx.wheelview.widget.WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onItemSelected(int position, Object o) {
                areas.clear();
                try {
                    areas.addAll(RegionDao.queryAreas(cities.get(position).CityCode));
                    code[0] = areas.get(0).AdCode;
                    code[1] = getAddressText(wvProvince.getCurrentPosition(), position, 0);
                } catch (Exception e) {
                    //没有城市和区
                    code[0] = provinces.get(position).AdCode;
                    code[1] = provinces.get(position).Name;
                }
                areaAdapter.setData(getAddressTitle(areas));

            }
        });
        wvArea.setOnWheelItemSelectedListener(new com.wx.wheelview.widget.WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onItemSelected(int position, Object o) {
                code[0] = areas.get(position).AdCode;
                code[1] = getAddressText(wvProvince.getCurrentPosition(), wvCity.getCurrentPosition(), position);
            }
        });
        tvEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (onSelectedAreaListener != null) {
                    onSelectedAreaListener.onSelectedAreaSuccess(code, mProvince, mCity, mArea);
                }


            }
        });
        dialog.setContentView(areaView);
    }

    public void show() {
        dialog.show();
    }

    private String getAddressText(int provinceIndex, int cityIndex, int areaIndex) {
        mProvince = provinces.get(provinceIndex).Name;
        mCity = cities.get(cityIndex).Name;
        mArea = areas.get(areaIndex).Name;
        return mProvince + " " + mCity + " " + mArea;
    }

    /**
     * 获取名称
     * @param regions
     * @return
     */
    private List<String> getAddressTitle(List<Region> regions) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < regions.size(); i++) {
            list.add(regions.get(i).Name);
        }
        return list;
    }

    private OnSelectedAreaListener onSelectedAreaListener;

    public void setOnSelectedAreaListener(OnSelectedAreaListener onSelectedAreaListener) {
        this.onSelectedAreaListener = onSelectedAreaListener;
    }

    /**
     * 回调的接口
     */
    public interface OnSelectedAreaListener {
        void onSelectedAreaSuccess(String[] code, String province, String city, String area);
    }
}
