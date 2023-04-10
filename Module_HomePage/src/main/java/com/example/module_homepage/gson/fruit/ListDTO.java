package com.example.module_homepage.gson.fruit;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ListDTO implements Serializable {
    @SerializedName("foodId")
    public String foodId;
    @SerializedName("name")
    public String name;
    @SerializedName("healthLevel")
    public Integer healthLevel;
    @SerializedName("calory")
    public String calory;

    public static ListDTO objectFromData(String str) {

        return new Gson().fromJson(str, ListDTO.class);
    }
}
