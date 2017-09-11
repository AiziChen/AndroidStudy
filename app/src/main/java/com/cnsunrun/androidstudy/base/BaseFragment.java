package com.cnsunrun.androidstudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsunrun.androidstudy.view.TitleBuilder;
import com.sunrun.toollibrary.LibFragment;
import com.sunrun.toollibrary.utils.ToastUtils;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect:fragment的基类
 */

public abstract class BaseFragment extends LibFragment {

    public TitleBuilder initTitle(Object obj) {
        if (obj instanceof String) {
            return new TitleBuilder(rootView).setTitleText((String) obj);
        } else {
            return new TitleBuilder(rootView).setTitleText((int) obj);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void onVisible() {
        super.onVisible();
    }


    protected void showToast(String text){
        if(!TextUtils.isEmpty(text)){
            ToastUtils.showToast(text);
        }
    }

}
