package com.cnsunrun.androidstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.adapter.SelectImageViewAdapter;
import com.cnsunrun.androidstudy.base.BaseActivity;
import com.cnsunrun.androidstudy.utils.GlideSelectImageLoader;
import com.cnsunrun.androidstudy.widgtet.DividerGridItemDecoration;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 多张图片选择
 */
public class CountDownActivity extends BaseActivity {

    public static final int REQUEST_CODE_SELECT = 100;
    public static final int REQUEST_CODE_PREVIEW = 101;
    @BindView(R.id.tv_select_type_one)
    TextView tvSelectTypeOne;
    @BindView(R.id.tv_select_type_two)
    TextView tvSelectTypeTwo;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.activity_count_down)
    LinearLayout activityCountDown;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);

    }

    @Override
    protected void bindViews() {
        initTitle("多张图片选择");
        initImagePicker();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    private void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideSelectImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);                      //显示拍照按钮
        imagePicker.setCrop(true);                           //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true);                   //是否按矩形区域保存
        imagePicker.setSelectLimit(9);              //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);                       //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);                      //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);                         //保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);                         //保存文件的高度。单位像素
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == REQUEST_CODE_SELECT) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                SelectImageViewAdapter adapter = new SelectImageViewAdapter(images);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                recyclerView.addItemDecoration(new DividerGridItemDecoration(mContext, getResources().getColor(R.color.green_color), 1));
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick({R.id.tv_select_type_one, R.id.tv_select_type_two})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select_type_one:
                Intent intent = new Intent(this, ImageGridActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SELECT);
                break;
            case R.id.tv_select_type_two:
                Intent intent2 = new Intent(this, ImageGridActivity.class);
                intent2.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
                startActivityForResult(intent2, REQUEST_CODE_SELECT);
                break;
        }
    }
}
