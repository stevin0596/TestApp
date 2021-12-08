package com.msd.base;

import android.app.Application;
import android.util.Log;

/**
 * author : Android
 * time   : 2021/08/27
 * desc   :
 * version: 1.0
 */
public class CommonApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        Log.d("css","CommonApp onCreate()");
    }
}
