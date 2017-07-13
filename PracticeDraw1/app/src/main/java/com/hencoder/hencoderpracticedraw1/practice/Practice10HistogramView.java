package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    Paint mPaint = new Paint();
    int[] account ={2,4,5,20,40,50,15};
    String[] name = {"Froyo","GB","ICS","JB","KitKat","L","M"};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        mPaint.reset();
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(100,100,100,600,mPaint);
        canvas.drawLine(100,600,1000,600,mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        for(int i=0;i<account.length;i++){
            mPaint.setColor(Color.GREEN);
            canvas.drawRect(120*(i+1)+30,600-account[i]*10,120*(i+2),600,mPaint);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(30);
            canvas.drawText(name[i],120*(i+1)+40,600+30,mPaint);
        }
    }
}
