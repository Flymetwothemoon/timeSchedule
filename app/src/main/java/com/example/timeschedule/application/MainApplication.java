package com.example.timeschedule.application;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();

        }
        ARouter.init(this);
        Log.d("TAG","feng");
    }


}
