package com.hexdo.hexexamples.activity.base;

import butterknife.OnClick;
import com.hexdo.hexexamples.R;

public abstract class BaseSubFragment extends BaseFragment {

    @OnClick(R.id.title_back_img)
    public void handleBack() {
        popBackStack();
    }

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


}


