package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.fragment.TabLayoutFragment;
import com.cnsunrun.androidstudy.view.TitleBuilder;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomTabLayoutActivity extends BaseActivity {
    @BindView(R.id.tabLayout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private List<Fragment> fragents = new ArrayList<>();
    private String[] title = {"任务详情", "查看评价", "个人信息", "个人相册"};

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_custom_tab_layout);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        TitleBuilder titleBuilder = new TitleBuilder(this);
        titleBuilder.setTitleText("自定义TabLayout");
        titleBuilder.noLeftBack();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        for (int i = 0; i < title.length; i++) {
            fragents.add(TabLayoutFragment.newInstance(title[i]));
        }
        viewpager.setAdapter(new TitlePagerAdapter(getSupportFragmentManager(), fragents, title));
        tabLayout.setViewPager(viewpager);
        viewpager.setOffscreenPageLimit(title.length);
    }

    @Override
    protected void setListener() {
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setCurrentTab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
