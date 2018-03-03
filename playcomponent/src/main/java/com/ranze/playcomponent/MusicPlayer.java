package com.ranze.playcomponent;

import android.media.MediaPlayer;

import com.ranze.basiclib.util.LogUtil;

import java.io.IOException;

/**
 * Created by ranze on 2018/3/3.
 */

public class MusicPlayer {

    public void play(String path) {
        LogUtil.d("MusicPlayer#play: " + path);
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
