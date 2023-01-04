package com.example.module_health.save;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface stepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(step step);
    @Update
    public void getUpData(step step);
    @Query("select * from step")
    LiveData<List<step>> getAll();
}
