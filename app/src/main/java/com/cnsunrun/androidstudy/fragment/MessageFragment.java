package com.cnsunrun.androidstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amap.api.location.AMapLocation;
import com.cnsunrun.androidstudy.R;
import com.cnsunrun.androidstudy.activity.DropdownSelectActivity;
import com.cnsunrun.androidstudy.activity.HeaderGradientActivity;
import com.cnsunrun.androidstudy.activity.MoreClassificationActivity;
import com.cnsunrun.androidstudy.activity.ScrollViewAndRecyclerView;
import com.cnsunrun.androidstudy.activity.SelectDialogActivity;
import com.cnsunrun.androidstudy.activity.SpreadsDeleteActivity;
import com.cnsunrun.androidstudy.alipay.AliPayUtils;
import com.cnsunrun.androidstudy.base.BaseFragment;
import com.cnsunrun.androidstudy.utils.ConstantValue;
import com.cnsunrun.androidstudy.utils.LocationMapUtils;
import com.sunrun.toollibrary.utils.ToastUtils;

/**
 * Created by ZhouBin on 2017/8/2.
 * Effect: 消息的fragment
 */

public class MessageFragment extends BaseFragment {

    private ListView listView;

    private String[] titles = {
            "支付宝支付",
            "高德地图定位",
            "输入密码框",
            "选择Window的对话框",
            "仿美团的更多分类功能",
            "自定义选择框",
            "侧滑删除Item",
            "shareSdk的封装"
    };

    public static MessageFragment newInstance() {
        MessageFragment homeFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        homeFragment.setArguments(bundle);
        return homeFragment;

    }

    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.message_fragment, null);

        return rootView;
    }

    @Override
    protected void bindViews(View view) {
        listView = (ListView) view.findViewById(R.id.listView);

    }

    @Override
    protected void processLogic() {
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
                    case 2:
                        intent2Activity(ScrollViewAndRecyclerView.class);
                        break;
                    case 3:
                        intent2Activity(DropdownSelectActivity.class);
                        break;
                    case 4:
                        intent2Activity(MoreClassificationActivity.class);
                        break;
                    case 5:
                        intent2Activity(SelectDialogActivity.class);
                        break;
                    case 6:
                        intent2Activity(SpreadsDeleteActivity.class);
                        break;
                    case 7:
                        intent2Activity(HeaderGradientActivity.class);
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
        String orderNumber = "2017080410248504";
        String totalPrice = "0.01";
        String urlCallback = ConstantValue.ALIPAY_URL_CALLBACK;
        AliPayUtils alipay = new AliPayUtils(getActivity());
        alipay.requestPay(orderTitle, orderNumber, totalPrice, urlCallback);
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

}
