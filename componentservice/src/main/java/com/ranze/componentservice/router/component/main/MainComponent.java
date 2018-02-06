package com.ranze.componentservice.router.component.main;

import com.ranze.componentservice.router.component.BaseComponent;
import com.ranze.componentservice.router.component.main.service.MainService;

/**
 * Created by ranze on 2018/2/4.
 */

public abstract class MainComponent extends BaseComponent {
    public abstract MainService getMainService();

}
