package com.ranze.maincomponent.data;

import android.support.annotation.NonNull;

import com.ranze.maincomponent.data.bean.PlayListBean;
import com.ranze.maincomponent.data.local.MainLocalDataSource;
import com.ranze.maincomponent.data.remote.MainRemoteDataSource;

import io.reactivex.Flowable;

/**
 * Created by ranze on 2018/2/13.
 */

public class MainRepository implements MainDataSource {
    private static MainRepository INSTANCE = null;

    private final MainDataSource mMainRemoteDataSource;
    private final MainDataSource mMainLocalDataSource;

    public MainRepository(@NonNull MainDataSource mainRemoteDataSource,
                          @NonNull MainDataSource mainLocalDataSource) {
        mMainRemoteDataSource = mainRemoteDataSource;
        mMainLocalDataSource = mainLocalDataSource;
    }

    // 只在创建 Presenter 的时候初始化一次，就不使用线程安全了
    public static MainRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainRepository(MainRemoteDataSource.getInstance(), MainLocalDataSource.getInstance());
        }
        return INSTANCE;
    }

    @Override
    public Flowable<PlayListBean> loadPlayList(int uid) {
        return mMainRemoteDataSource.loadPlayList(uid);
    }

    @Override
    public Flowable<Boolean> login(String phone, String password) {
        return mMainRemoteDataSource.login(phone, password);
    }
}
