package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.actionbar.StatusBarUtils;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.utils.GlideImageLoader;
import com.cnsunrun.androidstudy.view.ArcHeaderView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 圆弧形标题控件
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.header_view)
    ArcHeaderView headerView;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.activity_main)
    FrameLayout activityMain;
    public int mStartColor[];
    public int mEndColor[];
    private List<String> imagesData = new ArrayList<>();

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.start_color), 0);

    }

    @Override
    protected void bindViews() {


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        mStartColor = new int[]{getResources().getColor(R.color.start_color)
                , getResources().getColor(R.color.page1_start_color)
                , getResources().getColor(R.color.page2_start_color)
                , getResources().getColor(R.color.page3_start_color)};
        mEndColor = new int[]{getResources().getColor(R.color.end_color)
                , getResources().getColor(R.color.page1_end_color)
                , getResources().getColor(R.color.page2_end_color)
                , getResources().getColor(R.color.page3_end_color)};
        headerView.setColor(getResources().getColor(R.color.start_color), getResources().getColor(R.color.end_color));
        String[] imageList = {
                "http://s1.cdn.xiachufang.com/bc55fd5aec3911e6bc9d0242ac110002_640w_427h.jpg",
                "http://s1.cdn.xiachufang.com/957171ee064011e7947d0242ac110002_1280w_853h.jpg",
                "http://s2.cdn.xiachufang.com/c7d3fad4876611e6b87c0242ac110003_616w_800h.jpg",
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg"
        };
        for (int i = 0; i < imageList.length; i++) {
            imagesData.add(imageList[i]);
        }
        banner.setImageLoader(new GlideImageLoader())
                .setImages(imagesData)
                .setDelayTime(ConstantValue.VP_TURN_TIME)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start()
                .startAutoPlay();
    }

    @Override
    protected void setListener() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                StatusBarUtils.setColor(MainActivity.this, mStartColor[position], 0);
                headerView.setColor(mStartColor[position], mEndColor[position]);
            }
        });

    }

}
