package com.ranze.maincomponent.data;

import com.ranze.maincomponent.data.bean.PlayListBean;

import io.reactivex.Flowable;

/**
 * Created by ranze on 2018/2/13.
 */

public interface MainDataSource {
    Flowable<PlayListBean> loadPlayList(int uid);

    Flowable<Boolean> login(String phone, String password);
}
