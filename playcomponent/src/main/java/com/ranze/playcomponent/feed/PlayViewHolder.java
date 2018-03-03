package com.ranze.playcomponent.feed;

import android.view.View;

import com.ranze.basiclib.widget.BaseViewHolder;
import com.ranze.playcomponent.PlayingViewHolder;

/**
 * Created by ranze on 2018/3/3.
 */

public class PlayViewHolder extends BaseViewHolder {
    protected PlayViewHolder(View itemView) {
        super(itemView);
    }

    public static PlayViewHolder newInstance(int viewType, View itemView) {
        PlayViewHolder viewHolder = null;
        switch (viewType) {
            case FeedType.song_playing:
                viewHolder = new PlayingViewHolder(itemView);
                break;

            default:
                break;

        }
        return viewHolder;
    }
}
