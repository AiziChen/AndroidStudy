package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.fragment.TabLayoutFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

/**
 * 折叠控件
 */
public class MapActivity extends BaseActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.coordinatortablayout)
    CoordinatorTabLayout coordinatortablayout;
    private ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"任务详情", "查看评价", "个人信息", "个人相册"};
    private int[] mImageArray, mColorArray;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
    }


    @Override
    protected void bindViews() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(TabLayoutFragment.newInstance(title));
        }
        vp.setAdapter(new TitlePagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
        vp.setOffscreenPageLimit(4);
        mImageArray = new int[]{
                R.drawable.ic_image01,
                R.drawable.ic_image02,
                R.drawable.ic_image01,
                R.drawable.ic_image02,
        };
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};
        coordinatortablayout.setTransulcentStatusBar(this)
                .setTitle("折叠控件")
                .setBackEnable(true)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(vp);
    }

    @Override
    protected void setListener() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
