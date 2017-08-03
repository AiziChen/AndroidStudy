package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseFragment;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect:  更多的fragment
 */

public class MoreOtherFragment extends BaseFragment {
    private ListView listView;

    private String[] titles = {"自定义星级评分条"};

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

                        break;
                    case 1:


                        break;
                }
            }
        });
    }
}
