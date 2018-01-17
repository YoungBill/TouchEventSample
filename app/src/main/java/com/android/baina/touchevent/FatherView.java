package com.android.baina.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class FatherView extends LinearLayout {

    private static final String TAG = "TouchEvent";

    public FatherView(Context context) {
        super(context);
    }

    public FatherView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "Father-dispatchTouchEvent-->" + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG, "Father-onInterceptTouchEvent-->" + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "Father-onTouchEvent-->" + TouchEventUtil.getTouchAction(event.getAction()));
        return true;
    }


}