package com.cnsunrun.androidstudy.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.QRCodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 状态栏的问题
 */
public class StatusBarActivity extends SwipeBackActivity {


    @BindView(R.id.edit_Message)
    EditText editMessage;
    @BindView(R.id.iv_code_image)
    ImageView ivCodeImage;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_status_bar);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("二维码").setRightText("保存").setRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String erCodeMes = editMessage.getText().toString().trim();
                if (!TextUtils.isEmpty(erCodeMes)) {
                    Bitmap bitmap = QRCodeUtils.createQRCode(erCodeMes);
                    ivCodeImage.setImageBitmap(bitmap);
                    editMessage.setVisibility(View.GONE);
                } else {
                    showToast("信息内容不能为空");
                }
            }
        });

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

}
