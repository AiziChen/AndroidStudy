package com.cnsunrun.androidstudy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.model.ContantBean;

import java.util.List;

/**
 * Created by ZhouBin on 2017/9/11.
 * Effect: 联系人的adapter
 */

public class ContantsAdapter extends BaseQuickAdapter<ContantBean, BaseViewHolder> {
    public ContantsAdapter(List<ContantBean> data) {
        super(R.layout.item_contant_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContantBean item) {
        helper.setText(R.id.tv_chair, item.getFirstChair())
                .setText(R.id.tv_name, item.getPersonName());

    }
}
