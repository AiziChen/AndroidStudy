package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseFragment;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect: 联系人的fragment
 */

public class ContactsFragment extends BaseFragment {


    public static  ContactsFragment newInstance() {
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

    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {

    }
}
