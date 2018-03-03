package com.ranze.playcomponent.router.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.componentservice.router.component.play.service.PlayService;
import com.ranze.playcomponent.PlayBarFragment;
import com.ranze.playcomponent.router.path.PathConstants;

/**
 * Created by ranze on 2018/3/3.
 */
@Route(path = PathConstants.SERVICE_PLAY)
public class PlayServiceImpl implements PlayService {
    @Override
    public void init(Context context) {

    }

    public PlayBarFragment getPlaybarFragment() {
        return (PlayBarFragment) ARouter.getInstance().build(PathConstants.VIEW_PLAYBAR).navigation();
    }
}
