package com.ranze.basiclib.repository.remote;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.ranze.basiclib.Constants;
import com.ranze.basiclib.config.ConfigData;
import com.ranze.basiclib.repository.remote.model.Login;
import com.ranze.basiclib.repository.remote.model.PlayList;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.SPUtil;

import java.io.IOException;
import java.util.HashSet;

import io.reactivex.Flowable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luyong01 on 2018/2/12.
 */

public class NetWorker {
    private volatile static NetWorker sNetWorker;

    private static final String URL = "http://172.18.33.74:3000/";
    private Retrofit mRetrofit;
    private API mAPI;


    private NetWorker() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {

                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();
                        for (String cookie : ConfigData.getInstance().getLoginCookie()) {
                            builder.addHeader("Cookie", cookie);
                        }
                        request = builder.build();

                        okhttp3.Response originResponse = chain.proceed(request);

                        if (!originResponse.headers("Set-Cookie").isEmpty()
                                && ConfigData.getInstance().getLoginCookie().isEmpty()) {
                            HashSet<String> cookies = new HashSet<>();
                            cookies.addAll(originResponse.headers("Set-Cookie"));
                            ConfigData.getInstance().setLoginCookie(cookies);
                        }

                        return originResponse;
                    }
                })
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();
        mAPI = retrofit.create(API.class);
    }

    public static NetWorker getInstance() {
        if (sNetWorker == null) {
            synchronized (NetWorker.class) {
                if (sNetWorker == null) {
                    sNetWorker = new NetWorker();
                }
            }
        }
        return sNetWorker;
    }

    public void login(String phone, String password) {
        Call<Login> loginCall = mAPI.login(phone, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                LogUtil.d("response: " + response.raw().toString());
                LogUtil.d("response: " + response.headers());
                if (response.isSuccessful()) {
                    Login login = response.body();
                    SPUtil.getInstance().sharedPreferences().edit()
                            .putString(Constants.SP_USER_NICKNAME, login.getProfile().getNickname())
                            .putInt(Constants.SP_USER_UID, login.getProfile().getUserId())
                            .apply();

                    String cookie = response.headers().get("Set-Cookie");

                    ConfigData.getInstance().setUserId(login.getProfile().getUserId());

                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                LogUtil.d("onFailure: " + t);
            }
        });
    }

    public Flowable<PlayList> playList(int uid) {
        Flowable<PlayList> playListFlowable = mAPI.playList(uid);
        return playListFlowable;
    }
}
