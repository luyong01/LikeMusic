package com.ranze.maincomponent.router.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.componentservice.router.component.main.service.MainService;
import com.ranze.maincomponent.router.path.PathConstants;

/**
 * Created by ranze on 2018/2/4.
 */

@Route(path = PathConstants.SERVICE_MAIN)
public class MainServiceImpl implements MainService {

    @Override
    public void init(Context context) {

    }

    @Override
    public void startMainActivity() {
        ARouter.getInstance().build(PathConstants.VIEW_MAIN).navigation();
    }

    @Override
    public void startLoginActivity() {
        ARouter.getInstance().build(PathConstants.VIEW_LOGIN).navigation();
    }
}
