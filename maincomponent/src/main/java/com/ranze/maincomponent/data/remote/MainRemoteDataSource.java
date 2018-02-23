package com.ranze.maincomponent.data.remote;

import com.ranze.basiclib.Constants;
import com.ranze.basiclib.config.ConfigData;
import com.ranze.basiclib.repository.remote.NetWorker;
import com.ranze.basiclib.util.SPUtil;
import com.ranze.maincomponent.data.MainApi;
import com.ranze.maincomponent.data.MainDataSource;
import com.ranze.maincomponent.data.model.PlayList;

import io.reactivex.Flowable;

/**
 * Created by luyong01 on 2018/2/13.
 */

public class MainRemoteDataSource implements MainDataSource {
    private static MainRemoteDataSource INSTANCE;

    private MainApi mMainApi;

    private MainRemoteDataSource() {
        mMainApi = NetWorker.getInstance().createApi(MainApi.class);
    }

    public static MainRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainRemoteDataSource();
        }
        return INSTANCE;
    }

    public Flowable<Boolean> login(String phone, String password) {
        return mMainApi.login(phone, password)
                .map(login -> {
                    if (login.getCode() == 200) {
                        SPUtil.getInstance().sharedPreferences().edit()
                                .putString(Constants.SP_USER_NICKNAME, login.getProfile().getNickname())
                                .putInt(Constants.SP_USER_UID, login.getProfile().getUserId())
                                .apply();

                        ConfigData.getInstance().setUserId(login.getProfile().getUserId());

                        return true;
                    }
                    return false;
                });
    }

    public Flowable<PlayList> loadPlayList(int uid) {
        return mMainApi.playList(uid);
    }

}
