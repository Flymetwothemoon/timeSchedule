package com.example.module_health.Indentify.Gson;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class usual implements Serializable {


    @SerializedName("log_id")
    public Long logId;
    @SerializedName("result_num")
    public Integer resultNum;
    @SerializedName("result")
    public List<ResultDTO> result;

    public static usual objectFromData(String str) {

        return new Gson().fromJson(str, usual.class);
    }
}
