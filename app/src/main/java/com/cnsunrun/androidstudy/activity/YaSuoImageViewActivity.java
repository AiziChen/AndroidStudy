package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.fragment.TabLayoutFragment;
import com.cnsunrun.androidstudy.utils.TabEntity;
import com.cnsunrun.androidstudy.widgtet.NoScrollViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.sunrun.toollibrary.LibActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YaSuoImageViewActivity extends LibActivity {

    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_ya_suo_image_view);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        for (int i = 0; i < mTitles.length; i++) {
            mFragments.add(TabLayoutFragment.newInstance(mTitles[i]));
        }
        viewpager.setAdapter(new TitlePagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
        tabLayout.setTabData(mTabEntities);
        viewpager.setOffscreenPageLimit(mTitles.length);

//        //两位数
//        tabLayout.showMsg(0, 55);
//        tabLayout.setMsgMargin(0, -5, 5);
//
//        //三位数
//        tabLayout.showMsg(1, 100);
//        tabLayout.setMsgMargin(1, -5, 5);
//
//        //设置未读消息红点
//        tabLayout.showDot(2);
//        MsgView rtv_2_2 = tabLayout.getMsgView(2);
//        if (rtv_2_2 != null) {
//            UnreadMsgUtils.setSize(rtv_2_2, CommonUtil.dip2px(mContext, 7.5f));
//        }
//
//        //设置未读消息背景
//        tabLayout.showMsg(3, 5);
//        tabLayout.setMsgMargin(3, 0, 5);
//        MsgView rtv_2_3 = tabLayout.getMsgView(3);
//        if (rtv_2_3 != null) {
//            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
//        }
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

    }

}
