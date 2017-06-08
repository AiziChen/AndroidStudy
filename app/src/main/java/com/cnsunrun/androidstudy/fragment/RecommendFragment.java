package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsunrun.androidstudy.R;

/**
 * Created by ZhouBin on 2017/6/8.
 * Effect:  推荐的fragment
 */

public class RecommendFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recommend, null);
        return rootView;
    }
}
