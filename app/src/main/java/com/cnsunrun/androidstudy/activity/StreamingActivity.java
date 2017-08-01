package com.cnsunrun.androidstudy.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.NineGridImageViewAdapter;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.view.NineGridImageView;
import com.sunrun.toollibrary.utils.ImageLoaderUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 流式布局
 */
public class StreamingActivity extends SwipeBackActivity {

    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;
    @BindView(R.id.nineView01)
    NineGridImageView nineView01;
    @BindView(R.id.nineView02)
    NineGridImageView nineView02;
    @BindView(R.id.nineView03)
    NineGridImageView nineView03;
    @BindView(R.id.nineView04)
    NineGridImageView nineView04;
    @BindView(R.id.nineView05)
    NineGridImageView nineView05;
    private List<String> mVals = new ArrayList<>();


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_streaming);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initView();
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

        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        List<String> listThree = new ArrayList<>();
        List<String> listFour = new ArrayList<>();
        List<String> listFive = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            listOne.add(imageList[i]);
        }
        for (int i = 0; i < 5; i++) {
            listTwo.add(imageList[i]);
        }
        for (int i = 0; i < 6; i++) {
            listThree.add(imageList[i]);
        }
        for (int i = 0; i < 7; i++) {
            listFour.add(imageList[i]);
        }
        for (int i = 0; i < 9; i++) {
            listFive.add(imageList[i]);
        }

        NineGridImageViewAdapter<String> mAdapter = new NineGridImageViewAdapter<String>() {
            @Override
            public void onDisplayImage(Context context, ImageView imageView, String url) {
                ImageLoaderUtils.displayBigImage(url, imageView);
            }

            @Override
            public ImageView generateImageView(Context context) {
                return super.generateImageView(context);
            }
        };
        nineView01.setAdapter(mAdapter);
        nineView01.setImagesData(listOne);

        nineView02.setAdapter(mAdapter);
        nineView02.setImagesData(listTwo);

        nineView03.setAdapter(mAdapter);
        nineView03.setImagesData(listThree);

        nineView04.setAdapter(mAdapter);
        nineView04.setImagesData(listFour);

        nineView05.setAdapter(mAdapter);
        nineView05.setImagesData(listFive);

    }

    @Override
    protected void setListener() {

    }

    /**
     * 初始化控件
     */
    private void initView() {
        tvTitle.setText("流式布局");
        mVals.add("三星");
        mVals.add("华为");
        mVals.add("华为荣耀");
        mVals.add("中兴");
        mVals.add("联想联想niu");
        mVals.add("ViVoViVoViVo");
        mVals.add("oppo");
        mVals.add("苹果");
        mVals.add("金立M6Plus");
        mVals.add("魅族魅族");
        mVals.add("朵唯");
        mVals.add("索尼");

        idFlowlayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, final String s) {
                final TextView textView = (TextView) View.inflate(StreamingActivity.this, R.layout.include_textview, null);
                textView.setText(s);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(StreamingActivity.this, "点击了" + s, Toast.LENGTH_LONG).show();
                    }
                });
                return textView;
            }
        });
    }

    @OnClick(R.id.iv_arrow_back)
    public void onViewClicked() {
        finish();
    }
}
