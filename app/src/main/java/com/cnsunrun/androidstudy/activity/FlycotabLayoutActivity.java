package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.fragment.AllFragment;
import com.cnsunrun.androidstudy.fragment.RecommendFragment;
import com.cnsunrun.androidstudy.widgtet.NoScrollViewPager;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlycotabLayoutActivity extends FragmentActivity {
    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tab_layout)
    SegmentTabLayout tabLayout;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    private String[] titles = {"推荐设置", "全部设置"};
    private List<Fragment> fragments = new ArrayList<>();
    private TitlePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flycotab_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("FlycotabLayout的练习");
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

    @OnClick(R.id.iv_arrow_back)
    public void onViewClicked() {
        finish();
    }
}
