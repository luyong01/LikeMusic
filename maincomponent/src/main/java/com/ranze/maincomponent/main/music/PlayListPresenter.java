package com.ranze.maincomponent.main.music;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;
import com.ranze.maincomponent.feed.MainFeedPresenter;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.data.bean.PlayListBean;

/**
 * Created by ranze on 2018/2/24.
 */

public class PlayListPresenter extends MainFeedPresenter {
      public PlayListPresenter(BaseFeedBean feed) {
        super(feed);
    }

    @Override
    public void onAttach() {
        super.onAttach();
        PlayListViewHolder viewHolder = (PlayListViewHolder) mView;
        PlayListBean.PlaylistBean feed = (PlayListBean.PlaylistBean) mFeed;
        viewHolder.setText(R.id.item_title, feed.getName());

    }
}
