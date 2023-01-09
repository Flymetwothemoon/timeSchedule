package Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class style {
    public static void changeStyle_0(Context context, TextView textView){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), "TsangerYuYangT_W03_W03.ttf");
        textView.setTypeface(customFont);

    }
    public static void changeStyle_1(Context context,TextView textView){
        Typeface customFont_1 = Typeface.createFromAsset(context.getAssets(),"Alimama_ShuHeiTi_Bold.ttf");
        textView.setTypeface(customFont_1);
    }
    public static void changeStyle_2(Context context,TextView textView){
        Typeface customFont_2  = Typeface.createFromAsset(context.getAssets(),"zcool-gdh_Regular.ttf");
        textView.setTypeface(customFont_2);
    }
}
