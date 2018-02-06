package com.ranze.maincomponent;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ranze.componentservice.app.BaseCommonActivity;
import com.ranze.maincomponent.router.path.PathConstants;

/**
 * Created by ranze on 2018/2/4.
 */

@Route(path = PathConstants.VIEW_MAIN)
public class MainActivity extends BaseCommonActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincomponent_activity_main);

    }
}
