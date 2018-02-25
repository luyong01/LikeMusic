package com.ranze.maincomponent.detailist;

import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.util.schedulers.BaseSchedulerProvider;
import com.ranze.maincomponent.data.MainRepository;

import io.reactivex.disposables.CompositeDisposable;

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

    }

    @Override
    public void loadDetailList(int id) {
        mRepository.loadDetailList(id)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(detailListBean -> {

                }, throwable -> {

                });
    }
}
