package com.hexdo.hexexamples.activity.mainPage;

import android.view.View;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseMainFragment;

/**
 * 我的
 */
public class HomePage extends BaseMainFragment {

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
        initdata();
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_main_home;
    }

    private void initdata() {
        // mActivity.showLoadingDialog("数据加载中..");
    }

}
