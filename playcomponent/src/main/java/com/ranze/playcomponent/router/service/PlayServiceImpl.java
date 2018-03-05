package com.ranze.playcomponent.router.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.componentservice.router.component.play.service.PlayService;
import com.ranze.playcomponent.PlayBarFragment;
import com.ranze.playcomponent.router.path.PathConstants;

import java.util.List;

/**
 * Created by ranze on 2018/3/3.
 */
@Route(path = PathConstants.SERVICE_PLAY)
public class PlayServiceImpl implements PlayService {
    @Override
    public void init(Context context) {

    }

    public PlayBarFragment getPlayBarFragment() {
        return PlayBarFragment.getInstance(null);
    }

    @Override
    public void play(int id, List<Integer> playingIds) {
        LogUtil.d("id = " + id
                + ", ids = " + playingIds);
        getPlayBarFragment().play(id, playingIds);
    }
}
