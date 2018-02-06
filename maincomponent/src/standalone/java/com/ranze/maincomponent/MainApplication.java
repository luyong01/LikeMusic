package com.ranze.maincomponent;

import com.ranze.componentservice.app.BaseCommonApplication;

/**
 * Created by ranze on 2018/2/4.
 */

public class MainApplication extends BaseCommonApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouterAndComponent(BuildConfig.DEBUG);
    }
}
