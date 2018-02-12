package com.ranze.basiclib.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyong01 on 2018/2/12.
 */

public class SPUtil {
    private volatile static SPUtil sSPUtil;

    private Map<String, SharedPreferences> mSpMap;

    public static final String SP_DEFAULT = "sp_default";


    private SPUtil() {
        mSpMap = new HashMap<>();
    }

    public static SPUtil getInstance() {
        if (sSPUtil == null) {
            synchronized (SPUtil.class) {
                if (sSPUtil == null) {
                    sSPUtil = new SPUtil();
                }
            }
        }
        return sSPUtil;
    }

    public SharedPreferences sharedPreferences() {
        return sharedPreferences(SP_DEFAULT);

    }

    public SharedPreferences sharedPreferences(String nameOfSp) {
        SharedPreferences sp = mSpMap.get(nameOfSp);
        if (sp == null) {
            sp = Utils.getContext().getSharedPreferences(nameOfSp, Context.MODE_PRIVATE);
        }
        return sp;
    }

}
