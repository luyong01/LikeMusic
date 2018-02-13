package com.ranze.basiclib.config;

import android.content.SharedPreferences;

import com.ranze.basiclib.Constants;
import com.ranze.basiclib.util.SPUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ranze on 2018/2/12.
 */

public class ConfigData {
    private int userId;
    private Set<String> loginCookie;

    private static class Holder {
        private final static ConfigData sInstance = new ConfigData();
    }

    private ConfigData() {
        loginCookie = new HashSet<>();
    }

    public static ConfigData getInstance() {
        return Holder.sInstance;
    }

    public void init() {
        SharedPreferences sharedPreferences = SPUtil.getInstance().sharedPreferences();
        userId = sharedPreferences.getInt(Constants.SP_USER_UID, -1);
        loginCookie = sharedPreferences.getStringSet(Constants.SP_LOGIN_COOKIE, new HashSet<String>());
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<String> getLoginCookie() {
        return loginCookie;
    }

    public void setLoginCookie(Set<String> loginCookie) {
        this.loginCookie = loginCookie;
    }
}
