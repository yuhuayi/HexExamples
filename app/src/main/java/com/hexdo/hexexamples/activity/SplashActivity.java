package com.hexdo.hexexamples.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import app.newbee.lib.netstatus.NetUtils;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseActivity;

/**
 * 欢迎界面
 */
public class SplashActivity extends BaseActivity {

    private boolean login_state = false;

    @Override protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override protected void getBundleExtras(Bundle extras) {

    }

    @Override protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override protected void onNetworkDisConnected() {

    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        start();
    }

    @Override protected void setListener() {

    }

    private void start() {
        AlphaAnimation aa = new AlphaAnimation(0.1f, 1.0f);
        aa.setDuration(2000);
        ImageView v = (ImageView) this.findViewById(R.id.splash_image);
        v.startAnimation(aa);
        aa.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {

            }

            public void onAnimationEnd(Animation animation) {
//                boolean firstIn = PreferencesUtils.getBoolean(SplashActivity.this, "firstIn", true);
                boolean firstIn = false;
                Intent intent = null;
                if (firstIn) {
                    // 第一次运行,打开引导页
                    intent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(intent);
                    finish();
                } else {
//                    intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
//                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
        });
    }

    @Override protected boolean isApplyKitKatTranslucency() {
        return true;
    }
}
