package com.android.baina.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class ChildView extends LinearLayout {
 
     private static final String TAG = "TouchEvent";
 
     public ChildView(Context context) {
            super( context);
     }

    public ChildView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
     public boolean dispatchTouchEvent(MotionEvent ev) {
         Log. i(TAG, "Child-dispatchTouchEvent-->" + TouchEventUtil.getTouchAction(ev.getAction()));
         return super.dispatchTouchEvent(ev);
     }
 
     @Override
     public boolean onInterceptTouchEvent(MotionEvent ev) {
         Log. i(TAG, "Child-onInterceptTouchEvent-->" + TouchEventUtil.getTouchAction(ev.getAction()));
         return super.onInterceptTouchEvent( ev);
     }
 
     @Override
     public boolean onTouchEvent(MotionEvent event ) {
         Log. i(TAG, "Child-onTouchEvent-->" + TouchEventUtil.getTouchAction(event.getAction()));
         return super.onTouchEvent( event);
     }
 
}