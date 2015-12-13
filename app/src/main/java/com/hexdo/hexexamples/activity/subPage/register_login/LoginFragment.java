package com.hexdo.hexexamples.activity.subPage.register_login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

public class LoginFragment extends BaseSubFragment {

    @Bind(R.id.title_back_img) ImageView titleBackImg;
    @Bind(R.id.login_mobile_et) EditText loginMobileEt;
    @Bind(R.id.login_psd_et) EditText loginPsdEt;
    @Bind(R.id.login_bt) Button loginBt;
    @Bind(R.id.reg_bt) TextView regBt;
    @Bind(R.id.find_password_bt) TextView findPasswordBt;

    @Bind(R.id.loading_view) View mLoadingTargetView;

    @Override protected View getLoadingTargetView() {
        return mLoadingTargetView;
    }

    @Override protected void processLogic() {

    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_login;
    }

    @OnClick({R.id.login_bt, R.id.reg_bt, R.id.find_password_bt})
    public void handleClick(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                toggleShowLoading(true, null);
                break;
            case R.id.reg_bt:
                mActivity.changeSubFragment(this, RegisterFragment.class, null);
                break;
            case R.id.find_password_bt:
                mActivity.changeSubFragment(this, ForgotPsdFragment.class, null);
                break;
        }
    }

}
