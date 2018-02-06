package com.ranze.likemusic;

import com.ranze.componentservice.app.BaseCommonApplication;

/**
 * Created by ranze on 2018/2/5.
 */

public class App extends BaseCommonApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouterAndComponent(BuildConfig.DEBUG);
    }
}
