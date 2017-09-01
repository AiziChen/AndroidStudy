package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.CridViewAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.utils.LoadDialog;
import com.cnsunrun.androidstudy.widgtet.ImageHolderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * RecyclerViewAddHeader
 */
public class RecyclerViewAddHeader extends SwipeBackActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.reflayout)
    SwipeRefreshLayout reflayout;
    private List<ProductMes> mDatas = new ArrayList<>();
    private CridViewAdapter adapter;
    private List<String> ImageDatas = new ArrayList<>();
    private TextView tvSearch;
    private ConvenientBanner mBanner;
    View headerView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_recycler_view_add_header);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("给RecyclerView添加头部");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initViewData();
        headerView = View.inflate(mContext, R.layout.include_banner_header, null);
        tvSearch = (TextView) headerView.findViewById(R.id.tvSearch);
        mBanner = (ConvenientBanner) headerView.findViewById(R.id.banner2);
        adapter = new CridViewAdapter(mDatas);
        recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewAddHeader.this));
        adapter.addHeaderView(headerView);
        recyclerview.setAdapter(adapter);
        mBanner.setPages(
                new CBViewHolderCreator<ImageHolderView>() {
                    @Override
                    public ImageHolderView createHolder() {
                        return new ImageHolderView();
                    }
                }, ImageDatas)
                .setPageIndicator(new int[]{R.drawable.sel_banner_hide, R.drawable.sel_banner_show})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        if (ImageDatas.size() > 1) {
            mBanner.startTurning(ConstantValue.VP_TURN_TIME);
        }

    }

    @Override
    protected void setListener() {
        reflayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reflayout.setRefreshing(false);
            }
        });
        mBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showToast("点击了" + position);
            }
        });
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("点击了搜索");
            }
        });

        recyclerview.addOnItemTouchListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                intent2Activity(SuspensionActivity.class);
            }
        });

    }

    /**
     * 添加数据
     */
    private void initViewData() {
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
        for (int i = 0; i < 4; i++) {
            ImageDatas.add(imageList[i]);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
