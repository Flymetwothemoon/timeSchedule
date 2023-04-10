package com.example.module_homepage.gson.get;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class GiDTO implements Serializable {
    @SerializedName("value")
    public String value;
    @SerializedName("label")
    public String label;

    public static GiDTO objectFromData(String str) {

        return new Gson().fromJson(str, GiDTO.class);
    }
}
