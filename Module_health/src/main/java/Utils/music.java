package Utils;

import static Utils.paintAlbum.paint;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.core.app.NotificationCompat;

import com.example.module_health.R;
import com.example.module_health.Service.MusicService;

public class music {
    public static void music_0(View view, Activity activity){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NotificationChannel channel = new NotificationChannel("Message", "通知", NotificationManager.IMPORTANCE_HIGH);
                NotificationManager manager = (NotificationManager)view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);
                Notification notification = new NotificationCompat.Builder(view.getContext(),"Message")
                        .setContentTitle("TimeSchedule")   //用于指定通知的标题内容，下拉系统状态栏就可以看到这部分内容
                        .setContentText("睡觉的时间到了")  //用于指定通知的正文内容，下拉系统状态栏就可以看到这部分内容。
                        .setWhen(System.currentTimeMillis())//用于指定通知被创建的时间，以毫秒为单位，下拉系统状态栏，这里指定的时间会显示在相应的通知上。
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .build();
                manager.notify(1,notification);
                Dialog dialog = new Dialog(view.getContext(),R.style.ActionSheetDialogStyle);
                View inflater =  LayoutInflater.from(view.getContext()).inflate(R.layout.openmusic, null);
                paint(inflater,"open");
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
                Intent intent = new Intent(inflater.getContext(), MusicService.class);
                inflater.getContext().startService(intent);
                Button button = inflater.findViewById(R.id.button_0);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        inflater.getContext().stopService(intent);
                        paint(inflater,"stop");
                    }
                });
            }
        });

    }
}
