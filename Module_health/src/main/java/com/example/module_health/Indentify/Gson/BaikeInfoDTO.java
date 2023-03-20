package com.example.module_health.Indentify.Gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class BaikeInfoDTO implements Serializable {
    @SerializedName("baike_url")
    public String baikeUrl;
    @SerializedName("image_url")
    public String imageUrl;
    @SerializedName("description")
    public String description;

    public static BaikeInfoDTO objectFromData(String str) {

        return new Gson().fromJson(str, BaikeInfoDTO.class);
    }
}
