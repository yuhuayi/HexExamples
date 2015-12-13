package com.hexdo.hexexamples.activity.subPage.setting;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

/**
 * 我的->设置->意见反馈
 *
 * @author admin
 */
public class FeedBackPage extends BaseSubFragment {

    @Bind(R.id.feedback_content)
    EditText mFeedbackContent;
    @Bind(R.id.hint_num_tv)
    TextView hintNumTv;

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
        mFeedbackContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String feedback = mFeedbackContent.getText().toString();
                if (feedback != null & feedback.length() <= 200) {
                    hintNumTv.setText(feedback.length() + "/200");
                } else {

                }
            }
        });
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_myself_setting_feedback;
    }

    @OnClick({R.id.title_back_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back_img:
                mActivity.closeSoftInputMethod(view);
                popBackStack();
                break;
            case R.id.submit:
                String Content = mFeedbackContent.getText().toString();
                break;
            default:
                break;
        }
    }
}

