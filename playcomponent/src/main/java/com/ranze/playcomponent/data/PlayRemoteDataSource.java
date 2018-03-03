package com.ranze.playcomponent.data;

import com.ranze.basiclib.repository.remote.NetWorker;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by ranze on 2018/3/3.
 */

public class PlayRemoteDataSource {
    private static PlayRemoteDataSource INSTANCE;

    private PlayApi mPlayApi;

    private PlayRemoteDataSource() {
        mPlayApi = NetWorker.getInstance().createApi(PlayApi.class);
    }

    public static PlayRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayRemoteDataSource();
        }
        return INSTANCE;
    }

    public Flowable<MusicBean> getUrl(List<Integer> ids) {
        StringBuilder idStr = new StringBuilder();
        for (int i = 0; i < ids.size(); ++i) {
            if (i != 0) {
                idStr.append(",");
            }
            idStr.append(ids.get(i));
        }
        return mPlayApi.url(idStr.toString());
    }
}
