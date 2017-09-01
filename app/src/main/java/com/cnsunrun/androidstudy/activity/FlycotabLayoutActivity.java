package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.fragment.AllFragment;
import com.cnsunrun.androidstudy.fragment.RecommendFragment;
import com.cnsunrun.androidstudy.view.TitleBuilder;
import com.cnsunrun.androidstudy.widgtet.NoScrollViewPager;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlycotabLayoutActivity extends SwipeBackActivity {
    @BindView(R.id.tab_layout)
    SegmentTabLayout tabLayout;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    private String[] titles = {"推荐设置", "全部设置"};
    private List<Fragment> fragments = new ArrayList<>();
    private TitlePagerAdapter adapter;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_flycotab_layout);
        ButterKnife.bind(this);


    }

    @Override
    protected void bindViews() {
        initTitle("SegmentTabLayout的使用");
        TitleBuilder titleBuilder = new TitleBuilder(this);
        titleBuilder.setLeftText(null);
        initView();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    private void initView() {

        for (int i = 0; i < titles.length; i++) {
            fragments.add(new RecommendFragment());
            fragments.add(new AllFragment());
        }
        adapter = new TitlePagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(fragments.size());
        tabLayout.setTabData(titles);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

}
