package com.z.ice.apquitsmoke.di.module;

import com.z.ice.apquitsmoke.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * desc: AppModule
 * date: 2017/3/27
 * author: Zice
 */
@Module
public class AppModule {

    private App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return mApp;
    }
}
