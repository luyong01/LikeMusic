package com.ranze.maincomponent.router;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.component.annotations.Component;
import com.ranze.componentservice.router.component.ComponentName;
import com.ranze.componentservice.router.component.main.MainComponent;
import com.ranze.componentservice.router.component.main.service.MainService;
import com.ranze.maincomponent.router.path.PathConstants;

/**
 * Created by ranze on 2018/2/4.
 */

@Component(name = ComponentName.MAIN)
public class MainComponentImpl extends MainComponent {
    MainService mainService;

    @Override
    public MainService getMainService() {
        return mainService != null ? mainService : (mainService = (MainService) ARouter.getInstance()
                .build(PathConstants.SERVICE_MAIN).navigation());
    }
}
