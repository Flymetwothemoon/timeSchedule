package com.example.module_health.service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class StepService extends Service implements SensorEventListener {
    /**
     * 传感器管理对象
     */
    private SensorManager sensorManager;
    private Sensor sensorOrientation;
    /**
     * 每次第一次启动记步服务时是否从系统中获取了已有的步数记录
     */
    private boolean hasRecord = false;
    /**
     * 当前所走的步数
     */
    private int CURRENT_STEP ;
    private UpdateUiCallBack mCallback;

    /**
     * 注册UI更新监听
     *
     * @param paramICallback
     */
    public void registerCallback(UpdateUiCallBack paramICallback) {
        this.mCallback = paramICallback;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                startStepDetector();
            }
        }).start();
    }
    /**
     * 向Activity传递数据的纽带
     */
    public class StepBinder extends Binder {

        /**
         * 获取当前service对象
         *
         * @return StepService
         */
        public StepService getService() {
            return StepService.this;
        }
    }
    public StepService() {
    }
    /**
     * 获取当前步数
     *
     * @return
     */
    public int getStepCount() {
        Log.d("TAG1","hi"+String.valueOf(CURRENT_STEP));
        return CURRENT_STEP;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    /**
     * 初始化传感器
     */
    private void startStepDetector() {
        if (sensorManager != null) {
            sensorManager = null;
        }
        //1.获取传感器管理对象SensorManager
        sensorManager = (SensorManager) this
                .getSystemService(SENSOR_SERVICE);
        //2.获取指定类型的传感器
        //每次用户迈步时，步测器传感器都会触发事件。延迟时间预计将低于 2 秒。
        sensorOrientation = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        Log.d("TAG1","HI");
        //注册要监听的sensor
        sensorManager.registerListener( StepService.this, sensorOrientation, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //当有数据到来时会调用onSensorChanged 方法
    @Override
    public void onSensorChanged(SensorEvent event) {
    CURRENT_STEP++;
        Log.d("TAG1",String.valueOf(CURRENT_STEP));
        Toast.makeText(getApplicationContext(),String.valueOf(CURRENT_STEP),Toast.LENGTH_SHORT).show();
    }
    //当精度发生变化的时候做的事情
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
