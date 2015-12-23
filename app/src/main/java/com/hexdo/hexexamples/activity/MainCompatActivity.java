package com.hexdo.hexexamples.activity;

import android.os.Bundle;
import android.view.View;
import app.newbee.lib.base.BaseCompatActivity;
import app.newbee.lib.netstatus.NetUtils;
import com.hexdo.hexexamples.R;

/**
 * 主页面
 */
public class MainCompatActivity extends BaseCompatActivity {

    @Override protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override protected void getBundleExtras(Bundle extras) {

    }

    @Override protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override protected void onNetworkDisConnected() {

    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_compat_main;
    }

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override protected void processLogic() {

    }
}
