package com.ranze.playcomponent.player;

public interface PlayerAdapter {

    void loadMedia(String resourcePath);

    void release();

    boolean isPlaying();

    void play();

    void reset();

    void pause();

    void initializeProgressCallback();

    void seekTo(int position);
}