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
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import Fragment.*;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/log/log1")
public class LogActivity extends FragmentActivity implements View.OnClickListener {
    private Button log;
    private Button see;
    public int i = 0;
    private EditText password_edit;
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
            init();
    }
        private void init(){
            log = findViewById(R.id.Log_button);
            see = findViewById(R.id.see_button);
            password_edit = findViewById(R.id.password_edit);
            log.setOnClickListener(this);
            see.setOnClickListener(this);
        }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Log_button){
            ARouter.getInstance().build("/main/main1").navigation();
        }
        if(v.getId()==R.id.see_button) {
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
    }
}
