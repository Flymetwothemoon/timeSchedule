package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/log/log1")
public class LogActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText account;
    private EditText password;
    private Button log;
    private TextView email;
    private TextView logon;
    private TextView forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        init();
        log.setOnClickListener(this);
    }
    private void init(){
        account = findViewById(R.id.Account_edit);
        password = findViewById(R.id.password_edit);
        log = findViewById(R.id.Log_button);
        email = findViewById(R.id.text_email);
        logon = findViewById(R.id.login_text);
        forget = findViewById(R.id.text_forget);
    }

    @Override
    public void onClick(View v) {
        if(account.getText().toString().equals("1")&&password.getText().toString().equals("2")){
            ARouter.getInstance().build("/main/main1").navigation();
        }
    }
}