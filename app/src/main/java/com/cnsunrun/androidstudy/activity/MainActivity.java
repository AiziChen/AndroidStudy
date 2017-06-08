package com.cnsunrun.androidstudy.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.cnsunrun.androidstudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    private ImageView iv_back;
    @BindView(R.id.listview)
    ListView listview;
    private String[] titles = {"下拉刷新,上拉加载", "流式布局",
            "FlycotabLayout",
            "选择Window的对话框"
    };
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

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

                }
            }
        });

    }
}
