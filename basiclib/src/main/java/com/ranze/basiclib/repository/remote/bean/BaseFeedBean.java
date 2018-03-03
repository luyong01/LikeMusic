package com.ranze.basiclib.repository.remote.bean;

/**
 * Created by luyong01 on 2018/2/12.
 */

public class BaseFeedBean extends BaseBean {
    private int feedType;

    public BaseFeedBean() {

    }

    public BaseFeedBean(int feedType) {
        this.feedType = feedType;
    }

    public int getFeedType() {
        return feedType;
    }

    public void setFeedType(int feedType) {
        this.feedType = feedType;
    }
}
