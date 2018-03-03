package com.ranze.componentservice.router.component.play.service;

import android.support.v4.app.Fragment;

import com.ranze.componentservice.router.component.BaseService;

import java.util.List;

/**
 * Created by ranze on 2018/3/3.
 */

public interface PlayService extends BaseService {
    Fragment getPlaybarFragment();

    void play(int id, List<Integer> playingIds);
}
