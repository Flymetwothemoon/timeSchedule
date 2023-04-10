package com.example.module_homepage.gson.search;

public class ListDTO {
    @com.google.gson.annotations.SerializedName("foodId")
    public String foodId;
    @com.google.gson.annotations.SerializedName("name")
    public String name;
    @com.google.gson.annotations.SerializedName("healthLevel")
    public Integer healthLevel;
    @com.google.gson.annotations.SerializedName("calory")
    public String calory;

    public static ListDTO objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, ListDTO.class);
    }
}
