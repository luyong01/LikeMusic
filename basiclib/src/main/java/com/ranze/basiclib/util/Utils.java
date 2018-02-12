package com.ranze.basiclib.util;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * Created by luyong01 on 2018/2/12.
 */

public class Utils {
    // 保存全局的ApplicationContext
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static Context getContext() {
        return sContext;
    }
}
