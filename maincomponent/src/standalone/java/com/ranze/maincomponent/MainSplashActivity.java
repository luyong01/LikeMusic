package com.ranze.maincomponent;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ranze.component.api.ComponentManager;
import com.ranze.componentservice.app.BaseCommonActivity;
import com.ranze.componentservice.router.component.ComponentName;
import com.ranze.componentservice.router.component.main.MainComponent;

/**
 * Created by ranze on 2018/2/4.
 */

public class MainSplashActivity extends BaseCommonActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincomponent_activity_splash);

        findViewById(R.id.startMainActivity).setOnClickListener((view) -> {
            try {
                MainComponent mainComponent = (MainComponent) ComponentManager.getInstance().getComponent(ComponentName.MAIN);
                mainComponent.getMainService().startMainActivity();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }
}
