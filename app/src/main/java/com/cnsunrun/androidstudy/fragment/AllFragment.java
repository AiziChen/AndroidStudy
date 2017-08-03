package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.widgtet.NoScrollViewPager;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by ZhouBin on 2017/6/8.
 * Effect: 全部的fragment
 */

public class AllFragment extends Fragment {

    @BindView(R.id.tabLayout)
    SegmentTabLayout tabLayout;
    @BindView(R.id.tabLayout02)
    SegmentTabLayout tabLayout02;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    private String[] mTitles = {"首页", "消息"};
    private String[] mTitles_2 = {"首页", "消息", "联系人"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    public static AllFragment newInstance() {
        AllFragment fragment = new AllFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_all, null);
        ButterKnife.bind(this, rootView);
        initLoadData();
        return rootView;
    }

    private void initLoadData() {
        tabLayout.setTabData(mTitles);
        for (int i = 0; i < mTitles_2.length; i++) {
            mFragments.add(TabLayoutFragment.newInstance(mTitles_2[i]));
        }
        viewpager.setAdapter(new TitlePagerAdapter(getChildFragmentManager(), mFragments, mTitles_2));
        tabLayout02.setTabData(mTitles_2);
        viewpager.setOffscreenPageLimit(mFragments.size());
        tabLayout02.setOnTabSelectListener(new OnTabSelectListener() {
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
