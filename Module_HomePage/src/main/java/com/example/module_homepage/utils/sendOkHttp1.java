package com.example.module_homepage.utils;

import androidx.fragment.app.FragmentActivity;

import com.example.module_homepage.activity.EnterActivity;
import com.example.module_homepage.adapter.diet;
import com.example.module_homepage.adapter.dietAdapter;
import com.example.module_homepage.adapter.name;
import com.example.module_homepage.adapter.nameAdapter;
import com.example.module_homepage.gson.fruit.DataDTO;
import com.example.module_homepage.gson.fruit.ListDTO;
import com.example.module_homepage.gson.fruit.fruitgson;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class sendOkHttp1 {
    public void send(List<diet> mList, dietAdapter adapter, FragmentActivity activity,String i){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("https://www.mxnzp.com/api/food_heat/food/list?id="+i+"&page=1&app_id=icwnrnfenlpvforw&app_secret=N1BEY0R5ZkVMM1B0b2t6R3F6YkVzZz09")
                        .get().build();
                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()){
                        Gson gson = new Gson();

                        String responseString = response.body().string();

                            anysle_0(gson, responseString, activity, mList, adapter);



                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
      thread.start();
    }
    private void anysle_0(Gson gson,String responseString,FragmentActivity activity,List<diet> mList
    ,dietAdapter adapter){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fruitgson fruitgson = gson.fromJson(responseString, com.example.module_homepage.gson.fruit.fruitgson.class);
                DataDTO dataDTO = fruitgson.data;
                for(int i = 0;i<dataDTO.list.size();i++){
                    diet diet = new diet();
                    diet.calory = dataDTO.list.get(i).calory;
                    diet.foodId = dataDTO.list.get(i).foodId;
                    diet.healthLevel = String.valueOf(dataDTO.list.get(i).healthLevel);
                    diet.name = dataDTO.list.get(i).name;
                    mList.add(diet);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

}
