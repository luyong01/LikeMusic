package com.ranze.playcomponent.data;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ranze on 2018/3/3.
 */

public interface PlayApi {
    @GET("music/url")
    Flowable<MusicBean> url(@Query("id") String ids);
}
