package com.example.module_health.save;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class step {
    @NonNull    //主键不能为null，必须添加这个注解
    @PrimaryKey(autoGenerate = true)    //主键是否自动增长，默认为false
    public int id;
    @ColumnInfo
    public String stepNumber;

}
