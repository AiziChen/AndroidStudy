package com.cnsunrun.androidstudy.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.ChooseImageAdapter;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.LubanOptions;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.model.TakePhotoOptions;
import com.sunrun.toollibrary.utils.CommonUtil;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 图片选择
 */
public class ChooseImageActivity extends TakePhotoActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private final int TYPE_CALEAM = 1;
    private final int TYPE_AULBAM = 2;
    //返回的图片集合
    private ArrayList<TImage> images = new ArrayList<>();
    private int GET_DATA_SUCCESS = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);
        ButterKnife.bind(this);
    }


    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        images=result.getImages();
        recyclerview.setAdapter(new ChooseImageAdapter(images));
        recyclerview.setLayoutManager(new GridLayoutManager(ChooseImageActivity.this, LinearLayout.VERTICAL, 2, false));
    }


    @Override
    public void takeCancel() {
        super.takeCancel();
        //取消
    }

    @Override
    public void takeFail(TResult result, String msg) {
        //失败
        super.takeFail(result, msg);
    }


    @OnClick({R.id.iv_arrow_back, R.id.tv_aulbame, R.id.tv_cancml})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_arrow_back:
                finish();
                break;
            case R.id.tv_aulbame:
                //相册获取

//                getImageViews(view, getTakePhoto(), TYPE_AULBAM);

                break;

            case R.id.tv_cancml:
                //拍照获取
//                getImageViews(view, getTakePhoto(), TYPE_CALEAM);
                break;
        }
    }


    private void getImageViews(View view, TakePhoto takePhoto, int type_aulbam) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        int maxSize = 9;
        int width = CommonUtil.dip2px(this, 100);
        int height = CommonUtil.dip2px(this, 100);
        boolean showProgressBar = true;
        boolean enableRawFile = true;
        CompressConfig config;
        LubanOptions option = new LubanOptions.Builder()
                .setMaxHeight(height)
                .setMaxWidth(width)
                .setMaxSize(maxSize)
                .create();
        config = CompressConfig.ofLuban(option);
        config.enableReserveRaw(enableRawFile);
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        builder.setWithOwnGallery(true);
        builder.setCorrectImage(true);
        takePhoto.setTakePhotoOptions(builder.create());
        takePhoto.onEnableCompress(config, showProgressBar);
        if (type_aulbam == 1) {//拍照
            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
        } else {//相册
            takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
        }
    }

    //裁剪
    private CropOptions getCropOptions() {
        int height = CommonUtil.dip2px(this, 80);
        int width = CommonUtil.dip2px(this, 80);
        boolean withWonCrop = true;
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setOutputX(width).setOutputY(height);
        builder.setWithOwnCrop(withWonCrop);
        return builder.create();
    }
}
