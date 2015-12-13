package com.hexdo.hexexamples.activity.subPage.register_login;

import android.view.View;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

public class RegisterFragment extends BaseSubFragment {
    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_register;
    }

}
