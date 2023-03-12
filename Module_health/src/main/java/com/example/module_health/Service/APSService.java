package com.example.module_health.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.model.MyLocationStyle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class APSService extends Service implements AMapLocationListener {
    //AMapLocationClient是高德地图Android SDK中的一个定位客户端类，用于获取设备的地理位置信息。
    // 通过AMapLocationClient，你可以获取设备的经度、纬度、精度、速度、方向等位置信息，并且可以设置定位的模式、间隔时间等参数。
    public AMapLocationClient mlocationClient;
    ///声明mLocationOption对象
//    AMapLocationClientOption是高德地图Android SDK中的一个定位参数类，用于设置定位的各种参数。使用AMapLocationClientOption，
//    你可以设置定位的模式、定位间隔时间、是否需要地址信息、是否单次定位等参数。
//    以下是AMapLocationClientOption常用的参数及其含义：
//    setLocationMode：设置定位模式，包括高精度模式、仅设备模式、仅网络模式等。
//    setOnceLocation：设置是否单次定位，true表示单次定位，false表示连续定位。
//    setHttpTimeOut：设置定位超时时间，单位为毫秒。
//    setNeedAddress：设置是否需要返回地址信息，true表示需要，false表示不需要。
//    setInterval：设置定位间隔时间，单位为毫秒。
//    setGpsFirst：设置是否优先使用GPS进行定位，true表示优先使用GPS，false表示不优先使用。
//    setMockEnable：设置是否允许模拟位置，true表示允许，false表示不允许。
    public AMapLocationClientOption mLocationOption = null;
    @Override
    public void onCreate() {
        super.onCreate();
        startLocation();
    }
    private void startLocation() {
        //这块是蓝标
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        //初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(100); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。

        try {
            mlocationClient = new AMapLocationClient(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置定位监听
        mlocationClient.setLocationListener(this);
//初始化定位参数
        mLocationOption = new AMapLocationClientOption();
//设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setOnceLocation(false);
//设置是否为单次定位
        mLocationOption.setInterval(100);
//设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
// 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
// 在定位结束后，在合适的生命周期调用onDestroy()方法
// 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
//启动定位
        mlocationClient.startLocation();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                amapLocation.getLatitude();//获取纬度
                amapLocation.getLongitude();//获取经度
                amapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);//定位时间

            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }
}