package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.module_homepage.R;
import com.example.module_homepage.fragment.breadFragment;
import com.example.module_homepage.fragment.drinkFragment;
import com.example.module_homepage.fragment.mainFragment;
import com.example.module_homepage.fragment.sweetFragment;
import com.example.module_homepage.fragment.threefoodFragment;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView threefood;
    private ImageView bread;
    private ImageView sweet;
    private ImageView mainfood;
    private ImageView drink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new threefoodFragment()).commit();
        init();
    }
    private void init(){
        threefood = findViewById(R.id.three_food);
        bread = findViewById(R.id.bread);
        sweet = findViewById(R.id.sweet);
        mainfood = findViewById(R.id.mainfood);
        drink = findViewById(R.id.drink);

        threefood.setOnClickListener(this);
        bread.setOnClickListener(this);
        sweet.setOnClickListener(this);
        mainfood.setOnClickListener(this);
        drink.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.three_food){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new threefoodFragment()).commit();
        }
        if(view.getId()==R.id.bread){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new breadFragment()).commit();
        }
        if(view.getId()==R.id.sweet){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new sweetFragment()).commit();
        }
        if(view.getId()==R.id.mainfood){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new mainFragment()).commit();
        }
        if(view.getId()==R.id.drink){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new drinkFragment()).commit();
        }
    }
}