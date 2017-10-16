package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.GridViewAdapter;
import com.cnsunrun.androidstudy.adapter.ViewPagerAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.sunrun.toollibrary.utils.CommonUtil;
import com.sunrun.toollibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 仿美团的更多分类功能
 */
public class MoreClassificationActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.ll_dot)
    LinearLayout llDot;
    private List<ProductMes> mDatas = new ArrayList<>();
    // 总的页数
    private int pageCount;
    // 每一页显示的个数
    private int pageSize = 10;
    // 当前显示的是第几页
    private int curIndex = 0;
    private List<View> mPagerList;
    private LayoutInflater inflater;
    //存放点点的数组
    private ImageView[] tips;
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
            "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg",
            "http://s1.cdn.xiachufang.com/86a642a68b6c11e6b87c0242ac110003_2080w_1560h.jpg",
            "http://s2.cdn.xiachufang.com/545a04f4845f11e6b87c0242ac110003_1080w_1080h.jpg",
            "http://s1.cdn.xiachufang.com/3df51d10892e11e6b87c0242ac110003_748w_662h.jpg",
            "http://s2.cdn.xiachufang.com/bb945bbc3ac911e7bc9d0242ac110002_429w_640h.jpg",
            "http://s1.cdn.xiachufang.com/bd54e300886c11e6a9a10242ac110002_640w_640h.jpg",
    };

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_more_classification);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        initTitle("仿美团的分类");
        for (int i = 0; i < imageList.length; i++) {
            mDatas.add(new ProductMes(imageList[i], "数据" + i));
        }
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        inflater = LayoutInflater.from(this);
        //总的页数=总数/每页数量，并取整
        pageCount = (int) Math.ceil(mDatas.size() * 1.0 / pageSize);
        mPagerList = new ArrayList<View>();
        for (int i = 0; i < pageCount; i++) {
            // 每个页面都是inflate出一个新实例
            GridView gridView = (GridView) inflater.inflate(R.layout.gridview_of_class, viewpager, false);
            gridView.setAdapter(new GridViewAdapter(this, mDatas, i, pageSize));
            mPagerList.add(gridView);
            //点击事件
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int pos = position + curIndex * pageSize;
                    ToastUtils.showToast("点击了第" + curIndex + "页的" + mDatas.get(pos).getProductMes());
                }
            });
        }
        //设置适配器
        viewpager.setAdapter(new ViewPagerAdapter(mPagerList));
        //装点点的数组
        tips = new ImageView[pageCount];
        int width = CommonUtil.dip2px(mContext, 10);
        int height = CommonUtil.dip2px(mContext, 10);
        for (int i = 0; i < tips.length; i++) {
            ImageView imageview = new ImageView(mContext);
            imageview.setLayoutParams(new LinearLayout.LayoutParams(width, height));
            tips[i] = imageview;
            //默认第一个是选中的
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.sel_banner_show);
            } else {
                tips[i].setBackgroundResource(R.drawable.sel_banner_hide);
            }
            //创建一个线性布局
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            layoutParams.rightMargin = width;
            //将view添加进去
            llDot.addView(imageview, layoutParams);
        }
    }


    @Override
    protected void setListener() {
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                llDot.getChildAt(curIndex).setBackgroundResource(R.drawable.sel_banner_hide);
                llDot.getChildAt(position).setBackgroundResource(R.drawable.sel_banner_show);
                curIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
