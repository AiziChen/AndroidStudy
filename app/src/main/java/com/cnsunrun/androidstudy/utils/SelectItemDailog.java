package com.cnsunrun.androidstudy.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cnsunrun.androidstudy.R;

/**
 * Created by ZhouBin on 2017/8/22.
 * Effect: 选择条目的对话框
 */

public class SelectItemDailog extends Dialog {

    private TextView tv_Photo_albums, tv_Take_pictures, tv_cancel;


    public SelectItemDailog(Context context) {
        super(context);

        Window window = this.getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        View popupView = View.inflate(context, R.layout.select_item_popupwindow, null);
        window.setContentView(popupView);
        initViews(popupView);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.windowAnimations = R.style.bottomInWindowAnim;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    private void initViews(View popupView) {
        tv_Photo_albums = (TextView) popupView.findViewById(R.id.tv_Photo_albums);
        tv_Take_pictures = (TextView) popupView.findViewById(R.id.tv_Take_pictures);
        tv_cancel = (TextView) popupView.findViewById(R.id.tv_cancel);

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectItemDailog.this.dismiss();
            }
        });
    }

    /**
     * 相册选择
     *
     * @param onClickListener
     */
    public void setPhotoAlbumsListener(View.OnClickListener onClickListener) {
        if (tv_Photo_albums != null) {
            tv_Photo_albums.setOnClickListener(onClickListener);
        }

    }

    /**
     * 拍照获取
     *
     * @param onClickListener
     */
    public void setTakePicturesListener(View.OnClickListener onClickListener) {
        if (tv_Take_pictures != null) {
            tv_Take_pictures.setOnClickListener(onClickListener);
        }

    }


}
