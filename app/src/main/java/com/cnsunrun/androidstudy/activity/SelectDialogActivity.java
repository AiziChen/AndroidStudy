package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.SelectItemDailog;
import com.cnsunrun.androidstudy.utils.SelectMoreTypeDailog;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectDialogActivity extends SwipeBackActivity {


    @BindView(R.id.tv_type_one)
    TextView tvTypeOne;
    @BindView(R.id.tv_type_two)
    TextView tvTypeTwo;
    @BindView(R.id.tv_type_three)
    TextView tvTypeThree;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_dialog);

        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        initTitle("自定以Dialog");

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    private void showTypeOneDialog() {

        final SelectItemDailog selDialog = new SelectItemDailog(mContext);
        selDialog.show();
        selDialog.setPhotoAlbumsListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("点击了相册获取");
                selDialog.dismiss();
            }
        });
        selDialog.setTakePicturesListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("点击了拍照");
                selDialog.dismiss();
            }
        });

    }

    @OnClick({R.id.tv_type_one, R.id.tv_type_two, R.id.tv_type_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_type_one:
                showTypeOneDialog();
                break;
            case R.id.tv_type_two:
                showTypeTwo();
                break;
            case R.id.tv_type_three:
                break;
        }
    }

    private void showTypeTwo() {
        SelectMoreTypeDailog selmoreDialog = new SelectMoreTypeDailog(mContext);
        selmoreDialog.show();

    }
}
