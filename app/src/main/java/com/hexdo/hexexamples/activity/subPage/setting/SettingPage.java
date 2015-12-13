package com.hexdo.hexexamples.activity.subPage.setting;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.newbee.lib.netstatus.NetUtils;
import app.newbee.lib.util.*;
import butterknife.Bind;
import butterknife.OnClick;
import com.hexdo.hexexamples.GOEApp;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;
import com.hexdo.hexexamples.activity.subPage.test.adapter.ListViewPage;
import com.hexdo.hexexamples.activity.subPage.test.adapter.RefreshViewPage;
import com.hexdo.hexexamples.model.ResultWrap;
import com.hexdo.hexexamples.model.UserBean;
import com.hexdo.hexexamples.model.wrap.ResposeWrap;
import com.hexdo.hexexamples.network.GOEFactory;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 我的->设置
 *
 * @author admin
 */
public class SettingPage extends BaseSubFragment {

    @Bind(R.id.cache_size_tv) TextView cacheSizeTv;
    @Bind(R.id.check_tv) TextView checkTv;
    @Bind(R.id.update_pwd_rl) RelativeLayout updatePwdRl;
    @Bind(R.id.iv_4) ImageView iv4;
    @Bind(R.id.iv_back8) ImageView ivBack8;
    @Bind(R.id.clear_cache_rl) RelativeLayout clearCacheRl;
    @Bind(R.id.iv_5) ImageView iv5;
    @Bind(R.id.suggest_submit_rl) RelativeLayout suggestSubmitRl;
    @Bind(R.id.iv_6) ImageView iv6;
    @Bind(R.id.about_teme_rl) RelativeLayout aboutTemeRl;
    @Bind(R.id.iv_7) ImageView iv7;
    @Bind(R.id.check_up_version) RelativeLayout checkUpVersion;
    @Bind(R.id.iv_9) ImageView iv9;
    @Bind(R.id.kefu_phone) TextView kefuPhone;
    @Bind(R.id.rl_kefu_phone) RelativeLayout rlKefuPhone;
    @Bind(R.id.rl_test_adapter) RelativeLayout rlTestAdapter;
    @Bind(R.id.rl_test_list_viewadapter) RelativeLayout rlTestListViewadapter;
    @Bind(R.id.logout_rl) MyImageView logoutRl;
    @Bind(R.id.vsv_lodding_target_view) View vsv_lodding_target_view;
    private long folderSize;

    @OnClick({R.id.rl_test_adapter, R.id.rl_test_list_viewadapter, R.id.update_pwd_rl, R.id.suggest_submit_rl, R.id.about_teme_rl, R.id.clear_cache_rl, R.id.check_up_version})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_test_adapter:
                mActivity.changeSubFragment(this, RefreshViewPage.class, null);
                break;
            case R.id.rl_test_list_viewadapter:
                mActivity.changeSubFragment(this, ListViewPage.class, null);
                break;
            case R.id.update_pwd_rl:
                mActivity.changeSubFragment(this, UpdatePasswordPage.class, null);
                break;
            case R.id.suggest_submit_rl:
                mActivity.changeSubFragment(this, FeedBackPage.class, null);
                break;

            case R.id.about_teme_rl:
//                mActivity.changeSubFragment(this, AboutPage.class, null);
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("userAccount", "18739980800");//
                    jsonObject.put("password", "111111");//
                    jsonObject.put("androidID", "11");
                    jsonObject.put("method", "UserService.login");
                    jsonObject.put("timestamp", TimeUtils.getSystemTime(TimeUtils.FMT));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                showLoading("登录中...");
                Subscription subscribe = GOEFactory.getSingleton().login(GOEApp.encryptionRequestparam(jsonObject.toString()))
                        .throttleFirst(500, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<ResultWrap<ResposeWrap<UserBean>>>() {
                            @Override
                            public void onCompleted() {
                                hideLoading();
                            }

                            @Override
                            public void onError(Throwable e) {
                                if (!NetUtils.isNetworkConnected(getContext())) {
                                    showToast("请检查网络");
                                }
                            }

                            @Override
                            public void onNext(ResultWrap<ResposeWrap<UserBean>> userBeanResultWrap) {
                                toggleShowLoading(false, null);
                            }
                        });
                mCompositeSubscription.add(subscribe);
                break;
            case R.id.clear_cache_rl: // 清理缓存
                if (folderSize > 0) {
                    try {
                        ClearCacheManager.cleanExternalCache(mActivity);
//                        ClearCacheManager.cleanCustomCache(FileUtils.getDiskCacheDir(mActivity, AppConstants.CacheName).getAbsolutePath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    showToast("清理成功");
                    cacheSizeTv.setText("");
                } else {
                    showToast("没有缓存");
                }

                break;
//            case R.id.logout_rl: //
//                break;
            case R.id.check_up_version:
//                OtherEngine.getInstance().checkAppVersion(mActivity,true);
                showLoading("测试");
                Subscription subscribe1 = Observable
                        .create(new Observable.OnSubscribe<Integer>() {
                            @Override public void call(Subscriber<? super Integer> subscriber) {
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                subscriber.onCompleted();
                            }
                        })
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Integer>() {
                            @Override public void onCompleted() {
                                hideLoading();
                                LogUtil.e(TAG_LOG, "subscribe onCompleted");
                            }

                            @Override public void onError(Throwable e) {
                                LogUtil.e(TAG_LOG, "subscribe onError");
                            }

                            @Override public void onNext(Integer integer) {
                                LogUtil.e(TAG_LOG, "subscribe onNext");
                            }
                        });
                mCompositeSubscription.add(subscribe1);
                break;
            default:
                break;
        }
    }

    @Override protected View getLoadingTargetView() {
        return vsv_lodding_target_view;
    }

    @Override
    protected void processLogic() {
        checkTv.setText("检查更新" + "（版本号：" + AppUtils.getAppVersionName(mActivity) + "）");
        try {
            folderSize = ClearCacheManager.getFolderSize(FileUtils.getDiskCacheDir(mActivity));
            cacheSizeTv.setText(ClearCacheManager.getFormatSize(folderSize));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_myself_setting;
    }
}
