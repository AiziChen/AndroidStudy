package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.SpreadsDeleteAdapter;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.cnsunrun.androidstudy.view.HeanderSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 侧滑删除
 */
public class SpreadsDeleteActivity extends SwipeBackActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.reflayout)
    SwipeRefreshLayout reflayout;
    @BindView(R.id.ic_home_mycenter)
    ImageView icHomeMycenter;
    @BindView(R.id.tv_localize_address)
    TextView tvLocalizeAddress;
    @BindView(R.id.ll_home_local)
    RelativeLayout llHomeLocal;
    @BindView(R.id.iv_home_search)
    ImageView ivHomeSearch;
    @BindView(R.id.rl_home_title_ber)
    RelativeLayout rlHomeTitleBer;
    @BindView(R.id.ll_home_search_me_view)
    LinearLayout llHomeSearchMeView;
    @BindView(R.id.activity_spreads_delete)
    FrameLayout activitySpreadsDelete;
    private List<ProductMes> mDatas = new ArrayList<>();
    private SpreadsDeleteAdapter spreadsDeleteAdapter;
    private List<String> bannerData = new ArrayList<>();

    private HeanderSearchView heanderSearchView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_spreads_delete);
        ButterKnife.bind(this);


    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String[] imageList = {
                "http://s1.cdn.xiachufang.com/bc55fd5aec3911e6bc9d0242ac110002_640w_427h.jpg",
                "http://s1.cdn.xiachufang.com/957171ee064011e7947d0242ac110002_1280w_853h.jpg",
                "http://s2.cdn.xiachufang.com/272b974e8b2211e6b87c0242ac110003_2000w_2000h.jpg",
                "http://s2.cdn.xiachufang.com/288dacb48b2a11e6b87c0242ac110003_1080w_1468h.jpg",
                "http://s2.cdn.xiachufang.com/895d027820d611e7bc9d0242ac110002_1382w_1038h.jpg",
                "http://s2.cdn.xiachufang.com/cc808350880a11e6b87c0242ac110003_550w_380h.jpg",
                "http://s2.cdn.xiachufang.com/d506d4f8123d11e7bc9d0242ac110002_1280w_853h.jpg",
                "http://s1.cdn.xiachufang.com/86a642a68b6c11e6b87c0242ac110003_2080w_1560h.jpg",
                "http://s2.cdn.xiachufang.com/545a04f4845f11e6b87c0242ac110003_1080w_1080h.jpg",
                "http://s1.cdn.xiachufang.com/3df51d10892e11e6b87c0242ac110003_748w_662h.jpg",
                "http://s2.cdn.xiachufang.com/bb945bbc3ac911e7bc9d0242ac110002_429w_640h.jpg",
                "http://s1.cdn.xiachufang.com/bd54e300886c11e6a9a10242ac110002_640w_640h.jpg",
                "http://s2.cdn.xiachufang.com/2b6a110e88c611e6a9a10242ac110002_1000w_667h.jpg",
                "http://s2.cdn.xiachufang.com/c7d3fad4876611e6b87c0242ac110003_616w_800h.jpg",
                "http://s2.cdn.xiachufang.com/d506d4f8123d11e7bc9d0242ac110002_1280w_853h.jpg",
                "http://s1.cdn.xiachufang.com/86a642a68b6c11e6b87c0242ac110003_2080w_1560h.jpg",
                "http://s2.cdn.xiachufang.com/545a04f4845f11e6b87c0242ac110003_1080w_1080h.jpg",
                "http://s1.cdn.xiachufang.com/3df51d10892e11e6b87c0242ac110003_748w_662h.jpg",
                "http://s2.cdn.xiachufang.com/bb945bbc3ac911e7bc9d0242ac110002_429w_640h.jpg",
                "http://s1.cdn.xiachufang.com/bd54e300886c11e6a9a10242ac110002_640w_640h.jpg",
                "http://s2.cdn.xiachufang.com/2b6a110e88c611e6a9a10242ac110002_1000w_667h.jpg",
                "http://s2.cdn.xiachufang.com/c7d3fad4876611e6b87c0242ac110003_616w_800h.jpg",
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg"
        };
        for (int i = 0; i < imageList.length; i++) {
            mDatas.add(new ProductMes(imageList[i], "测试数据" + i));
        }
        for (int i = 0; i < 4; i++) {
            bannerData.add(imageList[i]);
        }
        spreadsDeleteAdapter = new SpreadsDeleteAdapter(mDatas);
        recyclerview.setAdapter(spreadsDeleteAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.VERTICAL, false));

        heanderSearchView = new HeanderSearchView(mContext);

        spreadsDeleteAdapter.addHeaderView(heanderSearchView);

        heanderSearchView.setBannerData(bannerData);

    }

    int mDistanceY;

    @Override
    protected void setListener() {
        reflayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reflayout.setRefreshing(false);
            }
        });
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //滑动的距离
                mDistanceY += dy;
                //上方图片的高度
                int headHeight = heanderSearchView.getHeight();
                if (mDistanceY < headHeight) {
                    //滑动距离小于上方图片的1/2时，设置白色搜索按钮，透明度从0-255
                    if (mDistanceY < headHeight / 2) {
                        llHomeSearchMeView.setBackgroundColor(getResources().getColor(R.color.white_30));
                        float scale = (float) mDistanceY / (headHeight / 2);
                        float alpha = scale * 255;
                        llHomeSearchMeView.getBackground().setAlpha((int) alpha);
                    } else {//滑动距离大于上方图片的1/2并小于上方图片时，设置黑色搜索按钮，透明度从0-255
                        llHomeSearchMeView.setBackgroundColor(getResources().getColor(R.color.green_a7dc57));
                        float scale = (float) (mDistanceY - headHeight / 2) / (headHeight / 2);
                        float alpha = scale * 255;
                        llHomeSearchMeView.getBackground().setAlpha((int) alpha);
                    }
                } else {
                    //当快速往下滑时，llSearch最后设置的alpha不约等于255，测试的为132,所以要再设置
                    llHomeSearchMeView.setBackgroundColor(getResources().getColor(R.color.green_color));
                    llHomeSearchMeView.getBackground().setAlpha(255);
                }
            }
        });

    }

    @OnClick({R.id.ic_home_mycenter, R.id.tv_localize_address, R.id.ll_home_local, R.id.iv_home_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ic_home_mycenter:
                break;
            case R.id.tv_localize_address:
                break;
            case R.id.ll_home_local:
                break;
            case R.id.iv_home_search:
                break;
        }
    }

}