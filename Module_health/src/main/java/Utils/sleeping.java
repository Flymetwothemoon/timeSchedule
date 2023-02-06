package Utils;

import static android.content.Context.MODE_PRIVATE;
import static Utils.changeTextStyle.change;
import static Utils.changeTextStyle.change_1;
import static Utils.changeTime.changeHour;
import static Utils.changeTime.changeMinute;
import static Utils.equalTime.timeEqual;
import static Utils.music.music_0;
import static Utils.paintAlbum.paint;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.module_health.R;
import com.example.module_health.Service.MusicService;

public class sleeping {
    public static void whenSleeping(int[]hour, int hourOfDay, int []minute1, int minute, View view, TextView mTextView_3, Activity activity){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hour[0] = hourOfDay;
                minute1[0] = minute;
                Log.d("TAG111",""+hour[0]+minute1[0]);
                int a = hour[0];
                int b = minute1[0];
                SharedPreferences.Editor editor = view.getContext().getSharedPreferences("bmi",MODE_PRIVATE).edit();
                editor.putInt("hour",(hourOfDay));
                editor.putInt("minute",(minute));
                editor.commit();
                if(timeEqual(a,b)){
                   music_0(view,activity);
                }
                mTextView_3.setText(String.valueOf(changeHour(a)+":"+changeMinute(b)));
                Toast.makeText(view.getContext(),"将会于"+String.valueOf(changeHour(a)+":"+changeMinute(b))+"提醒你睡觉",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
