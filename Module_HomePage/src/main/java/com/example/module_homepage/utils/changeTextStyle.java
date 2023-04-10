package com.example.module_homepage.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class changeTextStyle {
    public static void change(TextView mText,TextView drinktext,TextView fruit_text,TextView food_text,
                              TextView todayrecipe,TextView introduce,Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), "TsangerYuYangT_W04_W04.ttf");
        mText.setTypeface(customFont);
        fruit_text.setTypeface(customFont);
        food_text.setTypeface(customFont);
        todayrecipe.setTypeface(customFont);
        introduce.setTypeface(customFont);
        drinktext.setTypeface(customFont);
    }
    public static void change_1(TextView mText, Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), "Source_Han_Serif_SC_Light_Light.otf");
        mText.setTypeface(customFont);
    }
    public static void change_2(TextView mText,TextView recipe_1,TextView recipe_1name,
                              TextView more, TextView cooktime_1,TextView yellowfishtext,
                                TextView cooktime_0,TextView whathard_0,
                                TextView menu_0,TextView menu_1,TextView hard_1,
                                TextView zhajiangnoodleText,
                                TextView recipe_0name, Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(),"Alimama_DongFangDaKai_Regular.ttf");
        mText.setTypeface(customFont);
        recipe_1.setTypeface(customFont);
        recipe_1name.setTypeface(customFont);
        more.setTypeface(customFont);
        cooktime_1.setTypeface(customFont);
        yellowfishtext.setTypeface(customFont);
        cooktime_0.setTypeface(customFont);
        whathard_0.setTypeface(customFont);
        menu_0.setTypeface(customFont);
        menu_1.setTypeface(customFont);
        hard_1.setTypeface(customFont);
        zhajiangnoodleText.setTypeface(customFont);
        recipe_0name.setTypeface(customFont);
    }
    public static void change_3(TextView mText,Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(),"DingTalk_JinBuTi_Regular.woff");
        mText.setTypeface(customFont);
    }
}
