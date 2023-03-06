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
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/log/log1")
public class LogActivity extends FragmentActivity implements View.OnClickListener {
    private Button log;
    private Button see;
    private TextView Logon;
    private TextView forget;
    public int i = 0;
    private EditText password_edit;
    private EditText id_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_log);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        init();
    }

    private void init() {
        log = findViewById(R.id.Log_button);
        see = findViewById(R.id.see_button);
        id_edit = findViewById(R.id.id_edit);
        forget = findViewById(R.id.forget_text);
        Logon = findViewById(R.id.Logon_text);
        password_edit = findViewById(R.id.password_edit);

        log.setOnClickListener(this);
        forget.setOnClickListener(this);
        Logon.setOnClickListener(this);
        see.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Log_button&&(!(password_edit.getText().toString().equals(""))&&(!id_edit.getText().toString().equals("")))){
            ARouter.getInstance().build("/main/main1").navigation();
            finish();
        }
        else if(v.getId() == R.id.Log_button&&(password_edit.getText().toString().equals("")||id_edit.getText().toString().equals(""))){
            Toast.makeText(this,"你的账号或密码为空,请填写",Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.see_button) {
            int selectionStart = password_edit.getSelectionStart();
            int selectionEnd = password_edit.getSelectionEnd();
            if (i % 2 == 0) {
                see.setBackground(getResources().getDrawable(R.drawable.see));
                i++;
                password_edit.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else if (i % 2 != 0) {
                see.setBackground(getResources().getDrawable(R.drawable.unsee));
                i++;
                password_edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            password_edit.setSelection(selectionStart, selectionEnd);
        }
        if (v.getId() == R.id.Logon_text) {
            Intent intent = new Intent(LogActivity.this,LogonActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.forget_text){
            Intent intent = new Intent(LogActivity.this,ForgetActivity.class);
            startActivity(intent);
        }
    }
}