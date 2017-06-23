package com.cnsunrun.androidstudy.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.utils.BitMapUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by ZhouBin on 2017/6/8.
 * Effect: 全部的fragment
 */

public class AllFragment extends Fragment {

    ImageView ivImageview;
    private BitMapUtils bitMapUtils;

    public static AllFragment newInstance() {
        AllFragment fragment = new AllFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_all, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        ivImageview = (ImageView) rootView.findViewById(R.id.iv_imageview);
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        Bitmap bitmap = bitMapUtils.decodeBitMap(getResources(), R.drawable.ic_image02, width, height);
        Logger.d("bitmap.width=" + bitmap.getWidth() + "=bitmap.height=" + bitmap.getHeight());
        ivImageview.setImageBitmap(bitmap);

    }
}
