package com.z.ice.zutilslib.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * desc: SharedPreferenceUtil
 * date: 2017/3/27
 * author: Zice
 */
public class SharedPreferenceUtil {


    private static final String APP_SP_NAME = "app_sp";

    public static SharedPreferences getAppSp(Context context) {
        return context.getSharedPreferences(APP_SP_NAME, Context.MODE_PRIVATE);
    }


}
