package com.cnsunrun.androidstudy.view;

/**
 * Created by ZhouBin on 2017/9/4.
 * Effect: 点击的接口
 */

public interface ItemTouchListener {
    void onItemClick(String str);

    void onLeftMenuClick(String str);

    void onRightMenuClick(String str);
}
