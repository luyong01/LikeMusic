package com.ranze.maincomponent.music;

import com.ranze.basiclib.BasePresenter;
import com.ranze.basiclib.BaseView;
import com.ranze.maincomponent.data.model.PlayList;

import java.util.List;

/**
 * Created by ranze on 2018/2/13.
 */

public interface MusicContract {
    interface View extends BaseView<Presenter> {
        void showList(List<PlayList.PlaylistBean> playList);

        void switchToSongList();
    }

    interface Presenter extends BasePresenter {
        void loadList();
    }


}
