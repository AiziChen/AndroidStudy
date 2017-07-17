package com.cnsunrun.androidstudy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.utils.BitMapUtils;
import com.cnsunrun.androidstudy.widgtet.RoundImageView;
import com.sunrun.toollibrary.LibFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ZhouBin on 2017/6/8.
 * Effect:  推荐的fragment
 */

public class RecommendFragment extends LibFragment {
    @BindView(R.id.iv_circle_image)
    RoundImageView ivCircleImage;
    @BindView(R.id.iv_roundimage)
    RoundImageView ivRoundimage;


    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_recommend, null);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void bindViews(View view) {

    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {

    }

}
