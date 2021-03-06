package com.cnsunrun.androidstudy.widgtet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ZhouBin on 2017/6/7.
 * Effect: 用于item分割的虚线
 */

public class DottedDivideLine extends View {

    int color = Color.parseColor("#DDDDDD");

    public DottedDivideLine(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DottedDivideLine(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);//颜色可以自己设置
        Path path = new Path();
        path.moveTo(0, 0);//起始坐标
        if (getWidth() < getHeight()) {
            path.lineTo(0, getHeight());//终点坐标
        } else {
            path.lineTo(getWidth(), 0);//终点坐标
        }
        PathEffect effects = new DashPathEffect(new float[]{8, 4, 8, 4}, 1);//设置虚线的间隔和点的长度
        paint.setPathEffect(effects);
        canvas.drawPath(path, paint);
    }
}
