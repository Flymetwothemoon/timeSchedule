package com.example.module_health.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StepService extends Service {
    public StepService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}