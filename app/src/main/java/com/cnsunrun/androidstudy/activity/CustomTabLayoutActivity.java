package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.fragment.AllFragment;
import com.cnsunrun.androidstudy.fragment.RecommendFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.sunrun.toollibrary.LibActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomTabLayoutActivity extends LibActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
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
        tvTitle.setText("自定义TabLayout");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        for (int i = 0; i < title.length; i++) {
            fragents.add(new RecommendFragment());
        }
        viewpager.setAdapter(new TitlePagerAdapter(getSupportFragmentManager(), fragents, title));
        tabLayout.setViewPager(viewpager);
        viewpager.setOffscreenPageLimit(title.length);

    }

    @Override
    protected void setListener() {

    }


    @OnClick(R.id.iv_arrow_back)
    public void onViewClicked() {
        finish();
    }
}
