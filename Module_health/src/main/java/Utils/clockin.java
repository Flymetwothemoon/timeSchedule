package Utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.module_health.R;

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

    }
}
