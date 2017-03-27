package com.z.ice.apquitsmoke.di.component;

import com.z.ice.apquitsmoke.app.App;
import com.z.ice.apquitsmoke.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * desc: AppComponent
 * date: 2017/3/27
 * author: Zice
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    //提供App的Context
    App getContext();

}
