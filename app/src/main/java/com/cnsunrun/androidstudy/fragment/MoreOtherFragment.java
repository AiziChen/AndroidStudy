package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseFragment;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect:  更多的fragment
 */

public class MoreOtherFragment extends BaseFragment {


    public static MoreOtherFragment newInstance() {
        MoreOtherFragment homeFragment = new MoreOtherFragment();
        Bundle bundle = new Bundle();
        homeFragment.setArguments(bundle);
        return homeFragment;

    }


    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.moreother_fragment, null);

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
