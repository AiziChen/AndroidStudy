package com.cnsunrun.androidstudy.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.utils.AlerDialogUtils;
import com.cnsunrun.androidstudy.utils.SelectItemDailog;
import com.sunrun.toollibrary.utils.CommonUtil;
import com.sunrun.toollibrary.utils.FileUtils;
import com.sunrun.toollibrary.utils.PhotoUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 更换用户图像
 */
public class SelectImageHeandActivity extends BaseActivity {

    private static final String TAG = "SelectImageHeandActivit";
    @BindView(R.id.tv_select_type)
    TextView tvSelectType;
    @BindView(R.id.civ_image_photo)
    CircleImageView civImagePhoto;
    private Uri imageUri;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_heand);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("更换用户图像和SwitchButton");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }


    @OnClick(R.id.tv_select_type)
    public void onViewClicked() {
        AlerDialogUtils.SelectItemDailog(mContext, new SelectItemDailog.OnButtonClickListener() {
            @Override
            public void selectItemOne() {
                //相册
                PhotoUtils.pickImageFromAlbum(SelectImageHeandActivity.this);
            }

            @Override
            public void selectItemTwo() {
                //拍照
                PhotoUtils.pickImageFromCamera(SelectImageHeandActivity.this);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PhotoUtils.REQUEST_CODE_FROM_ALBUM:   //相册
                if (resultCode == Activity.RESULT_CANCELED) {
                    return;
                }
                String path = PhotoUtils.getImageAbsolutePath(this, data.getData());
                Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(path));
                startPhotoZoom(uri);
                break;
            case PhotoUtils.REQUEST_CODE_FROM_CAMERA:  //拍照
                if (resultCode == Activity.RESULT_CANCELED) {
                    PhotoUtils.deleteImageUri(this, PhotoUtils.imageUriFromCamera);
                } else {
                    startPhotoZoom(PhotoUtils.imageUriFromCamera);  //裁剪
                }
                break;
            case PhotoUtils.REQUEST_CODE_CROP_PICTURE:  //裁剪完成
                if (resultCode == Activity.RESULT_CANCELED) {
                    return;
                }
                String imagePath = PhotoUtils.getImageAbsolutePath(this, imageUri);
                if (!TextUtils.isEmpty(imagePath)) {
                    File file = new File(imagePath);
                    Glide.with(this).load("file://" + imagePath).into(civImagePhoto);
                }
                break;
        }
    }

    /**
     *  * 裁剪图片方法实现
     *  * @param uri
     *  
     */
    public void startPhotoZoom(Uri sourceUri) {
        int size = CommonUtil.dip2px(this, 200);
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(sourceUri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", size);
        intent.putExtra("outputY", size);
        imageUri = Uri.fromFile(FileUtils.getCropFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("return-data", false);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, PhotoUtils.REQUEST_CODE_CROP_PICTURE);
    }
}
