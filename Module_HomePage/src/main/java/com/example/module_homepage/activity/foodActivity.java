package com.example.module_homepage.activity;

import static com.example.module_homepage.utils.changeTextStyle.change;
import static com.example.module_homepage.utils.changeTextStyle.change_2;
import static com.example.module_homepage.utils.changeTextStyle.change_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_homepage.R;

public class foodActivity extends AppCompatActivity {
    private TextView foodname;
    private TextView food_text;
    private ImageView  food_imag;
    private TextView introduce;
    private TextView best_match;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        Intent intent = getIntent();
        float bmi = intent.getFloatExtra("bmi_0",0);
        Log.d("TAG555",""+bmi);
        foodname = findViewById(R.id.foodname);
        food_text = findViewById(R.id.food_text);
        food_imag = findViewById(R.id.food_image);
        introduce = findViewById(R.id.introduce);
        best_match = findViewById(R.id.bestmatch);
        change(best_match,this);
        int food = intent.getIntExtra("food",-1);
        if(food==0){
            foodname.setText("早餐");
            if(bmi>24){
                food_text.setText("鸡蛋+牛奶");
                food_imag.setImageResource(R.mipmap.breakfast_0);
                introduce.setText("对于bmi较高的群体来说,早餐要有足量优质蛋白质的摄入量，以保证生命活动的需要");
            }
            else if(bmi>=18.5){
                food_text.setText("椰奶燕麦粥+煎鸡蛋+水煮菠菜");
                food_imag.setImageResource(R.mipmap.breakfast_1);
                introduce.setText("对于bmi适中的群体来说,早餐要摄入足量的糖分与维生素,帮助身体在一天中以更好的状态进行社会活动");
            }
            else{
                food_text.setText("胡萝卜玉米排骨汤");
                food_imag.setImageResource(R.mipmap.breakfast_2);
                introduce.setText("对于bmi较低的群体来说,早餐不仅仅要补充营养还要增强食欲");
            }

        } else if(food==1){
            foodname.setText("午餐");
            if(bmi>24){
                food_text.setText("香菇炒肉+杂粮饭");
                food_imag.setImageResource(R.mipmap.lunch_0);
                introduce.setText("对于bmi较高的群体来说,午餐要减少高油、高糖、高盐食物的摄入,避免过量能量摄入");
            }
            else if(bmi>=18.5){
                food_text.setText("青椒炒墨鱼+土豆炖鸡");
                food_imag.setImageResource(R.mipmap.lunch_1);
                introduce.setText("对于bmi适中的群体来说,午餐应该是做到均衡,品种要多、丰富,一般建议要做到主食要有,然后荤菜、素菜、水果,或者是各种粗杂粮、豆制品要比较丰富");
            }
            else{
                food_text.setText("清蒸鲈鱼");
                food_imag.setImageResource(R.mipmap.lunch_2);
                introduce.setText("对于bmi较低的群体来说,午餐应宜食高热量食物,如谷类食物和高脂肪食物。谷类食物是人体能量的主要来源,高脂肪食物能量密度较高");
            }
        } else if(food==2){
            foodname.setText("晚餐");
            if(bmi>24){
                food_text.setText("丝瓜豆腐鸡蛋汤");
                food_imag.setImageResource(R.mipmap.dinner_0);
                introduce.setText("对于bmi较高的群体来说,晚餐摄入适量的维生素,膳食纤维来补充身体所需的能量");
            }
            else if(bmi>=18.5){
                food_text.setText("豆腐杂菜");
                food_imag.setImageResource(R.mipmap.dinner_1);
                introduce.setText("对于bmi适中的群体来说,晚餐要摄入足量的蛋白质,补充能量提高免疫力");
            }
            else{
                food_text.setText("南瓜小米粥+主食");
                food_imag.setImageResource(R.mipmap.dinner_2);
                introduce.setText("对于bmi较低的群体来说,晚餐主食不可少,选择含纤维和碳水化合物多的食物晚餐时应有两种以上的蔬菜，面食可适量减少，适当吃些粗粮");
            }
        }
        change_2(foodname,this);
        change(food_text,this);
        change(introduce,this);
    }
}