package com.example.module_mine.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.module_mine.R;

public class Rule_Activity extends AppCompatActivity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        init();
    }
    private void init(){
        mTextView = findViewById(R.id.textview);
        writeTextView();
        changeTextViewStyle();
    }

    private void changeTextViewStyle() {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"TsangerYuYangT_W02_W02.ttf");
        mTextView.setTypeface(typeface);
    }

    private void writeTextView(){
        mTextView.setText("当累计步数在0-40000之间时为铜牌\n当累计步数在40000-120000之间时为银牌\n" +
                "当累计步数超过120000时为金牌\n每次我的成就会选择优先级最高的\n" +
                "获奖优先级:金牌>银牌>铜牌");
    }
}