package com.example.log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import Fragment.*;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/log/log1")
public class LogActivity extends FragmentActivity implements View.OnClickListener {
    private TextView email;
    private TextView logon;
    private TextView forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log);
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            //透明状态栏
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getSupportFragmentManager().beginTransaction().replace(R.id.logactivity, new Log_Fragment()).commit();
            init();
    }
        private void init(){
            email = findViewById(R.id.text_email);
            logon = findViewById(R.id.login_text);
            forget = findViewById(R.id.forget_text);
            email.setOnClickListener(this);
            logon.setOnClickListener(this);
            forget.setOnClickListener(this);

        }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.forget_text){
            getSupportFragmentManager().beginTransaction().replace(R.id.logactivity,new Forget_Fragment()).commit();
        }
        if(v.getId()==R.id.login_text){
            Intent intent = new Intent(LogActivity.this,LogonActivity.class);
            startActivity(intent);
            finish();
        }

        if(v.getId()==R.id.text_email){
            getSupportFragmentManager().beginTransaction().replace(R.id.logactivity,new Note_Fragment()).commit();
        }
    }
}
