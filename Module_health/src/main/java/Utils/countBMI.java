package Utils;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.davistin.widget.RulerView;
import com.example.module_health.R;

public class countBMI {

    public static void showHeight(TextView heightText, RulerView height) {
        Log.d("TAG2","VALUE"+1233);

            height.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
                @Override
                public void onValueChange(float value) {
                heightText.setText(String.valueOf(value));
                    Log.d("TAG2","VALUE"+value);
                }

            });

    }
    public static void showWeight(TextView weightText,RulerView weight){

                weight.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
                    @Override
                    public void onValueChange(float value) {
                    weightText.setText(String.valueOf(value));
                    }
                });


    }
}
