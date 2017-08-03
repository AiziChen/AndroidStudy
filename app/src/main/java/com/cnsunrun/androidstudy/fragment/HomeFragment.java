package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.activity.AliPayActivity;
import com.cnsunrun.androidstudy.activity.ChooseImageActivity;
import com.cnsunrun.androidstudy.activity.CridViewActivity;
import com.cnsunrun.androidstudy.activity.CustomTabLayoutActivity;
import com.cnsunrun.androidstudy.activity.DropdownSelectActivity;
import com.cnsunrun.androidstudy.activity.FlycotabLayoutActivity;
import com.cnsunrun.androidstudy.activity.MainActivity;
import com.cnsunrun.androidstudy.activity.MapActivity;
import com.cnsunrun.androidstudy.activity.PopupWindowActivity;
import com.cnsunrun.androidstudy.activity.RecyclerViewAddHeader;
import com.cnsunrun.androidstudy.activity.ScrollViewAndRecyclerView;
import com.cnsunrun.androidstudy.activity.StreamingActivity;
import com.cnsunrun.androidstudy.activity.SuspensionActivity;
import com.cnsunrun.androidstudy.activity.YaSuoImageViewActivity;
import com.cnsunrun.androidstudy.base.BaseFragment;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect:  首页的Fragment
 */

public class HomeFragment extends BaseFragment {

    private ListView listView;

    private String[] titles = {
            "TwinklingRefreshLayout的刷新",
            "流式布局和微信群聊图像展示",
            "FlycotabLayout的练习",
            "选择Window的对话框",
            "搜索栏悬浮",
            "高德地图的练习",
            "RececlerView添加Banner头部",
            "自定义的TabLayout",
            "CommonTabLayout",
            "置吸附置顶的TabLayout",
            "输入密码框",
            "九宫格显示图片",
            "对于控件操作的封装"
    };

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.home_fragment, null);

        return rootView;
    }

    @Override
    protected void bindViews(View view) {
        listView = (ListView) view.findViewById(R.id.listView);

    }

    @Override
    protected void processLogic() {
        listView.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, titles));

    }

    @Override
    protected void setListener() {


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent2Activity(CridViewActivity.class);
                        break;
                    case 1:
                        intent2Activity(StreamingActivity.class);
                        break;
                    case 2:
                        intent2Activity(FlycotabLayoutActivity.class);
                        break;
                    case 3:
                        intent2Activity(DropdownSelectActivity.class);
                        break;
                    case 4:
                        intent2Activity(SuspensionActivity.class);
                        break;
                    case 5:
                        intent2Activity(MapActivity.class);
                        break;
                    case 6:
                        intent2Activity(RecyclerViewAddHeader.class);
                        break;
                    case 7:
                        intent2Activity(CustomTabLayoutActivity.class);
                        break;
                    case 8:
                        intent2Activity(MainActivity.class);
                        break;
                    case 9:
                        intent2Activity(ChooseImageActivity.class);
                        break;
                    case 10:
                        intent2Activity(ScrollViewAndRecyclerView.class);
                        break;
                    case 11:
                        intent2Activity(PopupWindowActivity.class);
                        break;
                    case 12:
                        intent2Activity(AliPayActivity.class);
                        break;
                }
            }
        });

    }
}
