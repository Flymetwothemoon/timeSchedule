package com.example.module_health.save;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class stepRepository {
    public stepDao mDao;
    public LiveData<List<step>> mAllStep;
    public LiveData<List<step>>mUpData;
    AppDatabase database;
    stepRepository(Context context){
        database = com.example.module_health.save.AppDatabase.getInstance(context.getApplicationContext());
        mDao = database.mDao();
        mAllStep = database.mDao().getAll();
    }
    void insert(step step){
        database.databaseWriteExecutor.execute(()-> mDao.insert(step));
    }
    void updata(step step){
        database.databaseWriteExecutor.execute(()-> mDao.getUpData(step));
    }
    LiveData<List<step>>getAllStep(){
        return mAllStep;
    }
}
