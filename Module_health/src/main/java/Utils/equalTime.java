package Utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.Calendar;

public class equalTime {

    private static boolean a = false;
    public static boolean timeEqual(int hour,int minute){

        Calendar calendar =Calendar.getInstance();
        int TrueHour = calendar.get(Calendar.HOUR_OF_DAY);
        int TrueMinute = calendar.get(Calendar.MINUTE);
        Log.d("TAG111","HOUR"+TrueHour+"minute"+TrueMinute);
        if(hour==TrueHour&&TrueMinute==minute){
            a = true;
        }
        return a;
    }
}
