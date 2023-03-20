package com.example.module_health.Indentify.Gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ResultDTO implements Serializable {
    @SerializedName("score")
    public Double score;
    @SerializedName("root")
    public String root;
    @SerializedName("baike_info")
    public BaikeInfoDTO baikeInfo;
    @SerializedName("keyword")
    public String keyword;

    public static ResultDTO objectFromData(String str) {

        return new Gson().fromJson(str, ResultDTO.class);
    }
}
