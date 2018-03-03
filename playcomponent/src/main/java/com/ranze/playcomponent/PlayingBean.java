package com.ranze.playcomponent;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;

/**
 * Created by ranze on 2018/3/3.
 */

public class PlayingBean extends BaseFeedBean{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
