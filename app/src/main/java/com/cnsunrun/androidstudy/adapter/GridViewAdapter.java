package com.cnsunrun.androidstudy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.sunrun.toollibrary.utils.ImageLoaderUtils;

import java.util.List;

/**
 * Created by ZhouBin on 2017/8/4.
 * Effect:   gridView的adapter
 */

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<ProductMes> productMes;
    //     * 页数下标,从0开始(当前是第几页)
    private int curIndex;
    //     * 每一页显示的个数
    private int pageSize;

    public GridViewAdapter(Context context, List<ProductMes> productMes, int curIndex, int pageSize) {
        this.context = context;
        this.productMes = productMes;
        this.curIndex = curIndex;
        this.pageSize = pageSize;
    }

    @Override
    public int getCount() {
        return productMes.size() > (curIndex + 1) * pageSize ? pageSize : (productMes.size() - curIndex * pageSize);

    }

    @Override
    public Object getItem(int position) {
        return productMes.get(position + curIndex * pageSize);
    }

    @Override
    public long getItemId(int position) {
        return position + curIndex * pageSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gridview, null);
            holder.ivImage = (ImageView) convertView.findViewById(R.id.iv_class_image);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_class_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        int pos = position + curIndex * pageSize;
        holder.tvName.setText(productMes.get(pos).getProductMes());
        ImageLoaderUtils.displayAvatar(productMes.get(pos).getImageUrl(), holder.ivImage);
        return convertView;
    }

    class ViewHolder {
        ImageView ivImage;
        TextView tvName;
    }

}
