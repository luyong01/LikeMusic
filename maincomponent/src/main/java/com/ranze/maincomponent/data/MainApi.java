package com.ranze.maincomponent.data;

import com.ranze.maincomponent.data.model.Login;
import com.ranze.maincomponent.data.model.PlayList;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ranze on 2018/2/12.
 */

public interface MainApi {
    @GET("login/cellphone")
    Flowable<Login> login(@Query("phone") String phone, @Query("password") String password);

    @GET("user/playlist")
    Flowable<PlayList> playList(@Query("uid") int uid);
}

