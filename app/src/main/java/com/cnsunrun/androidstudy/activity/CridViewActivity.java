package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.CardViewAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CridViewActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.twinklingLayout)
    TwinklingRefreshLayout refreshLayout;
    private List<ProductMes> mDatas = new ArrayList<>();
    private CardViewAdapter adapter;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_crid_view);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("TwinklingRefreshLayout");

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
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg"
        };
        for (int i = 0; i < imageList.length; i++) {
            mDatas.add(new ProductMes(imageList[i], "测试数据" + i));
        }
        adapter = new CardViewAdapter(mDatas);
        recyclerview.setLayoutManager(new LinearLayoutManager(CridViewActivity.this));
        SinaRefreshView headerView = new SinaRefreshView(this);
        headerView.setArrowResource(R.drawable.arrow);
//        headerView.setTextColor(0xff745D5C);
        refreshLayout.setHeaderView(headerView);
        LoadingView loadingView = new LoadingView(this);
        refreshLayout.setBottomView(loadingView);
        recyclerview.setAdapter(adapter);

    }

    @Override
    protected void setListener() {
        refreshLayout.startRefresh();
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadmore();
                    }
                }, 1000);
            }
        });
    }


}
