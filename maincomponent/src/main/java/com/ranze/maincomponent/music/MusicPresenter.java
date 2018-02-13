package com.ranze.maincomponent.music;

import com.ranze.basiclib.config.ConfigData;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.util.schedulers.BaseSchedulerProvider;
import com.ranze.maincomponent.data.MainRepository;

import io.reactivex.disposables.CompositeDisposable;

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
        mRepository.loadPlayList(ConfigData.getInstance().getUserId())
                .subscribeOn(mSchedulerProvider.io())
                .subscribeOn(mSchedulerProvider.ui())
                .subscribe(playList -> {
                    if (playList.getCode() == 200) {
                        LogUtil.d("size = " + playList.getPlaylist().size());
                    }
                });
    }
}
