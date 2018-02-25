package com.ranze.maincomponent.detailist;

import com.ranze.basiclib.BasePresenter;
import com.ranze.basiclib.BaseView;

/**
 * Created by ranze on 2018/2/25.
 */

public interface DetailListContract {
    interface View extends BaseView<Presenter> {

    }
    interface Presenter extends BasePresenter {
        void loadDetailList(int id);
    }
}
