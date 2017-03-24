package com.z.ice.apquitsmoke.app;

import android.app.Application;

/**
 * desc: App
 * date: 2017/3/23
 * author: Zice
 */
public class App extends Application {

    private static App instance;

    public static synchronized App getInstance() {
        return instance;
    }
}
