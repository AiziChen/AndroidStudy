package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.utils.SaveBitmapToFileUtils;
import com.sunrun.toollibrary.LibActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YaSuoImageViewActivity extends LibActivity {

    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_imageview)
    ImageView ivImageview;
    private String IMG_SAVE_DIR;
    TextView tv_show_dailog;

    private String path = "https://ws1.sinaimg.cn/large/610dc034ly1ffxjlvinj5j20u011igri.jpg";
    private AlertDialog commentDialog;      // 评论会话框

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_ya_suo_image_view);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        tvTitle.setText("图片的压缩");
        IMG_SAVE_DIR = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsoluteFile() + "/image";
        tv_show_dailog = (TextView) findViewById(R.id.tv_show_dailog);
    }


    //对图片进行压缩操作
    private File compressPhoto(String filepath) {
        File photoFile = new File(filepath);
        String aimPath = new File(IMG_SAVE_DIR, photoFile.getName()).getAbsolutePath();
        String compress_path = SaveBitmapToFileUtils.saveBitmapToFile(photoFile.getAbsolutePath(), aimPath, 30);// 压缩上传的图片质量
        return new File(compress_path);
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {
        Glide.with(mContext).load(path).into(ivImageview);

    }

    @Override
    protected void setListener() {
        tv_show_dailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCustomDiaLog();
            }
        });

    }

    private void showCustomDiaLog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View dialogView = View.inflate(mContext, R.layout.item_dailog_mess, null);
        builder.setView(dialogView);
        builder.setCancelable(true);
        commentDialog = builder.create();
        commentDialog.show();
        EditText et_comment_edittext = (EditText) dialogView.findViewById(R.id.et_comment_edittext);

        Button btn_set_font_cancel = (Button) dialogView.findViewById(R.id.btn_set_font_cancel);
        Button btn_set_font_send = (Button) dialogView.findViewById(R.id.btn_set_font_send);
        btn_set_font_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentDialog.dismiss();
            }
        });

    }


    @OnClick(R.id.iv_arrow_back)
    public void onViewClicked() {
        finish();
    }
}
