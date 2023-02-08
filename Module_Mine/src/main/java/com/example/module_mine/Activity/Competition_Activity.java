package com.example.module_mine.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.module_mine.R;
import com.example.module_mine.fragment.Five_Fragment;
import com.example.module_mine.fragment.OneFive_Fragment;
import com.example.module_mine.fragment.OneThousandFragment;
import com.example.module_mine.fragment.One_Fragment;
import com.example.module_mine.fragment.Seven_Five_Fragment;
import com.example.module_mine.fragment.Three_Fragment;

public class Competition_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        init();
    }
    private void init(){
        Intent intent = getIntent();
        String a = intent.getStringExtra("fang");
        if(a.equals("1000")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new OneThousandFragment()).commit();
        }
        else if(a.equals("1500")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new OneFive_Fragment()).commit();
        }
        else if(a.equals("3000")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Three_Fragment()).commit();
        }
        else if(a.equals("5000")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Five_Fragment()).commit();
        }
        else if(a.equals("7500")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Seven_Five_Fragment()).commit();
        }
        else if(a.equals("10000")){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new One_Fragment()).commit();
        }
    }
}