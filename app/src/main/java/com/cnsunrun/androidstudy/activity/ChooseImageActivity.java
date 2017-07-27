package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.fragment.TabLayoutFragment;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 图片选择
 */
public class ChooseImageActivity extends SwipeBackActivity {


    @BindView(R.id.collapsingtoolbarlayout)
    CollapsingToolbarLayout collapsingtoolbarlayout;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.vp)
    ViewPager vp;
    Banner banner;
    private String[] title = {"任务详情", "查看评价", "个人信息", "个人相册"};
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> imagesData = new ArrayList<>();


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_choose_image);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        banner = (Banner) findViewById(R.id.banner);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String[] imageList = {
                "http://s1.cdn.xiachufang.com/bc55fd5aec3911e6bc9d0242ac110002_640w_427h.jpg",
                "http://s1.cdn.xiachufang.com/957171ee064011e7947d0242ac110002_1280w_853h.jpg",
                "http://s2.cdn.xiachufang.com/c7d3fad4876611e6b87c0242ac110003_616w_800h.jpg",
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg"
        };
        for (int i = 0; i < imageList.length; i++) {
            imagesData.add(imageList[i]);
        }
        for (int i = 0; i < title.length; i++) {
            mFragments.add(TabLayoutFragment.newInstance(title[i]));
        }
        vp.setAdapter(new TitlePagerAdapter(getSupportFragmentManager(), mFragments, title));
        tabLayout.setupWithViewPager(vp);
        vp.setOffscreenPageLimit(title.length);
        banner.setImageLoader(new GlideImageLoader())
                .setImages(imagesData)
                .setDelayTime(ConstantValue.VP_TURN_TIME)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start()
                .startAutoPlay();

    }

    @Override
    protected void setListener() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                showToast("点击了" + position);

            }
        });

    }

}
