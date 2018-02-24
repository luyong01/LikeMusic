package com.ranze.basiclib.widget;

import com.ranze.basiclib.BasePresenter;
import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;

/**
 * Created by ranze on 2018/2/23.
 */

public abstract class BaseFeedPresenter implements BasePresenter {
    protected BaseViewHolder mView;
    protected BaseFeedBean mFeed;

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
        return mFeed.getType();
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }
}
