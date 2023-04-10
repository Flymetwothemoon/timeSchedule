package com.example.module_homepage.utils;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.module_homepage.activity.EnterActivity;
import com.example.module_homepage.adapter.name;
import com.example.module_homepage.adapter.nameAdapter;
import com.example.module_homepage.gson.DataDTO;
import com.example.module_homepage.gson.ListDTO;
import com.example.module_homepage.gson.gsonname;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogRecord;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class sendOkHttp {
    public void send(String name, int i, List<name> mList, nameAdapter adapter, EnterActivity activity,boolean w) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("https://www.mxnzp.com/api/food_heat/food/search?keyword="+name
                        +"&page=1&app_id=icwnrnfenlpvforw&app_secret=N1BEY0R5ZkVMM1B0b2t6R3F6YkVzZz09").get().build();

                    mList.clear();
                    adapter.notifyItemRangeRemoved(0, adapter.getItemCount());


                try {

                    Response response = null;
                    response = okHttpClient.newCall(request).execute();
                    Response finalResponse = response;

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(finalResponse.isSuccessful()){

                                Gson gson = new Gson();

                                DataDTO dataDTO = null;
                                try {



                                    gsonname gsonname = gson.fromJson(finalResponse.body().string(),gsonname.class);

                                    Log.d("wode",""+gsonname.data);
                                    DataDTO dataDTO1 = gsonname.data;
                                    if(dataDTO1==(null)){
                                        return;
                                    }


                                        List<ListDTO> listDTO = dataDTO1.list;

//                                    String id = listDTO.get(0).foodId;
//                                    Log.d("wode",id);


                                        Log.d("wode", "" + w);

//                                        if (listDTO==null) {
//                                            mList.clear();
//                                            adapter.notifyItemRangeRemoved(0, adapter.getItemCount());
//                                        } else {
                                            for (int i = 0; i < listDTO.size(); i++) {
                                                String name = listDTO.get(i).name;
                                                String foodId = listDTO.get(i).foodId;
                                                name what = new name();
                                                what.name = name;
                                                what.nameId = foodId;
                                                Log.d("wode", foodId);
                                                mList.add(what);
                                                adapter.notifyDataSetChanged();
                                            }
//                                        }

                                    Log.d("wode","大小"+name.length());
                                    Log.d("wode","大小"+name);
//                                    if(name.length()==1){
//                                        mList.clear();
//                                        adapter.notifyItemRangeRemoved(0, adapter.getItemCount());
//                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });
        thread.start();
    }
}

