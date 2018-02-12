package com.ranze.basiclib.repository.remote;

import com.ranze.basiclib.repository.remote.model.Login;
import com.ranze.basiclib.repository.remote.model.PlayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by luyong01 on 2018/2/12.
 */

public interface API {
    @GET("login/cellphone")
    Call<Login> login(@Query("phone") String phone, @Query("password") String password);

    @GET("user/playlist")
    Call<PlayList> playList(@Query("uid") int uid);
}

