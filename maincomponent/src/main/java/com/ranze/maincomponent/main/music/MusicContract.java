package com.ranze.maincomponent.main.music;

import com.ranze.basiclib.BasePresenter;
import com.ranze.basiclib.BaseView;
import com.ranze.basiclib.widget.BaseFeedPresenter;

import java.util.List;

/**
 * Created by ranze on 2018/2/13.
 */

public interface MusicContract {
    interface View extends BaseView<Presenter> {
        void showList(List<BaseFeedPresenter> playList);

        void switchToSongList();
    }

    interface Presenter extends BasePresenter {
        void loadList();
    }


}
