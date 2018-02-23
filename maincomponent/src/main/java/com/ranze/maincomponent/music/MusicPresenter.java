package com.ranze.maincomponent.music;

import com.ranze.basiclib.config.ConfigData;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.util.schedulers.BaseSchedulerProvider;
import com.ranze.maincomponent.data.MainRepository;
import com.ranze.maincomponent.data.model.PlayList;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ranze on 2018/2/13.
 */

public class MusicPresenter implements MusicContract.Presenter {
    private final MainRepository mRepository;
    private final MusicContract.View mView;
    private final BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;

    public MusicPresenter(MusicContract.View view,
                          BaseSchedulerProvider schedulerProvider
            , MainRepository repository) {
        mRepository = Utils.checkNotNull(repository);
        mView = Utils.checkNotNull(view);

        mSchedulerProvider = Utils.checkNotNull(schedulerProvider);

        mCompositeDisposable = new CompositeDisposable();

        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void loadList() {
        mRepository.login("17621652365", "ly521561")
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(aBoolean -> LogUtil.d("login success? " + aBoolean));

        Disposable disposable = mRepository.loadPlayList(ConfigData.getInstance().getUserId())
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .map(playList -> {
                    if (playList.getCode() == 200) {
                        return playList.getPlaylist();
                    }
                    return new ArrayList<PlayList.PlaylistBean>();
                })
                .subscribe(playlistBeans -> {
                    for (PlayList.PlaylistBean playlistBean : playlistBeans) {
                        playlistBean.setItemType(ItemType.NORMAL_LINEAR);
                    }
                    LogUtil.d("PlaylistBean size = " + playlistBeans.size());
                    PlayList.PlaylistBean playlistBean = new PlayList.PlaylistBean();
                    playlistBean.setItemType(ItemType.NOMAL_TITLE);
                    playlistBean.setName("title");
                    playlistBeans.add(0, playlistBean);
                    mView.showList(playlistBeans);
                }, throwable -> {
                    LogUtil.d("loadList: " + throwable.toString());
                });

        mCompositeDisposable.add(disposable);
    }
}
