package com.ranze.basiclib.config;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyong01 on 2018/2/12.
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
