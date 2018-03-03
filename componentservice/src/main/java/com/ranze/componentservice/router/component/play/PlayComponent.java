package com.ranze.componentservice.router.component.play;

import com.ranze.componentservice.router.component.BaseComponent;
import com.ranze.componentservice.router.component.play.service.PlayService;

/**
 * Created by ranze on 2018/3/3.
 */

public abstract class PlayComponent extends BaseComponent {
    public abstract PlayService getPlayService();

}
