package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11PieChartView extends View {
    private static final String TAG = "Practice11PieChartView";
    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int[] account = {2,4,5,20,40,50,15};
    String[] name = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    int[] Colors = {Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.YELLOW, Color.RED, Color.WHITE};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int sum = 0;
        int max = 0;
        for (int i = 0; i < account.length; i++) {
            if (account[i] > max) {
                max = account[i];
            }
            sum += account[i];
        }
        double start = 0;
        int swap = 0;
        int left = 200;
        int top = 100;
        int right = 700;
        int bottom = 600;
        int centerX = (right + left) / 2;
        int centerY = (top + bottom) / 2;
        int r = (right - left) / 2;
        int line2CircleX = 0;
        int line2CircleY = 0;
        for (int i = 0; i < account.length; i++) {
            mPaint.setColor(Colors[i]);
            mPaint.setStyle(Paint.Style.FILL);
            swap = account[i] * 360 / sum;
            if (account[i] == max) {
//                Log.d(TAG, "len::" + (swap / 2 + Math.abs(start - 180)));
//                Log.d(TAG, "cos::" + (Math.cos(Math.toRadians(45))));
//                Log.d(TAG, "centerX::" + centerX);
//                Log.d(TAG, "centerY::" + centerY);
//                Log.d(TAG, "sin90::" + Math.sin(Math.toRadians(92)));
//                Log.d(TAG, "cos90::" + Math.cos(Math.toRadians(92)));
//                Log.d(TAG, "r:" + r);

                int offsetx = (int) (20 * Math.cos(Math.toRadians((double) (swap / 2 + start))));
                int offsety = (int) (20 * Math.sin(Math.toRadians((double) (swap / 2 + start))));
                Log.d(TAG, "offsetx::" + offsetx);
                Log.d(TAG, "offsety::" + offsety);
                canvas.drawArc(left + offsetx, top + offsety, right + offsetx, bottom + offsety, (int)start + 1, swap - 1, true, mPaint);

                line2CircleX = centerX + offsetx + (int) (r * Math.cos(Math.toRadians((double) (swap / 2 + start))));
                line2CircleY = centerY + offsety + (int) (r * Math.sin(Math.toRadians((double) (swap / 2 + start))));
                Log.d(TAG, "line2CircleX::" + line2CircleX);
                Log.d(TAG, "line2CircleY::" + line2CircleY);
                mPaint.setStrokeWidth(4);
                mPaint.setColor(Color.WHITE);
                canvas.drawLine(line2CircleX, line2CircleY, line2CircleX = line2CircleX + (int) (20 * Math.cos(Math.toRadians((double) (swap / 2 + start)))), line2CircleY = line2CircleY + (int) (20 * Math.sin(Math.toRadians((double) (swap / 2 + start)))), mPaint);
            } else {
                canvas.drawArc(left, top, right, bottom, (int)start + 1, swap - 1, true, mPaint);
                line2CircleX = centerX + (int) (r * Math.cos(Math.toRadians((double) (swap / 2 + start))));
                line2CircleY = centerY + (int) (r * Math.sin(Math.toRadians((double) (swap / 2 + start))));
                Log.d(TAG, "line2CircleX::" + line2CircleX);
                Log.d(TAG, "line2CircleY::" + line2CircleY);
                mPaint.setStrokeWidth(4);
                mPaint.setColor(Color.WHITE);
                canvas.drawLine(line2CircleX, line2CircleY, line2CircleX = line2CircleX + (int) (20 * Math.cos(Math.toRadians((double) (swap / 2 + start)))), line2CircleY = line2CircleY + (int) (20 * Math.sin(Math.toRadians((double) (swap / 2 + start)))), mPaint);

            }
            if (line2CircleX > centerX) {
                canvas.drawLine(line2CircleX, line2CircleY, 750, line2CircleY, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText(name[i],750+20,line2CircleY,mPaint);
            } else {
                canvas.drawLine(line2CircleX, line2CircleY, 150, line2CircleY, mPaint);
                mPaint.setTextSize(30);
                canvas.drawText(name[i],150-100,line2CircleY,mPaint);
            }
            start += ((double) account[i] * 360) / sum;
            Log.d(TAG, "start::" + start);
        }
    }
}
