package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.HorizontalViewAdapter;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.SelectItemDailog;
import com.cnsunrun.androidstudy.utils.SelectMoreTypeDailog;
import com.cnsunrun.androidstudy.widgtet.DividerGridItemDecoration;
import com.sunrun.toollibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectDialogActivity extends SwipeBackActivity {


    @BindView(R.id.tv_type_one)
    TextView tvTypeOne;
    @BindView(R.id.tv_type_two)
    TextView tvTypeTwo;
    @BindView(R.id.tv_type_three)
    TextView tvTypeThree;
    private RecyclerView recyclerView;

    List<String> imageData = new ArrayList<>();
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
        setContentView(R.layout.activity_select_dialog);

        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("自定以Dialog");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        for (int i = 0; i < imageList.length; i++) {
            imageData.add(imageList[i]);
        }
    }

    @Override
    protected void setListener() {

    }

    private void showTypeOneDialog() {

        final SelectItemDailog selDialog = new SelectItemDailog(mContext);
        selDialog.setPhotoAlbumsListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("点击了相册获取");
                selDialog.dismiss();
            }
        });
        selDialog.setTakePicturesListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("点击了拍照");
                selDialog.dismiss();
            }
        });

    }

    @OnClick({R.id.tv_type_one, R.id.tv_type_two, R.id.tv_type_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_type_one:
                showTypeOneDialog();
                break;
            case R.id.tv_type_two:
                showTypeTwo();
                break;
            case R.id.tv_type_three:
                recyclerView.setAdapter(new HorizontalViewAdapter(imageData));
//                recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false));
//                recyclerView.addItemDecoration(new DivideLineItemDecoration(mContext, LinearLayout.HORIZONTAL, getResources().getColor(R.color.red), 1));
                recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
                recyclerView.addItemDecoration(new DividerGridItemDecoration(mContext, getResources().getColor(R.color.red), 1));
                break;
        }
    }

    private void showTypeTwo() {
        final List<String> mData = Arrays.asList("语文", "数学", "英语", "物理", "化学", "生物", "政治");
        new SelectMoreTypeDailog(mContext, mData, new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("点击了" + mData.get(position));
            }
        });

    }
}
