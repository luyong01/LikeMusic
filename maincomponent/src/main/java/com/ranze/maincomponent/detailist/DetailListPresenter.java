package com.ranze.maincomponent.detailist;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.util.schedulers.BaseSchedulerProvider;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.maincomponent.data.MainRepository;
import com.ranze.maincomponent.feed.MainFeedPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ranze on 2018/2/25.
 */

public class DetailListPresenter implements DetailListContract.Presenter {
    private final DetailListContract.View mView;
    private final MainRepository mRepository;
    private final BaseSchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    public DetailListPresenter(DetailListContract.View view,
                               MainRepository repository,
                               BaseSchedulerProvider schedulerProvider) {
        mView = view;
        mRepository = repository;

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
    public void loadDetailList(int id) {
        Disposable disposable = mRepository.loadDetailList(id)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(detailListBean -> {
                    if (detailListBean != null && detailListBean.getCode() == 200) {
                        List<BaseFeedBean> feedBeans = new ArrayList<>(detailListBean.getResult().getTracks());
                        mView.showList(newFeedPresenters(feedBeans));
                    } else {
                        LogUtil.d("loadDetailList, code = " + detailListBean.getCode());
                    }
                }, throwable -> {
                    LogUtil.d("loadDetailList, error: " + throwable);
                });
        mCompositeDisposable.add(disposable);
    }

    private List<BaseFeedPresenter> newFeedPresenters(List<BaseFeedBean> feeds) {
        if (null == feeds || 0 == feeds.size()) {
            return null;
        }

        List<BaseFeedPresenter> presenters = new ArrayList<>();
        for (BaseFeedBean feed : feeds) {
            BaseFeedPresenter feedPresenter = MainFeedPresenter.newInstance(feed);
//            feedPresenter.setFeedEventListener(this);
            presenters.add(feedPresenter);
        }
        return presenters;
    }
}
