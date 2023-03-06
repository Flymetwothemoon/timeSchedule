package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private EditText mEditText_0;
    private EditText password_0;
    private EditText password_1;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        init();
    }
    private void init(){
        mButton = findViewById(R.id.button);
        mEditText_0 = findViewById(R.id.email);
        email = findViewById(R.id.word);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            Toast.makeText(this,"修改密码成功",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}