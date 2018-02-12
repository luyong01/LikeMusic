package com.ranze.likemusic;

import com.facebook.stetho.Stetho;
import com.ranze.basiclib.util.Utils;
import com.ranze.componentservice.app.BaseCommonApplication;

/**
 * Created by ranze on 2018/2/5.
 */

public class App extends BaseCommonApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouterAndComponent(BuildConfig.DEBUG);

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

        Utils.init(getApplicationContext());

    }
}
