package com.hexdo.hexexamples.activity.base;

import android.app.Activity;
import app.newbee.lib.base.BaseFragment;

public abstract class BaseMainFragment extends BaseFragment {
    public MainActivity mActivity;

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
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (MainActivity) getActivity();
    }

}
