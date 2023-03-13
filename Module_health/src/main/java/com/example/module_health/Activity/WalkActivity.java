package com.example.module_health.Activity;
;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.MapsInitializer;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.example.module_health.R;
import com.example.module_health.Service.APSService;
import com.example.module_health.Service.StepService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import Utils.AMapHolder;
import Utils.AMapMyLocationStyleHolder;

public class WalkActivity extends AppCompatActivity implements ServiceConnection {
    private Handler handle = new Handler();
    AMap aMap;
    MyLocationStyle myLocationStyle;
    private StepService mService;
    private TextView stepcount_text;
    StepService.LocalBinder binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_walk);
        MapView mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        aMap = mapView.getMap();
        myLocationStyle = new MyLocationStyle();

        AMapHolder.setAMap(aMap);
        AMapMyLocationStyleHolder.setaMapMyLocationStyleHolder(myLocationStyle);
        AMapLocationClient.updatePrivacyShow(getApplicationContext(),true,true);
        AMapLocationClient.updatePrivacyAgree(getApplicationContext(),true);
        aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位
        getLocation();

        getStep();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授权了位置权限，开始定位
               handle.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       Intent intent = new Intent(WalkActivity.this,
                               APSService.class);
                       startService(intent);
                       Log.d("service1","gogogo");
                   }
               },1000);

                    }

            } else {
                // 用户拒绝了位置权限，提示用户无法定位
                Toast.makeText(this, "无法获取位置信息，请授权位置权限", Toast.LENGTH_LONG).show();
            }

        }


    private void getLocation(){
        if (ContextCompat.checkSelfPermission(WalkActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                  != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(WalkActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            1);
                }

            }


    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        binder = (StepService.LocalBinder)iBinder;
        mService = binder.getService();

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
    private void getStep(){
        stepcount_text = findViewById(R.id.stepcount_text);
        Intent intent = new Intent(WalkActivity.this,StepService.class);
        startService(intent);
        bindService(intent,this,Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        int count = binder.getCount();
                        runOnUiThread(() -> stepcount_text.setText(String.valueOf(count)));
                    }
                };
                Timer timer = new Timer();
                timer.schedule(timerTask, 5000, 1000);
            }
        });
        thread.start();


    }
}


