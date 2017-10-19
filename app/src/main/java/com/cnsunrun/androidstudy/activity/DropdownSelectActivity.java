package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.cnsunrun.androidstudy.utils.AlerDialogUtils;
import com.cnsunrun.androidstudy.view.CustomRadarChart;
import com.cnsunrun.androidstudy.view.TitleBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 能力雷达图
 */
public class DropdownSelectActivity extends BaseActivity {


    @BindView(R.id.customRadarChart)
    CustomRadarChart customRadarChart;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_dropdown_select);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        TitleBuilder titleBuilder = new TitleBuilder(this);
        titleBuilder.setTitleText("能力雷达图");
        titleBuilder.setRightImageVisib(View.VISIBLE);
        titleBuilder.setRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopPopup(v);

            }
        });

    }

    /**
     * 右上角的popupWindow
     *
     * @param view
     */
    private void showTopPopup(View view) {
        String[] imageList = {
                "http://s1.cdn.xiachufang.com/bc55fd5aec3911e6bc9d0242ac110002_640w_427h.jpg",
                "http://s1.cdn.xiachufang.com/957171ee064011e7947d0242ac110002_1280w_853h.jpg",
                "http://s1.cdn.xiachufang.com/bd54e300886c11e6a9a10242ac110002_640w_640h.jpg",
                "http://s2.cdn.xiachufang.com/2b6a110e88c611e6a9a10242ac110002_1000w_667h.jpg",
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg"
        };

        List<ProductMes> mDatas = new ArrayList<>();
        for (int i = 0; i < imageList.length; i++) {
            mDatas.add(new ProductMes(imageList[i], "测试数据" + i));
        }

        AlerDialogUtils.rightMorePopupWindow(mContext, mDatas, view, new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("点击了" + position);
            }
        });
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<CustomRadarChart.RadarEntry> radarEntries = new ArrayList<>();
        radarEntries.add(0, new CustomRadarChart.RadarEntry("发育", 35.3f));
        radarEntries.add(1, new CustomRadarChart.RadarEntry("推进", 43.1f));
        radarEntries.add(2, new CustomRadarChart.RadarEntry("生存", 57.9f));
        radarEntries.add(3, new CustomRadarChart.RadarEntry("输出", 34.3f));
        radarEntries.add(4, new CustomRadarChart.RadarEntry("综合", 41.4f));
        radarEntries.add(5, new CustomRadarChart.RadarEntry("KDA", 47.7f));
        customRadarChart.setRadatEntries(radarEntries);
    }

    @Override
    protected void setListener() {

    }


}
