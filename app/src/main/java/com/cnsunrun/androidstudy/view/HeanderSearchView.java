package com.cnsunrun.androidstudy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZhouBin on 2017/8/28.
 * Effect: 搜索栏渐变的view
 */

public class HeanderSearchView extends FrameLayout {
    @BindView(R.id.banner)
    Banner banner;

    public HeanderSearchView(Context context) {
        this(context, null);
    }

    public HeanderSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeanderSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.search_henader_view, this);
        ButterKnife.bind(this);

    }

    /**
     * 设置banner的数据
     *
     * @param mDatas
     */
    public void setBannerData(List<String> mDatas) {
        banner.setImageLoader(new GlideImageLoader())
                .setImages(mDatas)
                .setDelayTime(ConstantValue.VP_TURN_TIME)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start()
                .startAutoPlay();

    }

}
