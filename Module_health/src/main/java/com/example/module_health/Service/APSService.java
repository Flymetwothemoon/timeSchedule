package com.example.module_health.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class APSService extends Service {
//    public AMapLocationClient mLocationClient = null;
//    //声明定位回调监听器
//    public AMapLocationListener mLocationListener = new AMapLocationListener();
//    public APSService() {
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
////初始化定位
//        mLocationClient = new AMapLocationClient(getApplicationContext());
////设置定位回调监听
//        mLocationClient.setLocationListener(mLocationListener);
//    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}