package com.hexdo.hexexamples.activity.subPage.setting;

import android.view.View;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

/**
 * 个人-->设置
 *
 * @author admin
 */
public class AboutPage extends BaseSubFragment {

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {


    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_myself_setting_about;
    }
}
