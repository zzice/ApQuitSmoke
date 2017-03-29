package com.z.ice.apquitsmoke.di.component;

import android.app.Activity;

import com.z.ice.apquitsmoke.di.module.ActivityModule;
import com.z.ice.apquitsmoke.di.scope.ActivityScope;
import com.z.ice.apquitsmoke.ui.launch.LaunchActivity;

import dagger.Component;

/**
 * desc: ActivityComponent.java
 * date: 2017/3/27
 * author: Zice
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(LaunchActivity launchActivity);

    //void inject(MainActivity mainActivity);

   /* void inject(ZhihuDetailActivity zhihuDetailActivity);

    void inject(ThemeActivity themeActivity);

    void inject(SectionActivity sectionActivity);

    void inject(RepliesActivity repliesActivity);

    void inject(NodeListActivity nodeListActivity);*/
}
