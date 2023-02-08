package Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class changeTextStyle {
    public static void change(TextView mText, Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), "TsangerYuYangT_W04_W04.ttf");
        mText.setTypeface(customFont);
    }
    public static void change_1(TextView mText, Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), "Alimama_ShuHeiTi_Bold.ttf");
        mText.setTypeface(customFont);
    }
}
