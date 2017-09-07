package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.widgtet.RatingBar;
import com.sunrun.toollibrary.utils.ToastUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;


/**
 * 自定义RatingBar
 */
public class MainActivity extends SwipeBackActivity {

    @BindView(R.id.ratingBar01)
    RatingBar ratingBar01;
    @BindView(R.id.ratingBar02)
    RatingBar ratingBar02;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义RatingBar");


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        ratingBar02.setStar(4.5f);
        Luban.with(this)
                .load("")                                   // 传人要压缩的图片列表
                .ignoreBy(100)                                  // 忽略不压缩图片的大小
                .setTargetDir(null)                        // 设置压缩后文件存储位置
                .setCompressListener(new OnCompressListener() { //设置回调
                    @Override
                    public void onStart() {
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过程出现问题时调用
                    }
                }).launch();    //启动压缩

    }

    @Override
    protected void setListener() {
        ratingBar01.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                ToastUtils.showToast("星数是:" + ratingCount);
            }
        });

    }
}
