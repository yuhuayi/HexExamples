package com.hexdo.hexexamples.activity.base;

import android.app.Activity;
import app.newbee.lib.base.BaseView;
import com.hexdo.hexexamples.HexApp;
import com.squareup.leakcanary.RefWatcher;

public abstract class BaseFragment extends app.newbee.lib.base.BaseFragment implements BaseView {


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /**
         * 检测是否发生内存泄露
         */
        RefWatcher refWatcher = HexApp.getRefWatcher();
        refWatcher.watch(this);
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void showError(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showException(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showNetError() {
        toggleNetworkError(true, null);
    }

    @Override
    public void showLoading(String msg) {
        toggleShowLoading(true, null);
    }

    @Override
    public void hideLoading() {
        toggleShowLoading(false, null);
    }
}


