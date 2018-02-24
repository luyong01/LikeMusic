package com.ranze.maincomponent.data.local;

import com.ranze.maincomponent.data.MainDataSource;
import com.ranze.maincomponent.data.bean.PlayListBean;

import io.reactivex.Flowable;

/**
 * Created by ranze on 2018/2/13.
 */

public class MainLocalDataSource implements MainDataSource {
    private static MainLocalDataSource INSTANCE;

    public static MainLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Flowable<PlayListBean> loadPlayList(int uid) {
        return null;
    }

    @Override
    public Flowable<Boolean> login(String phone, String password) {
        return null;
    }
}
