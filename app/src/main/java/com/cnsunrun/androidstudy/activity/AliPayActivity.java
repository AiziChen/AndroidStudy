package com.cnsunrun.androidstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.alipay.AliPayUtils;
import com.cnsunrun.androidstudy.base.SwipeBackActivity;
import com.cnsunrun.androidstudy.utils.LocationMapUtils;
import com.sunrun.toollibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AliPayActivity extends SwipeBackActivity {


    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.listView)
    ListView listView;
    private String[] titles = {"支付宝支付", "高德地图定位"};

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_ali_pay);
        ButterKnife.bind(this);
    }

    @Override
    protected void bindViews() {
        tvTitle.setText("对于控件操作的封装");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        listView.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, titles));
    }

    @Override
    protected void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        toSendAliPay();
                        break;
                    case 1:
                        localMap();
                        break;
                }
            }
        });


    }

    /**
     * 高德地图定位
     */
    private void localMap() {
        LocationMapUtils locationMapUtils = new LocationMapUtils(mContext);
        locationMapUtils.initOnLocationMap(new LocationMapUtils.LocationChangeListsner() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                    String address = aMapLocation.getAddress();
                    ToastUtils.showToast(address);
                } else {
                    ToastUtils.showToast("定位失败:" + aMapLocation.getErrorInfo());
                }
                super.onLocationChanged(aMapLocation);
            }
        });
    }

    /**
     * 支付宝支付
     */
    private void toSendAliPay() {
        String orderTitle = "测试支付宝";
        String orderNumber = "2017072656974848";
        String totalPrice = "0.01";
        String callUrl = "http://test.cnsunrun.com/shunshou//Api/Pay/Callback/ali_callback";
        AliPayUtils alipay = new AliPayUtils(AliPayActivity.this);
        alipay.requestPay(orderTitle, orderNumber, totalPrice, callUrl);
        alipay.setPayListener(new AliPayUtils.OnAlipayListener() {
            @Override
            public void onSuccess() {
                super.onSuccess();
                ToastUtils.showToast("支付成功!");
            }

            @Override
            public void onCancel() {
                super.onCancel();
                ToastUtils.showToast("取消支付!");
            }
        });
    }


    @OnClick(R.id.iv_arrow_back)
    public void onViewClicked() {
        finish();
    }
}
