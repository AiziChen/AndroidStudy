package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.utils.GlideImageLoader;
import com.cnsunrun.androidstudy.utils.LoadDialog;
import com.cnsunrun.androidstudy.widgtet.ImageHolderView;
import com.cnsunrun.androidstudy.widgtet.YellowRatingBar;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuspensionActivity extends SwipeBackActivity {

    private static final String TAG = "SuspensionActivity";
    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.ratingBar)
    YellowRatingBar ratingBar;
    @BindView(R.id.tvStar)
    TextView tvStar;
    @BindView(R.id.banner2)
    ConvenientBanner mBanner;
    @BindView(R.id.tvSearch)
    TextView tvSearch2;
    private List<String> mDatas = new ArrayList<>();


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_suspension);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        tvTitle.setText("悬浮栏的练习");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        ratingBar.setRating(4.5f);
        String[] imageList = {
                "http://s1.cdn.xiachufang.com/957171ee064011e7947d0242ac110002_1280w_853h.jpg",
                "http://s2.cdn.xiachufang.com/c7d3fad4876611e6b87c0242ac110003_616w_800h.jpg",
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg",
                "http://s1.cdn.xiachufang.com/3df51d10892e11e6b87c0242ac110003_748w_662h.jpg",
                "http://s2.cdn.xiachufang.com/895d027820d611e7bc9d0242ac110002_1382w_1038h.jpg",
        };
        for (int i = 0; i < imageList.length; i++) {
            mDatas.add(imageList[i]);
        }
        banner.setImageLoader(new GlideImageLoader())
                .setImages(mDatas)
                .setDelayTime(ConstantValue.VP_TURN_TIME)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start()
                .startAutoPlay();
        mBanner.setPages(
                new CBViewHolderCreator<ImageHolderView>() {
                    @Override
                    public ImageHolderView createHolder() {
                        return new ImageHolderView();
                    }
                }, mDatas)
                .setPageIndicator(new int[]{R.drawable.sel_banner_hide, R.drawable.sel_banner_show})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        if (mDatas.size() > 1) {
            mBanner.startTurning(ConstantValue.VP_TURN_TIME);
        }
        mBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showToast("点击了" + position);
            }
        });
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                showToast("点击了" + position);
            }
        });

    }

    @Override
    protected void setListener() {

    }


    @OnClick({R.id.iv_arrow_back, R.id.tv_search, R.id.tvSearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_arrow_back:
                finish();
                break;
            case R.id.tv_search:
                LoadDialog.show(mContext);
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoadDialog.dismiss(mContext);
                    }
                }, 2000);
                showToast("点击了搜索框");
                break;
            case R.id.tvSearch:
                LoadDialog.show(mContext, "加载中");
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoadDialog.dismiss(mContext);
                    }
                }, 2000);
                showToast("点击了搜索框2");
                break;
        }
    }

}
