package com.example.administrator.party.pages;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;

import com.example.administrator.party.R;

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
}
