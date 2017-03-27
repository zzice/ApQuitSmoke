package com.z.ice.apquitsmoke.app;

import android.app.Application;

import com.z.ice.apquitsmoke.di.component.AppComponent;
import com.z.ice.apquitsmoke.di.component.DaggerAppComponent;
import com.z.ice.apquitsmoke.di.module.AppModule;

/**
 * desc: App
 * date: 2017/3/23
 * author: Zice
 */
public class App extends Application {

    private static App instance;
    public static AppComponent mAppComponent;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(instance)).build();
        }
        return mAppComponent;
    }
}
