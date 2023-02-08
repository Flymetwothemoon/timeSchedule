package com.example.module_mine.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.example.module_mine.R;
import com.example.module_mine.fragment.achievementFragment;
import com.example.module_mine.fragment.competitionFragment;
import com.example.module_mine.fragment.friendFragment;
import com.example.module_mine.fragment.manageFragment;
import com.example.module_mine.fragment.myactivityFragment;
import com.example.module_mine.fragment.nameFragment;
import com.example.module_mine.fragment.pictureFragment;
import com.example.module_mine.fragment.sumFragment;

public class Module_MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_mine);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        skip();
    }
    private void skip(){
        String id = getIntent().getStringExtra("TAG");
        Log.d("TAG2",id);
        if(id.equals("circle")){

            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new pictureFragment()).commit();
        }
        if(id.equals("name")){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new nameFragment()).commit();
        }
        if(id.equals("award")){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new achievementFragment()).commit();
        }
        if(id.equals("competition")){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new competitionFragment()).commit();
        }
        if(id.equals("friend")){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new friendFragment()).commit();
        }
        if(id.equals("sum")){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new sumFragment()).commit();
        }
        if(id.equals("activity")){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new myactivityFragment()).commit();
        }
        if(id.equals("manage")){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity,new manageFragment()).commit();
        }
    }
}