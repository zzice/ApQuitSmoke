package com.z.ice.apquitsmoke.di.component;

import com.z.ice.apquitsmoke.app.App;
import com.z.ice.apquitsmoke.di.module.AppModule;
import com.z.ice.apquitsmoke.di.module.HttpModule;
import com.z.ice.apquitsmoke.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * desc: AppComponent
 * date: 2017/3/27
 * author: Zice
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    //提供App的Context
    App getContext();

    //提供http的帮助类
    RetrofitHelper retrofitHelper();
}
