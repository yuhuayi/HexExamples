package com.hexdo.hexexamples.activity.subPage.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import app.newbee.lib.util.LogUtil;

/**
 * Created with Android Studio.
 * User: cao_ruixiang
 * Date: 15/11/1
 * Time: 12:28
 */
public class MyImageView extends ImageView {
    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.i("MyImageView", "---> ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.i("MyImageView", "---> ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.i("MyImageView", "---> ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.i("MyImageView", "---> ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(event);
    }
}
