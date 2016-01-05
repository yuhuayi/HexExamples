package com.hexdo.hexexamples.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import app.newbee.lib.netstatus.NetUtils;
import app.newbee.lib.util.PreferencesUtils;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能综述：引导用户熟悉软件
 *
 * @author Administrator
 */
public class GuideActivity extends BaseActivity {
    private ViewPager viewPager;

    private List<View> viewList;            // Tab页面列表

    //    private int[] imageIds = new int[]{R.drawable.help_one, R.drawable.help_two, R.drawable.help_three};
    private int[] imageIds = new int[]{};

    @Override protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override protected TransitionMode getOverridePendingTransitionMode() {
        return null;
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
        return R.layout.activity_guide;
    }

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override protected void processLogic(Bundle savedInstanceState) {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewList = new ArrayList<View>();

        for (int i = 0; i < imageIds.length; i++) {
            View view = View.inflate(this, R.layout.item_guide, null);
            view.setBackgroundResource(imageIds[i]);

            viewList.add(view);
            if ((imageIds.length - 1) == i) {
                view.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        PreferencesUtils.putBoolean(GuideActivity.this, "firstIn", false);
                        gotoSubActivity(MainActivity.class, null);
                        finish();
                    }
                });
            }
        }

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override public int getCount() {
                return viewList.size();
            }

            @Override public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override public void destroyItem(ViewGroup container, int position,
                                              Object object) {
                container.removeView(viewList.get(position));
            }

            @Override public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }
        };

        viewPager.setAdapter(pagerAdapter);
    }

    @Override protected void setListener() {

    }

    @Override protected boolean isApplyKitKatTranslucency() {
        return true;
    }

}
