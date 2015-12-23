package com.hexdo.hexexamples;

import android.app.Activity;
import android.app.Application;
import android.os.StrictMode;
import com.hexdo.hexexamples.model.UserBean;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.LinkedList;
import java.util.List;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

public class HexApp extends Application {


    // 退出应用程序,销毁Activity相关
    public static List<Activity> activitys = null;
    /**
     * 开发版本 true, 生产版本 false
     */
    public static boolean develop_flag = true;
    private static HexApp _instance;
    public UserBean currentUser;
    private RefWatcher _refWatcher;

    public static RefWatcher getRefWatcher() {
        return HexApp.get()._refWatcher;
    }

    public static HexApp get() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        activitys = new LinkedList<Activity>();
        _instance = (HexApp) getApplicationContext();
        /**
         * 检测内存泄露的
         */
        _refWatcher = LeakCanary.install(this);

        enabledStrictMode();
    }

    /**
     * 开启严格模式
     */
    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll()  //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
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

}
