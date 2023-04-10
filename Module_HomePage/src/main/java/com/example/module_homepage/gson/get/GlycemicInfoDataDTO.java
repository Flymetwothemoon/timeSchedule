package com.example.module_homepage.gson.get;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class GlycemicInfoDataDTO implements Serializable {
    @SerializedName("gi")
    public GiDTO gi;
    @SerializedName("gl")
    public GlDTO gl;

    public static GlycemicInfoDataDTO objectFromData(String str) {

        return new Gson().fromJson(str, GlycemicInfoDataDTO.class);
    }
}
