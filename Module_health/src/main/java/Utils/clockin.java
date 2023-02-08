package Utils;

import static Utils.changeTextStyle.change;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.module_health.R;

import java.util.Calendar;

public class clockin {
    public static void clockIn(Activity activity) {
        Dialog dialog = new Dialog(activity, R.style.ActionSheetDialogStyle);
        View inflater = LayoutInflater.from(activity).inflate(R.layout.clockin, null);
        dialog.setContentView(inflater);
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
        //宽度填充当前布局文件宽度
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
        Button attendance_1 = inflater.findViewById(R.id.attendance_1);
        TextView attendance_0 = inflater.findViewById(R.id.attendance_0);
        SharedPreferences sharedPreferences = inflater.getContext().getSharedPreferences("bmi",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = inflater.getContext().getSharedPreferences("bmi", Context.MODE_PRIVATE).edit();
        int data = sharedPreferences.getInt("clockData",0);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        if(data==day){
            attendance_0.setText("今日已完成打卡");
            change(attendance_0,inflater.getContext());
        }
        else{
            editor.remove("clockData");
        }
        change(attendance_0,inflater.getContext());
        attendance_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        attendance_0.setText("今日已完成打卡");
                        change(attendance_0,inflater.getContext());
                        editor.putInt("clockData",day);
                        editor.commit();
                    }
        });
    }
    public static void advice(Activity activity){
        Dialog dialog = new Dialog(activity, R.style.ActionSheetDialogStyle);
        View inflater = LayoutInflater.from(activity).inflate(R.layout.advice, null);
        dialog.setContentView(inflater);
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
        //宽度填充当前布局文件宽度
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框;
        SharedPreferences sharedPreferences = inflater.getContext().getSharedPreferences("bmi",Context.MODE_PRIVATE);
        String height =sharedPreferences.getString("height","");
        String weight = sharedPreferences.getString("weight","");
        Log.d("TAG222",""+height);
        Log.d("TAG222",""+weight);
        TextView textView_0 =inflater.findViewById(R.id.text_0);
        if(height.length()>=1&&weight.length()>=1) {
            Log.d("TAG222", "weight" + weight);
            Log.d("TAG222", "height" + height);
            float height_0 = Float.parseFloat(height) / 100;
            Log.d("TAG222","qw"+height_0);
            if (height_0 < 1) {
                height_0 = 1;
            }
            float weight_0 = Float.parseFloat(weight);
            if (height == null) {
               textView_0.setText("请先完成身体质量指数界面");
            } else {
                float a = weight_0 / (height_0 * height_0);
                if(a<18.5){
                    textView_0.setText("营养不良");
                }
                else if(a>=18.5&&a<=24){
                    textView_0.setText("正常");
                }
                else{
                    textView_0.setText("超重");
                }
                change(textView_0, dialog.getContext());

            }
        }
    }
}
