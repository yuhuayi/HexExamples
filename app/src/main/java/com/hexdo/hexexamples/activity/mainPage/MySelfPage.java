package com.hexdo.hexexamples.activity.mainPage;

import android.view.View;
import app.newbee.lib.base.BaseSubActivity;
import butterknife.OnClick;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseMainFragment;
import com.hexdo.hexexamples.activity.subPage.setting.SettingPage;

/**
 * 我的
 */
public class MySelfPage extends BaseMainFragment {

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
        initdata();
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_main_my_self;
    }

    private void initdata() {

    }

    @OnClick({R.id.myself_setting_rl})
    public void handleClick(View view) {
        switch (view.getId()) {
            case R.id.myself_setting_rl:
                mActivity.gotoSubActivity(BaseSubActivity.class, SettingPage.class.getName(), null);
                break;

            default:
                break;
        }
    }


}
