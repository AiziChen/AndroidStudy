package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.TitlePagerAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.fragment.ContactsFragment;
import com.cnsunrun.androidstudy.fragment.HomeFragment;
import com.cnsunrun.androidstudy.fragment.MessageFragment;
import com.cnsunrun.androidstudy.fragment.MoreOtherFragment;
import com.cnsunrun.androidstudy.utils.TabEntity;
import com.cnsunrun.androidstudy.widgtet.NoScrollViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;

public class YaSuoImageViewActivity extends BaseActivity {

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
        StatusBarUtil.setColor(this, getResources().getColor(R.color.red));
    }

    @Override
    protected void bindViews() {


    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {
        HiPermission.create(mContext).checkMutiPermission(new PermissionCallback() {
            @Override
            public void onClose() {

            }

            @Override
            public void onFinish() {
                loadFragmentData();
            }

            @Override
            public void onDeny(String permission, int position) {

            }

            @Override
            public void onGuarantee(String permission, int position) {

            }
        });

    }

    private void loadFragmentData() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(MessageFragment.newInstance());
        mFragments.add(ContactsFragment.newInstance());
        mFragments.add(MoreOtherFragment.newInstance());
        viewpager.setAdapter(new TitlePagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
        tabLayout.setTabData(mTabEntities);
        viewpager.setOffscreenPageLimit(mTitles.length);

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
