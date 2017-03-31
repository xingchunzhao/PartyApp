package com.example.administrator.party;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/3/31.
 */

public class FirstPage extends Activity{

    private Paint mPaint;
    private Rect mBounds;
    private int mCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage_config);
    }

//    public FirstPage(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        //LayoutInflater.from(context).inflate(R.layout.firstpage_config,this);
//        //setContentView(R.layout.firstpage_config);
//        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mBounds = new Rect();
//        setOnClickListener(this);
//    }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            mPaint.setColor(Color.BLUE);
//            canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
//            mPaint.setColor(Color.YELLOW);
//            mPaint.setTextSize(30);
//            String text = String.valueOf(mCount);
//            mPaint.getTextBounds(text, 0, text.length(), mBounds);
//            float textWidth = mBounds.width();
//            float textHeight = mBounds.height();
//            canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
//                    + textHeight / 2, mPaint);
//        }
//
//        @Override
//        public void onClick(View v) {
//            mCount++;
//            invalidate();
//        }
//

}
