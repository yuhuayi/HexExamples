package com.hexdo.hexexamples.activity.subPage.register_login;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.OnClick;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

public class ForgotPsdFragment extends BaseSubFragment {


    @Bind(R.id.et_mobile) EditText et_mobile;
    @Bind(R.id.regist_verification_bt) Button registVerificationBt;
    @Bind(R.id.regist_code_et) EditText registCodeEt;
    @Bind(R.id.et_psd) EditText etPsd;
    @Bind(R.id.bt_reset_psd) Button btResetPsd;

    private int wait_second = 60;

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override protected void processLogic() {

    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_forgot_psd;
    }

    @OnClick({R.id.regist_verification_bt, R.id.bt_reset_psd})
    public void handleClick(View view) {
        switch (view.getId()) {
            case R.id.regist_verification_bt:
                String mobile = et_mobile.getText().toString();
                if (TextUtils.isEmpty(mobile)) {
                    showToast("请输入手机号");
                    return;
                }
                break;
            case R.id.bt_reset_psd:

                break;
        }
    }

}
