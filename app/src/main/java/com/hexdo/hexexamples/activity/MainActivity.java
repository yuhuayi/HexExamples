package com.hexdo.hexexamples.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.newbee.lib.base.BaseFragmentActivity;
import app.newbee.lib.netstatus.NetUtils;
import butterknife.Bind;
import butterknife.OnClick;
import com.hexdo.hexexamples.GOEApp;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.mainPage.HomePage;
import com.hexdo.hexexamples.activity.mainPage.MySelfPage;
import com.hexdo.hexexamples.activity.mainPage.ShoppingCartPage;
import com.hexdo.hexexamples.activity.mainPage.TryWearingGlassesPage;

import java.util.HashMap;

/**
 * 主页面
 */
public class MainActivity extends BaseFragmentActivity {
    private static final String TAG = "MainActivity";
    public Fragment tab0Page;
    public Fragment tab1Page;
    public Fragment tab2Page;
    public Fragment tab3Page;
    public FragmentManager fragmentManager;
    @Bind(R.id.tab0_View) ImageView tab0View;
    @Bind(R.id.tab0_bottom_view) View tab0BottomView;
    @Bind(R.id.tab1_View) ImageView tab1View;
    @Bind(R.id.tab1_bottom_view) View tab1BottomView;
    @Bind(R.id.tab2_View) ImageView tab2View;
    @Bind(R.id.tab2_bottom_view) View tab2BottomView;
    @Bind(R.id.tab3_View) ImageView tab3View;
    @Bind(R.id.tab3_bottom_view) View tab3BottomView;
    @Bind(R.id.main_content) FrameLayout main_content;
    @Bind(R.id.webus_bottom_layout) LinearLayout teme_bottom_layout;
    private HashMap<String, Fragment> fragmentMap = new HashMap<String, Fragment>();
    /**
     * 捕捉返回事件按钮 因为此 Activity 继承 TabActivity 用 onKeyDown 无响应，所以改用
     * dispatchKeyEvent 一般的 Activity 用 onKeyDown 就可以了
     */
    private long exitTime = 0;

    @OnClick({R.id.tab0_View, R.id.tab1_View, R.id.tab2_View, R.id.tab3_View}) void bottomClick(View view) {
        switch (view.getId()) {
            case R.id.tab0_View:
                setTabSelection(0);
                break;
            case R.id.tab1_View:
                setTabSelection(1);
                break;
            case R.id.tab2_View:
                setTabSelection(2);
                break;
            case R.id.tab3_View:
//                if (StringUtils.isEmpty(GOEApp.get().getCurrentUser().getUid())) {
//                    Bundle bundle = new Bundle();
//                    bundle.putBoolean("isFromMian", true);
//                    gotoSubActivity(StartActivity.class, LoginFragment.class.getName(), bundle);
//                    return;
//                }
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     */
    public void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        main_content.setVisibility(View.VISIBLE);
        teme_bottom_layout.setVisibility(View.VISIBLE);
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        main_content.setVisibility(View.VISIBLE);
        switch (index) {
            case 0:
                tab0View.setImageResource(R.drawable.icon_home_yes);
                tab0BottomView.setVisibility(View.VISIBLE);
                if (tab0Page == null) {
                    tab0Page = new HomePage();
                    transaction.add(R.id.main_content, tab0Page);
                } else {
                    transaction.show(tab0Page);
                }
                break;
            case 1:
                tab1View.setImageResource(R.drawable.icon_xunlian_yes);
                tab1BottomView.setVisibility(View.VISIBLE);
                if (tab1Page == null) {
                    tab1Page = new TryWearingGlassesPage();
                    transaction.add(R.id.main_content, tab1Page);
                } else {
                    transaction.show(tab1Page);
                }
                break;
            case 2:
                tab2View.setImageResource(R.drawable.icon_my_yes);
                tab2BottomView.setVisibility(View.VISIBLE);
                if (tab2Page == null) {
                    tab2Page = new ShoppingCartPage();
                    transaction.add(R.id.main_content, tab2Page);
                } else {
                    transaction.show(tab2Page);
                }
                break;
            case 3:
                tab3View.setImageResource(R.drawable.icon_my_yes);
                tab3BottomView.setVisibility(View.VISIBLE);
                if (tab3Page == null) {
                    tab3Page = new MySelfPage();
                    transaction.add(R.id.main_content, tab3Page);
                } else {
                    transaction.show(tab3Page);
                }
                break;
            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        try {

            tab0View.setImageResource(R.drawable.icon_home_not);
            tab1View.setImageResource(R.drawable.icon_xunlian_no);
            tab2View.setImageResource(R.drawable.icon_my_no);
            tab3View.setImageResource(R.drawable.icon_my_no);

            tab0BottomView.setVisibility(View.GONE);
            tab1BottomView.setVisibility(View.GONE);
            tab2BottomView.setVisibility(View.GONE);
            tab3BottomView.setVisibility(View.GONE);
        } catch (Resources.NotFoundException e) { //会OOM
            e.printStackTrace();
        }
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (tab0Page != null) {
            transaction.hide(tab0Page);
        }
        if (tab1Page != null) {
            transaction.hide(tab1Page);
        }
        if (tab2Page != null) {
            transaction.hide(tab2Page);
        }
        if (tab3Page != null) {
            transaction.hide(tab3Page);
        }
    }

    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (fragmentManager.getBackStackEntryCount() > 0) {
                closeSoftInputMethod(teme_bottom_layout);
                fragmentManager.popBackStackImmediate();
                return true;
            } else if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                exitApp();
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setTabSelection(0);
    }

    /**
     * 退出程序
     */
    private void exitApp() {
        // 判断2次点击事件时间
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToast("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            GOEApp.get().exit();
            finish();
            overridePendingTransition(0, R.anim.app_exit);
        }
    }

    @Override protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override protected void getBundleExtras(Bundle extras) {

    }

    @Override protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override protected void onNetworkDisConnected() {

    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override protected void processLogic() {
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
        Intent intent = getIntent();
        if (intent != null) {

        }
        // UpdateVersionUtil.checkNewAPPVersion(this, false);
    }

}
