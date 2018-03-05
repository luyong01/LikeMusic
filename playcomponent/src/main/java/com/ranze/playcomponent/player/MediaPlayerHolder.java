package com.ranze.playcomponent.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.PowerManager;

import com.ranze.basiclib.util.LogUtil;

import java.io.IOException;

/**
 * Created by ranze on 2018/3/3.
 */

public class MediaPlayerHolder implements PlayerAdapter {
    private PlaybackInfoListener mPlaybackInfoListener;
    private MediaPlayer mMediaPlayer;
    private WifiManager.WifiLock mWifiLock;

    public MediaPlayerHolder(Context context) {
        initMediaPlayer(context);
    }

    private void initMediaPlayer(Context context) {
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();

            mMediaPlayer.setWakeMode(context.getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);

            mWifiLock = ((WifiManager) context.getApplicationContext().
                    getSystemService(Context.WIFI_SERVICE)).createWifiLock(WifiManager.WIFI_MODE_FULL, "PlayerWifiLock");
            mWifiLock.acquire();

            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setOnPreparedListener(MediaPlayer::start);
            mMediaPlayer.setOnCompletionListener(mp -> {
                if (mPlaybackInfoListener != null) {
                    mPlaybackInfoListener.onStateChanged(PlaybackInfoListener.State.COMPLETED);
                    mPlaybackInfoListener.onPlaybackCompleted();
                }

            });
            mMediaPlayer.setOnErrorListener((mp, what, extra) -> false);
        }
    }

    public void play(String path) {
        LogUtil.d("MediaPlayerHolder#play: " + path);
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    @Override
    public void initializeProgressCallback() {

    }

    @Override
    public void seekTo(int position) {
        if (mMediaPlayer != null) {
            mMediaPlayer.seekTo(position);
        }
    }

    @Override
    public void loadMedia(String resourcePath) {

    }

    public void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public boolean isPlaying() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.isPlaying();
        }
        return false;
    }

    @Override
    public void play() {
        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.start();
        }
    }

    @Override
    public void reset() {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
        }
    }

    public PlaybackInfoListener getPlaybackInfoListener() {
        return mPlaybackInfoListener;
    }

    public void setPlaybackInfoListener(PlaybackInfoListener playbackInfoListener) {
        mPlaybackInfoListener = playbackInfoListener;
    }
}
