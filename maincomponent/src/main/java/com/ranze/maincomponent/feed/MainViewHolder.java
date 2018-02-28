package com.ranze.maincomponent.feed;

import android.view.View;

import com.ranze.basiclib.widget.BaseViewHolder;
import com.ranze.maincomponent.detailist.DetailFeedViewHolder;
import com.ranze.maincomponent.main.music.PlayListViewHolder;
import com.ranze.maincomponent.main.music.PlayTitleViewHolder;

/**
 * Created by ranze on 2018/2/24.
 */

public class MainViewHolder extends BaseViewHolder {
    public MainViewHolder(View itemView) {
        super(itemView);
    }

    public static MainViewHolder newInstance(int feedType, View itemView) {
        MainViewHolder viewHolder = null;
        switch (feedType) {
            case FeedType.PLAY_LIST:
                viewHolder = new PlayListViewHolder(itemView);
                break;

            case FeedType.PLAY_TITLE:
                viewHolder = new PlayTitleViewHolder(itemView);
                break;

            case FeedType.DETAIL_LIST:
                viewHolder = new DetailFeedViewHolder(itemView);
                break;

            default:
                break;
        }

        return viewHolder;
    }
}
