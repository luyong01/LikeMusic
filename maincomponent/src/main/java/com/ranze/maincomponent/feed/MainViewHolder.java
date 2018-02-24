package com.ranze.maincomponent.feed;

import android.view.View;

import com.ranze.basiclib.widget.BaseViewHolder;
import com.ranze.maincomponent.main.music.PlayListViewHolder;
import com.ranze.maincomponent.main.music.PlayTitleViewHolder;

/**
 * Created by ranze on 2018/2/24.
 */

public class MainViewHolder extends BaseViewHolder {
    protected MainViewHolder(View itemView) {
        super(itemView);
    }

    public static MainViewHolder newInstance(int feedType, View itemView) {
        MainViewHolder viewHolder = null;
        switch (feedType) {
            case FeedType.NORMAL_LINEAR:
                viewHolder = new PlayListViewHolder(itemView);
                break;

            case FeedType.NORMAL_TITLE:
                viewHolder = new PlayTitleViewHolder(itemView);
                break;

            default:
                break;
        }

        return viewHolder;
    }
}
