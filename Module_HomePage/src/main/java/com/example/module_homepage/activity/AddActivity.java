package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.module_homepage.R;

import java.util.Timer;
import java.util.TimerTask;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_water; // 饮水量输入框
    private Button tv_finish; // 完成按钮
    private Button btn_50;
    private Button btn_100;
    private Button btn_200;
    private TextView iv_back; // 取消

    private int water_number;

    //喝水 多了
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        ed_water = findViewById(R.id.ed_water);
        tv_finish = findViewById(R.id.tv_finish);
        iv_back = findViewById(R.id.iv_back);
        btn_50 = findViewById(R.id.btn_50);
        btn_100 = findViewById(R.id.btn_100);
        btn_200 = findViewById(R.id.btn_200);
        btn_50.setOnClickListener(this);
        btn_100.setOnClickListener(this);
        btn_200.setOnClickListener(this);
        tv_finish.setOnClickListener(this);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_finish) {
            if (TextUtils.isEmpty(ed_water.getText())) {
                Toast.makeText(AddActivity.this, "饮水量不可为空",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            if (Integer.parseInt(ed_water.getText().toString()) > 1500 ||
                    Integer.parseInt(ed_water.getText().toString()) < 0) {
                Toast.makeText(AddActivity.this, "饮水量不符合实际",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("text", Context.MODE_PRIVATE);
            water_number = Integer.parseInt(sharedPreferences.getString("text", "0"));
            water_number += Integer.parseInt(ed_water.getText().toString());
            if(water_number>=1500){
                water_number=1500;
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("text", String.valueOf(water_number));
            editor.commit();

            Intent intent = new Intent(AddActivity.this, DrinkActivity.class);
            startActivity(intent);
        } else if (id == R.id.iv_back) {
            AddActivity.this.finish();
        } else if (id == R.id.btn_50) {
            ed_water.setText("50");
        } else if (id == R.id.btn_100) {
            ed_water.setText("100");
        } else if (id == R.id.btn_200) {
            ed_water.setText("200");
        }
    }
}