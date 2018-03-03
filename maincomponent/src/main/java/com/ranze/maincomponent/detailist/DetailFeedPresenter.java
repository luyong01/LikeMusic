package com.ranze.maincomponent.detailist;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.data.bean.DetailListBean;
import com.ranze.maincomponent.feed.FeedEvent;
import com.ranze.maincomponent.feed.MainFeedPresenter;

/**
 * Created by ranze on 2018/2/28.
 */

public class DetailFeedPresenter extends MainFeedPresenter {
    public DetailFeedPresenter(BaseFeedBean feed) {
        super(feed);
    }

    @Override
    public void onAttach() {
        super.onAttach();
        DetailListBean.ResultBean.TracksBean tracksBean = (DetailListBean.ResultBean.TracksBean) mFeed;
        DetailFeedViewHolder viewHolder = (DetailFeedViewHolder) mView;

        viewHolder.setText(R.id.item_title, tracksBean.getName());
    }

    @Override
    public void onClick() {
        super.onClick();

        if (mFeedEventListener != null) {
            mFeedEventListener.onFeedEvent(this, FeedEvent.CLICK);
        }
    }
}
