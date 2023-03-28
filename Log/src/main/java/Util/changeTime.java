package Util;

import android.app.Activity;
import android.widget.TextView;

import com.example.log.ForgetActivity;
import com.example.log.LogonActivity;

import java.util.Timer;
import java.util.TimerTask;

public class changeTime {
    public static void changeTime_0(TextView time,Activity activity){
        final int[] num = {61};
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                num[0]--;
               activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time.setText(String.valueOf(num[0]));
                        time.setClickable(false);
                        if(num[0]==0){
                            time.setClickable(true);
                            timer.cancel();
                            time.setText("发送");
                        }
                    }
                });
            }
        },0,1000);
    }
    public static void changeTime_1(TextView time, Activity activity){
        final int[] num = {61};
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                num[0]--;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time.setText(String.valueOf(num[0]));
                        time.setClickable(false);
                        if(num[0]==0){
                            time.setClickable(true);
                            timer.cancel();
                            time.setText("发送");
                        }
                    }
                });
            }
        },0,1000);
    }
}
