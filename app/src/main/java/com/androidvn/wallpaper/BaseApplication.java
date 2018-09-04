package com.androidvn.wallpaper;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.androidvn.wallpaper.data.local.ApplicationModules;

import javax.inject.Inject;

public class BaseApplication extends Application {

    public static BaseApplication instance;

    public static BaseApplication getInstance(){
        if (null == instance){
            instance = new BaseApplication();
        }
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ApplicationModules.getInstances().initData(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getAppContext() {
        return instance.getApplicationContext();
    }

}
