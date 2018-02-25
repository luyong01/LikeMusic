package com.ranze.maincomponent.data;

import com.ranze.maincomponent.data.bean.DetailListBean;
import com.ranze.maincomponent.data.bean.LoginBean;
import com.ranze.maincomponent.data.bean.PlayListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ranze on 2018/2/12.
 */

public interface MainApi {
    @GET("login/cellphone")
    Flowable<LoginBean> login(@Query("phone") String phone, @Query("password") String password);

    @GET("user/playlist")
    Flowable<PlayListBean> playList(@Query("uid") int uid);

    @GET("playlist/detail")
    Flowable<DetailListBean> detailList(@Query("id") int playLIstId);
}

