package com.z.ice.apquitsmoke.di.module;

import android.app.Activity;

import com.z.ice.apquitsmoke.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * desc: ActivityModule.java
 * date: 2017/3/27
 * author: Zice
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity() {
        return mActivity;
    }
}
