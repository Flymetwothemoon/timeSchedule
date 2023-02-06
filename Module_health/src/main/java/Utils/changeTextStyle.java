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
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), "Source_Han_Serif_SC_Light_Light.otf");
        mText.setTypeface(customFont);
    }
    public static void change_2(TextView mText,Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(),"Alimama_DongFangDaKai_Regular.ttf");
        mText.setTypeface(customFont);
    }
}
