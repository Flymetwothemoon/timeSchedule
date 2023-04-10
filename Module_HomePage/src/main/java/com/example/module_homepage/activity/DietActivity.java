package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.module_homepage.R;
import com.example.module_homepage.fragment.FruitFragment;
import com.example.module_homepage.fragment.MainFragment_0;
import com.example.module_homepage.fragment.drink_0Fragment;

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_diet);
        Intent intent = getIntent();
        String fruit = intent.getStringExtra("fruit");

        if(fruit.equals("fruit")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, FruitFragment.newInstance("1","2")).commit();
        }
        else if(fruit.equals("drink")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new drink_0Fragment()).commit();
        }
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new MainFragment_0()).commit();
        }

    }
}