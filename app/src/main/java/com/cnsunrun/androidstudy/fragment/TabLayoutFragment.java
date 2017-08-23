package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.CridViewAdapter;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.sunrun.toollibrary.LibFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhouBin on 2017/7/18.
 * Effect: fragment
 */

public class TabLayoutFragment extends LibFragment {

    private TextView tvTitle;
    private String title;
    private RecyclerView recyclerview;
    private List<ProductMes> mDatas = new ArrayList<>();
    private CridViewAdapter adapter;

    public static TabLayoutFragment newInstance(String title) {
        TabLayoutFragment fragment = new TabLayoutFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstantValue.TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_tablayout, null);
        return rootView;
    }

    @Override
    protected void bindViews(View view) {
        tvTitle = (TextView) view.findViewById(R.id.tv_fragment_title);
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);

    }

    @Override
    protected void processLogic() {
        title = getArguments().getString(ConstantValue.TITLE);
        tvTitle.setText(title + "的Fragment");
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
        adapter = new CridViewAdapter(mDatas);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.VERTICAL, false));

    }

    @Override
    protected void setListener() {

    }
}
