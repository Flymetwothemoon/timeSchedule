package com.example.module_health.save;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class stepRepository {
    public stepDao mDao;
    public LiveData<List<step>> mAllStep;
    AppDatabase database;
    stepRepository(Context context){
        database = com.example.module_health.save.AppDatabase.getInstance(context.getApplicationContext());
        mDao = database.mDao();
        mAllStep = database.mDao().getAll();
    }
    void insert(step step){
        database.databaseWriteExecutor.execute(()-> mDao.insert(step));
    }
    LiveData<List<step>>getAllWords(){
        return mAllStep;
    }
}
