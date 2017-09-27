package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.AlerDialogUtils;
import com.cnsunrun.androidstudy.utils.SelectItemDailog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 更换用户图像
 */
public class SelectImageHeandActivity extends SwipeBackActivity {

    private static final String TAG = "SelectImageHeandActivit";
    @BindView(R.id.tv_select_type)
    TextView tvSelectType;
    @BindView(R.id.civ_image_photo)
    CircleImageView civImagePhoto;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_heand);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("更换用户图像");

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
            }

            @Override
            public void selectItemTwo() {
                //拍照
            }
        });
    }
}
