package com.example.module_health.save;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {step.class}, version = 6, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase instance;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);
    static AppDatabase getInstance(final Context context){
        if(instance ==null){
            synchronized (AppDatabase.class){
                if(instance==null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"data").build();
                }
            }
        }
        return instance;
    }
    public abstract stepDao mDao();
}
