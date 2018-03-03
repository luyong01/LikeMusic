package com.ranze.playcomponent;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;
import com.ranze.playcomponent.feed.PlayFeedPresenter;
import com.ranze.playcomponent.feed.PlayViewHolder;

/**
 * Created by ranze on 2018/3/3.
 */

public class PlayingFeedPresenter extends PlayFeedPresenter {
    public PlayingFeedPresenter(BaseFeedBean feed) {
        super(feed);
    }

    @Override
    public void onAttach() {
        super.onAttach();
        PlayViewHolder viewHolder = (PlayViewHolder) mView;
        PlayingBean bean = (PlayingBean) mFeed;
        viewHolder.setText(R.id.tv_title, bean.getName());
    }
}
