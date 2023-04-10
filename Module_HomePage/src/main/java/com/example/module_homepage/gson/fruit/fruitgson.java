package com.example.module_homepage.gson.fruit;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class fruitgson implements Serializable {

    @SerializedName("code")
    public Integer code;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public DataDTO data;

    public static fruitgson objectFromData(String str) {

        return new Gson().fromJson(str, fruitgson.class);
    }
}
