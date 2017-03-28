package com.z.ice.apquitsmoke.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.z.ice.apquitsmoke.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * desc: FragmentModule.java
 * date: 2017/3/28
 * author: ZhaoBing
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
