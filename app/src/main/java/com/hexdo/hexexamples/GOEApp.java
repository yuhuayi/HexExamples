package com.hexdo.hexexamples;

import android.app.Activity;
import android.app.Application;
import app.newbee.lib.util.DesCoder;
import app.newbee.lib.util.LogUtil;
import com.hexdo.hexexamples.model.UserBean;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.LinkedList;
import java.util.List;

public class GOEApp extends Application {


    // 退出应用程序,销毁Activity相关
    public static List<Activity> activitys = null;
    private static GOEApp _instance;
    private RefWatcher _refWatcher;
    public UserBean currentUser;
    /**
     * 开发版本 true, 生产版本 false
     */
    public static boolean develop_flag = true;

    public static GOEApp get() {
        return _instance;
    }

    public static RefWatcher getRefWatcher() {
        return GOEApp.get()._refWatcher;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        activitys = new LinkedList<Activity>();
        _instance = (GOEApp) getApplicationContext();
        /**
         * 检测内存泄露的
         */
        _refWatcher = LeakCanary.install(this);

    }

    public UserBean getCurrentUser() {
        if (currentUser == null) {
            currentUser = new UserBean();
            currentUser.setUid("");
        }
        return currentUser;
    }



    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (activitys != null && activitys.size() > 0) {
            if (!activitys.contains(activity)) {
                activitys.add(activity);
            }
        } else {
            activitys.add(activity);
        }
    }

    public void removeActivity(Activity activity) {
        if (activitys != null) {
            if (activitys.contains(activity)) {
                activitys.remove(activity);
            }
        }
    }

    // 遍历所有Activity并finish
    public void exit() {
        if (activitys != null && activitys.size() > 0) {
            for (Activity activity : activitys) {
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }
    public static String encryptionRequestparam(String query) {
        String encrypt_Key = DesCoder.encode(GOEConstants.encrypt_Key, query);
        LogUtil.info("加密前: " + query);
        LogUtil.info("加密后: " + DesCoder.encode(GOEConstants.encrypt_Key, encrypt_Key));
        return encrypt_Key;
    }

}
