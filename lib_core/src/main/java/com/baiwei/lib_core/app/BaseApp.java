package com.baiwei.lib_core.app;

import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
