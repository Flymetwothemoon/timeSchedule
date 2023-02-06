package Utils;

import static Utils.changeTextStyle.change;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
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
}
