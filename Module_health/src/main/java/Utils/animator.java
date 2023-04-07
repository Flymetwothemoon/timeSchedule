package Utils;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.ImageView;

public class animator {
    public static void makeAlpha(ImageView str){

        ObjectAnimator animator = ObjectAnimator.ofFloat(str, "alpha", 1f, 0.4f, 1f);
        animator.setDuration(12000);
        animator.setRepeatCount(-1);
        animator.start();
    }
    public static void makeScaleX(ImageView str){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(str,"scaleX",1,2,1);
        animator1.setDuration(35000);
        animator1.setRepeatCount(-1);
        animator1.start();
    }
    public static void makeTranslationY(ImageView str){
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(str,"translationY",15,0,15);
        animator2.setDuration(7000);
        animator2.setRepeatCount(-1);
        animator2.start();
    }
    public static void makeTranslationX(Button str){
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(str,"translationX",-15,480,-15);
        animator3.setDuration(100000);
        animator3.setRepeatCount(-1);
        animator3.start();
    }
    public static void makeRotationY(ImageView str){
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(str,"rotationY",0,360);
        animator4.setDuration(13000);
        animator4.setRepeatCount(-1);
        animator4.start();
    }
    public static void makeRotationX(ImageView str){
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(str,"rotationX",0,360);
        animator5.setDuration(11000);
        animator5.setRepeatCount(-1);
        animator5.start();
    }
    public static void makeAlpha1(Button str) {
        ObjectAnimator animator6 = ObjectAnimator.ofFloat(str, "alpha", 1f, 0.6f, 1f);
        animator6.setDuration(2000);
    }
}
