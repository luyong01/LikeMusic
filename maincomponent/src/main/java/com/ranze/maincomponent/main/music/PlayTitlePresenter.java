package com.ranze.maincomponent.main.music;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;
import com.ranze.maincomponent.feed.MainFeedPresenter;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.data.bean.PlayTitleBean;

/**
 * Created by ranze on 2018/2/24.
 */

public class PlayTitlePresenter extends MainFeedPresenter {
    public PlayTitlePresenter(BaseFeedBean feed) {

        super(feed);
    }

    @Override
    public void onAttach() {
        super.onAttach();
        PlayTitleViewHolder viewHolder = (PlayTitleViewHolder) mView;
        PlayTitleBean feed = (PlayTitleBean) mFeed;

        viewHolder.setText(R.id.item_title, feed.getTitle());
    }
}
