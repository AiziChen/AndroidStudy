package com.cnsunrun.androidstudy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;

import java.util.List;

/**
 * Created by ZhouBin on 2017/8/22.
 * Effect:选择类别的adapter
 */

public class SelectTypeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SelectTypeAdapter(List<String> data) {
        super(R.layout.item_select_type, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_select_type, item);

    }
}
