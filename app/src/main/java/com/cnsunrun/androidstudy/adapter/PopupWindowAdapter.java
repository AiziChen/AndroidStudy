package com.cnsunrun.androidstudy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;

import java.util.List;

/**
 * Created by ZhouBin on 2017/6/8.
 * Effect:popupwindow的adapter
 */

public class PopupWindowAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public PopupWindowAdapter(List<String> data) {
        super(R.layout.include_popupwindow, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_message, item)
                .addOnClickListener(R.id.checkbox);

    }
}
