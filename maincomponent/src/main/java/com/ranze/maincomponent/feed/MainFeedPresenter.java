package com.ranze.maincomponent.feed;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.maincomponent.detailist.DetailFeedPresenter;
import com.ranze.maincomponent.main.music.PlayListPresenter;
import com.ranze.maincomponent.main.music.PlayTitlePresenter;

/**
 * Created by ranze on 2018/2/24.
 */

public class MainFeedPresenter extends BaseFeedPresenter {
    protected MainFeedPresenter(BaseFeedBean feed) {
        super(feed);
    }

    public static MainFeedPresenter newInstance(BaseFeedBean feed) {
        MainFeedPresenter presenter = null;
        switch (feed.getType()) {
            case FeedType.PLAY_LIST:
                presenter = new PlayListPresenter(feed);
                break;

            case FeedType.PLAY_TITLE:
                presenter = new PlayTitlePresenter(feed);
                break;

            case FeedType.DETAIL_LIST:
                presenter = new DetailFeedPresenter(feed);
                break;

            default:
                break;
        }
        return presenter;
    }


}
