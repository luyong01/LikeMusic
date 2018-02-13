package com.ranze.maincomponent.music;

import com.ranze.basiclib.BasePresenter;
import com.ranze.basiclib.BaseView;
import com.ranze.maincomponent.data.model.PlayList;

/**
 * Created by ranze on 2018/2/13.
 */

public interface MusicContract {
    interface View extends BaseView<Presenter> {
        void showList(PlayList playList);

        void switchToSongList();
    }

    interface Presenter extends BasePresenter {
        void loadList();
    }


}
