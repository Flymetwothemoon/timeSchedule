package com.example.module_homepage.gson.fruit;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class DataDTO implements Serializable {
    @SerializedName("page")
    public Integer page;
    @SerializedName("totalCount")
    public Integer totalCount;
    @SerializedName("totalPage")
    public Integer totalPage;
    @SerializedName("limit")
    public Integer limit;
    @SerializedName("list")
    public List<ListDTO> list;

    public static DataDTO objectFromData(String str) {

        return new Gson().fromJson(str, DataDTO.class);
    }
}
