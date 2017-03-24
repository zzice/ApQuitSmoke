package com.z.ice.zutilslib.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * desc: 应用程序Activity管理类：用于Activity管理和应用程序退出
 * date: 2017/2/14
 * author: Zice
 */
public class ActivityManagerUtil {

    private static Stack<Activity> activityStack = new Stack<>();

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(Activity activity) {
        activityStack.push(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public static Activity currentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public static void finishCurrentActivity() {
        Activity activity = activityStack.pop();
        activity.finish();
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (Activity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public static void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager manager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            manager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据业务需求添加 无该需求时可delete
     */
    private static Stack<Activity> devDetailStack = new Stack<>();

    /**
     * 根据业务需求添加 无该需求时可delete
     * 添加DevDetailActivity到堆栈
     */
    public static void addDevDetailActivity(Activity activity) {
        devDetailStack.push(activity);
    }

    /**
     * 根据业务需求添加 无该需求时可delete
     * 结束所有DevDetailActivity
     */
    public static void finishAllDevDetailActivity() {
        for (Activity activity : devDetailStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        devDetailStack.clear();
    }
}
