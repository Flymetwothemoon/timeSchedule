package com.example.module_homepage.gson.search;

import java.util.List;

public class DataDTO {
    @com.google.gson.annotations.SerializedName("page")
    public Integer page;
    @com.google.gson.annotations.SerializedName("totalCount")
    public Integer totalCount;
    @com.google.gson.annotations.SerializedName("totalPage")
    public Integer totalPage;
    @com.google.gson.annotations.SerializedName("limit")
    public Integer limit;
    @com.google.gson.annotations.SerializedName("list")
    public List<ListDTO> list;

    public static DataDTO objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, DataDTO.class);
    }
}
