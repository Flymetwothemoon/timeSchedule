package com.example.module_homepage.utils;

import android.content.Context;

public class DensityUtils {
    public static int pxTodip(Context context, double pxValue) {
        final double density =
                context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / density + 0.5f);
    }
}
