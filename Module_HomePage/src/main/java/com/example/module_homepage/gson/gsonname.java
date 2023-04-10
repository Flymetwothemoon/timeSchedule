package com.example.module_homepage.gson;

public class gsonname {

    @com.google.gson.annotations.SerializedName("code")
    public Integer code;
    @com.google.gson.annotations.SerializedName("msg")
    public String msg;
    @com.google.gson.annotations.SerializedName("data")
    public DataDTO data;

    public static gsonname objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, gsonname.class);
    }
}
