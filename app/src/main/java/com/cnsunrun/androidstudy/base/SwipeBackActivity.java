//package com.cnsunrun.androidstudy.base;
//
//import android.os.Bundle;
//
//import com.cnsunrun.androidstudy.view.TitleBuilder;
//import com.sunrun.toollibrary.LibActivity;
//
//import me.imid.swipebacklayout.lib.SwipeBackLayout;
//import me.imid.swipebacklayout.lib.Utils;
//import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
//import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;
//
///**
// * Created by ZhouBin on 2017/7/18.
// * Effect:  返回上一级的基类
// */
//
//public abstract class SwipeBackActivity extends LibActivity implements SwipeBackActivityBase {
//
//    private SwipeBackActivityHelper mHelper;
//
//    public TitleBuilder initTitle(Object obj) {
//        if (obj instanceof String) {
//            return new TitleBuilder(this).setTitleText((String) obj);
//        } else {
//            return new TitleBuilder(this).setTitleText((int) obj);
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mHelper = new SwipeBackActivityHelper(this);
//        mHelper.onActivityCreate();
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mHelper.onPostCreate();
//    }
//
//    @Override
//    public SwipeBackLayout getSwipeBackLayout() {
//        return mHelper.getSwipeBackLayout();
//    }
//
//    @Override
//    public void setSwipeBackEnable(boolean enable) {
//        getSwipeBackLayout().setEnableGesture(enable);
//    }
//
//    @Override
//    public void scrollToFinishActivity() {
//        Utils.convertActivityToTranslucent(this);
//        getSwipeBackLayout().scrollToFinishActivity();
//    }
//}
