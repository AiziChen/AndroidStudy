package com.cnsunrun.androidstudy.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.cnsunrun.androidstudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;

import static com.sunrun.toollibrary.utils.ToastUtils.showToast;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    private ImageView iv_back;
    @BindView(R.id.listview)
    ListView listview;
    private String[] titles = {"下拉刷新,上拉加载", "流式布局",
            "FlycotabLayout",
            "选择Window的对话框",
            "搜索栏悬浮",
            "高德地图的练习",
            "RececlerView添加Banner头部",
            "自定义的TabLayout",
            "图片的压缩",
            "图片的选择",
            "ScrollView嵌套RecyclerView"
    };
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        HiPermission.create(MainActivity.this)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                        Log.i(TAG, "onClose");
                        showToast("用户关闭权限申请");
                    }

                    @Override
                    public void onFinish() {
//                        showToast("所有权限申请完成");
                        initView();
                    }

                    @Override
                    public void onDeny(String permission, int position) {
                        Log.i(TAG, "onDeny");
                    }

                    @Override
                    public void onGuarantee(String permission, int position) {
                        Log.i(TAG, "onGuarantee");
                    }
                });

    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_arrow_back);
        iv_back.setVisibility(View.GONE);

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, titles);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, CridViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, StreamingActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, FlycotabLayoutActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, DropdownSelectActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, SuspensionActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, MapActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, RecyclerViewAddHeader.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, CustomTabLayoutActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, YaSuoImageViewActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, ChooseImageActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, ScrollViewAndRecyclerView.class));
                        break;
                }
            }
        });

    }
}
