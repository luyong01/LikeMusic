package com.ranze.basiclib.repository.remote;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.ranze.basiclib.Constants;
import com.ranze.basiclib.config.ConfigData;
import com.ranze.basiclib.util.SPUtil;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ranze on 2018/2/12.
 */

public class NetWorker {
    private volatile static NetWorker sNetWorker;

    private static final String URL = "http://172.18.33.74:3000/";
    private Retrofit mRetrofit;


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

                            SPUtil.getInstance().sharedPreferences().edit()
                                    .putStringSet(Constants.SP_LOGIN_COOKIE, cookies)
                                    .apply();
                        }

                        return originResponse;
                    }
                })
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();
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

    public <T> T createApi(Class<T> cls) {
        return mRetrofit.create(cls);
    }
}
