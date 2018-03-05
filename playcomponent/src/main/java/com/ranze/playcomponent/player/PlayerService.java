package com.ranze.playcomponent.player;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.ranze.basiclib.util.LogUtil;

/**
 * Created by ranze on 2018/3/4.
 */

public class PlayerService extends Service {
    private MediaPlayerHolder mMediaPlayerHolder;
    private LocalBinder mLocalBinder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d("PlayerService onCreate");

        mMediaPlayerHolder = new MediaPlayerHolder(getApplicationContext());
    }

    public class LocalBinder extends Binder {
        public PlayerService getPlayerService() {
            return PlayerService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.d("PlayerService onBind");
        return mLocalBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtil.d("PlayerService onDestroy");
        super.onDestroy();
        mMediaPlayerHolder.release();
    }

    public void start(String path) {
        LogUtil.d("PlayerService#start, path = " + path);
        mMediaPlayerHolder.play(path);
    }

    public void pause() {
        mMediaPlayerHolder.pause();
    }
}
