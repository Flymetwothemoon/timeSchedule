package com.example.module_homepage.utils;

import android.app.Activity;
import android.util.Log;

import com.example.module_homepage.adapter.get;
import com.example.module_homepage.adapter.getAdapter;
import com.example.module_homepage.gson.get.DataDTO;
import com.example.module_homepage.gson.get.GiDTO;
import com.example.module_homepage.gson.get.getgson;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class sendOkHttp2 {
    public void send(String id, Activity activity, getAdapter adapter, List<get>mList){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("https://www.mxnzp.com/api/food_heat/food/details?foodId="+id+"&page=1&app_id=pllnhenkv7llpont" +
                        "&app_secret=ZkppYnhGb25QMXhwdXYyOVErM1h3UT09").get().build();
                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()){
//                        Log.d("id1",response.body().string());
                        Gson gson = new Gson();
                        String s = response.body().string();
                        sendA(s,activity,adapter,gson,mList);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    private void sendA(String s,Activity activity,getAdapter adapter,Gson gson,List<get>mList){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getgson getgson = gson.fromJson(s, com.example.module_homepage.gson.get.getgson.class);
                DataDTO dataDTO = getgson.data;
                get get = new get();
                get.name = dataDTO.name;
                get.calory = dataDTO.calory;
                Log.d("id1",get.calory);
                get.tips = dataDTO.healthTips;
                get.suggets = dataDTO.healthSuggest;
                GiDTO giDTO = dataDTO.glycemicInfoData.gi;
                get.GIDTO = giDTO.label;
                get.GiDTO = giDTO.value;
                mList.add(get);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
