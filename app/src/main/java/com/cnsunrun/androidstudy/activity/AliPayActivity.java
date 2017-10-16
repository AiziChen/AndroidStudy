package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.fragment.LeftMenuFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 左侧侧滑菜单
 */
public class AliPayActivity extends BaseActivity {


    @BindView(R.id.titlebar_iv_left)
    CircleImageView titlebarIvLeft;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_ali_pay);
        ButterKnife.bind(this);
//        StatusBarUtil.setColorNoTranslucentForDrawerLayout(this, drawerLayout, 0);

    }

    @Override
    protected void bindViews() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {
        titlebarIvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                LeftMenuFragment fragment = (LeftMenuFragment) getSupportFragmentManager().findFragmentByTag("LEFT");
                fragment.open();
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }


}
