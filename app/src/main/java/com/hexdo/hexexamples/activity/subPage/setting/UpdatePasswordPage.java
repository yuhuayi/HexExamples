package com.hexdo.hexexamples.activity.subPage.setting;

import android.view.View;
import app.newbee.lib.view.common.ClearEditText;
import butterknife.Bind;
import butterknife.OnClick;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

/**
 * 我的->设置->修改密码
 *
 * @author admin
 */
public class UpdatePasswordPage extends BaseSubFragment {

    @Bind(R.id.psd_1_et) ClearEditText psd1Et;
    @Bind(R.id.psd_2_et) ClearEditText psd2Et;
    @Bind(R.id.psd_3_et) ClearEditText psd3Et;

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_myself_setting_updatepwd;
    }

    @OnClick({R.id.tab0_View, R.id.tab1_View, R.id.tab2_View, R.id.tab3_View})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back_img:
                mActivity.closeSoftInputMethod(view);
                popBackStack();
                break;
            case R.id.complete_bt:
                break;
            default:
                break;
        }
    }

}
