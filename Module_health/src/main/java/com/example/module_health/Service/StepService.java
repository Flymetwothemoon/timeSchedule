package com.example.module_health.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class StepService extends Service {
    private SensorManager sensorManager;
    private Sensor sensor;
    private int mCount =0 ;
    private SensorEventListener mSensorEventListener;

    private final IBinder mBinder = new LocalBinder();
    public class LocalBinder extends Binder {
        public StepService getService() {
            return StepService.this;
        }
        public int getCount(){
            Log.d("step3",String.valueOf(mCount));
            return mCount;
        }

    }
    public StepService() {

    }
    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mSensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.sensor.getType()==Sensor.TYPE_STEP_COUNTER)
                {
                    mCount++;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorManager.registerListener(mSensorEventListener,sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        sensorManager.unregisterListener(this);
    }
}