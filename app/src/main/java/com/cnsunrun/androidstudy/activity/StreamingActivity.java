package com.cnsunrun.androidstudy.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cnsunrun.androidstudy.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
*流式布局
 */
public class StreamingActivity extends Activity {

    @BindView(R.id.iv_arrow_back)
    ImageView ivArrowBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;
    private List<String> mVals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
        ButterKnife.bind(this);

        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tvTitle.setText("流式布局");
        mVals.add("三星");
        mVals.add("华为");
        mVals.add("华为荣耀");
        mVals.add("中兴");
        mVals.add("联想联想niu");
        mVals.add("ViVoViVoViVo");
        mVals.add("oppo");
        mVals.add("苹果");
        mVals.add("金立M6Plus");
        mVals.add("魅族魅族");
        mVals.add("朵唯");
        mVals.add("索尼");

        idFlowlayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, final String s) {
                final TextView textView = (TextView) View.inflate(StreamingActivity.this, R.layout.include_textview, null);
                textView.setText(s);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(StreamingActivity.this, "点击了" + s, Toast.LENGTH_LONG).show();
                    }
                });
                return textView;
            }
        });
    }

    @OnClick(R.id.iv_arrow_back)
    public void onViewClicked() {
        finish();
    }
}
