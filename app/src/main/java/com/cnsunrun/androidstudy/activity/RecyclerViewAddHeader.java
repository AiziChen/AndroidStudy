package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.CridGameLoveAdapter;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.model.ProductMes;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * RecyclerViewAddHeader
 */
public class RecyclerViewAddHeader extends SwipeBackActivity {


    @BindView(R.id.tv_type_one)
    TextView tvTypeOne;
    @BindView(R.id.tv_type_two)
    TextView tvTypeTwo;
    @BindView(R.id.tv_type_three)
    TextView tvTypeThree;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<ProductMes> productMesList = new ArrayList<>();


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_recycler_view_add_header);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        initTitle("给RecyclerView添加头部");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        initViewData();

    }

    @Override
    protected void setListener() {

    }

    /**
     * 添加数据
     */
    private void initViewData() {

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
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg"
        };

        for (int i = 0; i < imageList.length; i++) {
            productMesList.add(new ProductMes(imageList[i], "标题" + i));
        }
        CridGameLoveAdapter adapter = new CridGameLoveAdapter(productMesList);
        recyclerView.setLayoutManager(new OverLayCardLayoutManager());
        recyclerView.setAdapter(adapter);
        CardConfig.initConfig(this);
        ItemTouchHelper.Callback callback = new RenRenCallback(recyclerView, adapter, productMesList);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    @OnClick({R.id.tv_type_one, R.id.tv_type_two, R.id.tv_type_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_type_one:
                showTypeOne();
                break;
            case R.id.tv_type_two:
                showTypeTwo();
                break;
            case R.id.tv_type_three:
                showTypeThree();
                break;
        }
    }

    private void showTypeOne() {

    }

    private void showTypeTwo() {

    }

    private void showTypeThree() {


    }
}
