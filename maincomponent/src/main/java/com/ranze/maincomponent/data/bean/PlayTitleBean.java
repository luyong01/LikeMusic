package com.ranze.maincomponent.data.bean;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;

/**
 * Created by ranze on 2018/2/24.
 */

public class PlayTitleBean extends BaseFeedBean {

    public PlayTitleBean(int feedType, String title) {
        super(feedType);
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
