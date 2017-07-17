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


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_ya_suo_image_view);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
    }



    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }


}
