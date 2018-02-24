package com.ranze.maincomponent.main.music;

import com.ranze.basiclib.config.ConfigData;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.util.schedulers.BaseSchedulerProvider;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.maincomponent.feed.FeedType;
import com.ranze.maincomponent.feed.MainFeedPresenter;
import com.ranze.maincomponent.data.MainRepository;
import com.ranze.maincomponent.data.bean.PlayListBean;
import com.ranze.maincomponent.data.bean.PlayTitleBean;

import java.util.ArrayList;
import java.util.List;

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
    public void onAttach() {
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.clear();
    }

    @Override
    public void loadList() {
        Disposable disposable = mRepository.loadPlayList(ConfigData.getInstance().getUserId())
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .map(playList -> {
                    if (playList.getCode() == 200) {
                        return playList.getPlaylist();
                    }
                    return new ArrayList<PlayListBean.PlaylistBean>();
                })
                .subscribe(playlistBeans -> {
                    List<BaseFeedPresenter> playLists = new ArrayList<>();
                    playLists.add(MainFeedPresenter.newInstance(new PlayTitleBean(FeedType.NORMAL_TITLE, "创建的歌单")));

                    boolean firstSC = true; // 第一个收藏的歌单
                    for (int i = 0; i < playlistBeans.size(); ++i) {
                        PlayListBean.PlaylistBean playListBean = playlistBeans.get(i);

                        if (playListBean.getCreator().getUserId() != ConfigData.getInstance().getUserId() && firstSC) {
                            firstSC = false;
                            playLists.add(MainFeedPresenter.newInstance(new PlayTitleBean(FeedType.NORMAL_TITLE, "收藏的歌单")));
                        }

                        playListBean.setFeedType(FeedType.NORMAL_LINEAR);
                        playLists.add(MainFeedPresenter.newInstance(playListBean));

                    }
                    LogUtil.d("PlaylistBean size = " + playlistBeans.size());

                    mView.showList(playLists);
                }, throwable -> {
                    LogUtil.d("loadList: " + throwable.toString());
                });

        mCompositeDisposable.add(disposable);
    }
}
