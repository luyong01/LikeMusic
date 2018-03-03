package com.ranze.playcomponent.feed;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.playcomponent.PlayingFeedPresenter;

/**
 * Created by ranze on 2018/3/3.
 */

public class PlayFeedPresenter extends BaseFeedPresenter {
    protected PlayFeedPresenter(BaseFeedBean feed) {
        super(feed);
    }

    public PlayFeedPresenter newInstance(BaseFeedBean feed) {
        PlayFeedPresenter playFeedPresenter = null;
        switch (feed.getType()) {
            case FeedType.song_playing:
                playFeedPresenter = new PlayingFeedPresenter(feed);
                break;

            default:
                break;
        }
        return playFeedPresenter;
    }
}
