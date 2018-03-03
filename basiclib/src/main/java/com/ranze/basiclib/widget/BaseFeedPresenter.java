package com.ranze.basiclib.widget;

import com.ranze.basiclib.BasePresenter;
import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;

/**
 * Created by ranze on 2018/2/23.
 */

public abstract class BaseFeedPresenter implements BasePresenter {
    protected BaseViewHolder mView;
    protected BaseFeedBean mFeed;
    protected OnFeedEventListener mFeedEventListener;

    protected BaseFeedPresenter(BaseFeedBean feed) {
        assert feed != null;
        mFeed = feed;
    }

    public BaseViewHolder getView() {
        return mView;
    }

    public void setView(BaseViewHolder view) {
        mView = view;
    }

    public int getType() {
        return mFeed.getFeedType();
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }

    public void onClick() {

    }

    public void setFeedEventListener(OnFeedEventListener feedEventListener) {
        mFeedEventListener = feedEventListener;
    }

    public interface OnFeedEventListener {
        void onFeedEvent(BaseFeedPresenter feedPresenter, int event);
    }

    public BaseFeedBean getFeed() {
        return mFeed;
    }
}
