package com.cnsunrun.androidstudy.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZhouBin on 2017/8/22.
 * Effect: 选择条目的对话框
 */

public class SelectItemDailog extends Dialog {


    @BindView(R.id.tv_Photo_albums)
    TextView tvPhotoAlbums;
    @BindView(R.id.tv_Take_pictures)
    TextView tvTakePictures;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    private OnButtonClickListener onButtonClickListener;

    public SelectItemDailog(Context context) {
        super(context);

        Window window = this.getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        View popupView = View.inflate(context, R.layout.select_item_popupwindow, null);
        ButterKnife.bind(this, popupView);
        window.setContentView(popupView);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.windowAnimations = R.style.bottomInWindowAnim;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        SelectItemDailog.this.show();

    }

    @OnClick({R.id.tv_Photo_albums, R.id.tv_Take_pictures, R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_Photo_albums:
                if (onButtonClickListener != null) {
                    onButtonClickListener.selectItemOne();
                }
                break;
            case R.id.tv_Take_pictures:
                if (onButtonClickListener != null) {
                    onButtonClickListener.selectItemTwo();
                }
                break;
            case R.id.tv_cancel:
                SelectItemDailog.this.dismiss();
                break;
        }
    }

    public interface OnButtonClickListener {
        void selectItemOne();

        void selectItemTwo();

    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

}
