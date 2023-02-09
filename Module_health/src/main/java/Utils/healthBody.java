package Utils;

import static android.content.Context.MODE_PRIVATE;
import static Utils.changeTextStyle.change_2;
import static Utils.countBMI.showHeight;
import static Utils.countBMI.showWeight;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.davistin.widget.RulerView;
import com.example.module_health.R;

public class healthBody {
    public static void knowYourBmi(Activity activity, TextView height_0, TextView weight_0, RulerView height, RulerView weight, Button enter_0,Button enter_1){
        Dialog dialog = new Dialog(activity, R.style.ActionSheetDialogStyle);
        View inflater =  LayoutInflater.from(activity).inflate(R.layout.openbutton, null);
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
        height_0 = inflater.findViewById(R.id.height_0);
        weight_0 = inflater.findViewById(R.id.weight_0);
        TextView text_weight = inflater.findViewById(R.id.textWeight);
        TextView text_height = inflater.findViewById(R.id.textHeight);
        change_2(height_0,inflater.getContext());
        change_2(weight_0,inflater.getContext());
        change_2(text_height,inflater.getContext());
        change_2(text_weight,inflater.getContext());
        height = inflater.findViewById(R.id.rulerView_height);
        weight = inflater.findViewById(R.id.rulerView_weight);
        TextView height_text = inflater.findViewById(R.id.textHeight);
        TextView weight_text = inflater.findViewById(R.id.textWeight);
        enter_0 = inflater.findViewById(R.id.enter_0);
        enter_1 = inflater.findViewById(R.id.enter_1);
        int[] cnt = {0};
        showHeight(height_text,height);
        showWeight(weight_text,weight);
        enter_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height_0 = height_text.getText().toString();
                Log.d("TAG222","HEIGHT"+height_0);
                cnt[0]+=1;
                Log.d("TAG12","ha"+cnt[0]);
                SharedPreferences.Editor editor = inflater.getContext().getSharedPreferences("bmi",MODE_PRIVATE).edit();
                editor.putString("height",height_0);
                editor.commit();
            }
        });
        enter_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight_0 = weight_text.getText().toString();
                SharedPreferences.Editor editor = inflater.getContext().getSharedPreferences("bmi",MODE_PRIVATE).edit();
                cnt[0]+=1;
                Log.d("TAG12","hah"+cnt[0]);
                editor.putString("weight",weight_0);
                Log.d("TAG222","WEIGHT"+weight_0);
                editor.commit();
            }
        });
        Log.d("TAG12",""+cnt[0]);

    }
}
