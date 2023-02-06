package Utils;

import android.util.Log;

public class changeTime {
    public static String changeHour(int a){
        String a1;
        if(a/9<1||a==9){
            a1 = "0"+String.valueOf(a);
        }
        else{
            a1 = String.valueOf(a);
        }
        return a1;
    }
    public static String changeMinute(int b){
        Log.d("TAG111","B"+b);
        String a1;
        if(b/9<1||b==9){
            a1 = "0"+String.valueOf(b);
        }
        else {
            a1 = String.valueOf(b);
        }
        Log.d("TAG111","a1"+a1);
        return a1;
    }
}
