package com.cnsunrun.androidstudy.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;
import com.sunrun.toollibrary.utils.ImageLoaderUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopupWindowActivity extends SwipeBackActivity {


    @BindView(R.id.nineView)
    NineGridView nineView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_popup_window);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        initTitle("九宫格图片展示");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        NineGridView.setImageLoader(new UniversalImageLoader());
        String[] imageList = {
                "http://s1.cdn.xiachufang.com/bc55fd5aec3911e6bc9d0242ac110002_640w_427h.jpg",
                "http://s1.cdn.xiachufang.com/957171ee064011e7947d0242ac110002_1280w_853h.jpg",
                "http://s2.cdn.xiachufang.com/895d027820d611e7bc9d0242ac110002_1382w_1038h.jpg",
                "http://s2.cdn.xiachufang.com/cc808350880a11e6b87c0242ac110003_550w_380h.jpg",
                "http://s1.cdn.xiachufang.com/86a642a68b6c11e6b87c0242ac110003_2080w_1560h.jpg",
                "http://s1.cdn.xiachufang.com/bd54e300886c11e6a9a10242ac110002_640w_640h.jpg",
                "http://s2.cdn.xiachufang.com/2b6a110e88c611e6a9a10242ac110002_1000w_667h.jpg",
                "http://s2.cdn.xiachufang.com/c7d3fad4876611e6b87c0242ac110003_616w_800h.jpg",
                "http://s1.cdn.xiachufang.com/af570278afe611e6bc9d0242ac110002_1280w_962h.jpg"
        };

        ArrayList<ImageInfo> imageInfo = new ArrayList<>();

        for (int i = 0; i < imageList.length; i++) {
            ImageInfo imagesInfo = new ImageInfo();
            imagesInfo.setThumbnailUrl(imageList[i]);
            imagesInfo.setBigImageUrl(imageList[i]);
            imageInfo.add(imagesInfo);
        }
        nineView.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));
    }

    @Override
    protected void setListener() {

    }

    /**
     * UniversalImageLoader加载
     */
    private class UniversalImageLoader implements NineGridView.ImageLoader {
        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            ImageLoaderUtils.displayBigImage(url, imageView);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }

}
