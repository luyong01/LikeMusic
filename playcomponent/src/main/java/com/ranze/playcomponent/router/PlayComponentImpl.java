package com.ranze.playcomponent.router;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.component.annotations.Component;
import com.ranze.componentservice.router.component.ComponentName;
import com.ranze.componentservice.router.component.play.PlayComponent;
import com.ranze.componentservice.router.component.play.service.PlayService;
import com.ranze.playcomponent.router.path.PathConstants;

/**
 * Created by ranze on 2018/3/3.
 */
@Component(name = ComponentName.PLAY)
public class PlayComponentImpl extends PlayComponent {
    PlayService mPlayService;

    @Override
    public PlayService getPlayService() {
        return mPlayService != null ? mPlayService : (mPlayService = (PlayService) ARouter.getInstance()
                .build(PathConstants.SERVICE_PLAY).navigation());
    }
}
