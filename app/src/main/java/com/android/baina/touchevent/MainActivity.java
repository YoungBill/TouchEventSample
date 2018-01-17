package com.android.baina.touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TouchEvent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "MainActivity-dispatchTouchEvent-->" + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i(TAG, "MainActivity-onTouchEvent-->" + TouchEventUtil.getTouchAction(ev.getAction()));
        return true;
    }
}
