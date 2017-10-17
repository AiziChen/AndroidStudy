package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.activity.BezierViewPagerActivity;
import com.cnsunrun.androidstudy.activity.CountDownActivity;
import com.cnsunrun.androidstudy.activity.MainActivity;
import com.cnsunrun.androidstudy.activity.SelectImageHeandActivity;
import com.cnsunrun.androidstudy.base.BaseFragment;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect: 联系人的fragment
 */

public class ContactsFragment extends BaseFragment {

    private ListView listView;

    private String[] titles = {
            "自定义星级评分条",
            "BGAQRCode_ZXing",
            "省市区选择",
            "选择更换图像和SwitchButton开关",
    };

    public static ContactsFragment newInstance() {
        ContactsFragment homeFragment = new ContactsFragment();
        Bundle bundle = new Bundle();
        homeFragment.setArguments(bundle);
        return homeFragment;

    }

    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.contacts_fragment, null);
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
                        intent2Activity(MainActivity.class);
                        break;
                    case 1:
                        intent2Activity(BezierViewPagerActivity.class);
                        break;
                    case 2:
                        intent2Activity(CountDownActivity.class);
                        break;
                    case 3:
                        intent2Activity(SelectImageHeandActivity.class);
                        break;
                }
            }
        });

    }
}
