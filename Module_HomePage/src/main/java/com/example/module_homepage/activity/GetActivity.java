package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.module_homepage.R;
import com.example.module_homepage.adapter.get;
import com.example.module_homepage.adapter.getAdapter;
import com.example.module_homepage.utils.sendOkHttp2;

import java.util.ArrayList;
import java.util.List;

public class GetActivity extends AppCompatActivity {
private List<get>mList = new ArrayList<>();
private RecyclerView glycemicInfoDatarecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_get);
        init();
    }
    private void init(){
        glycemicInfoDatarecycler = findViewById(R.id.glycemicInfoDatarecycler);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.d("id1",id);
        getAdapter getAdapter = new getAdapter(GetActivity.this,mList);
        new sendOkHttp2().send(id,GetActivity.this,getAdapter,mList);
        glycemicInfoDatarecycler.setLayoutManager(new LinearLayoutManager(this));
        glycemicInfoDatarecycler.setAdapter(getAdapter);
    }
}