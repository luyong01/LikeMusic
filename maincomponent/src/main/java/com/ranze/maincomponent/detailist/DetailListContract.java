package com.ranze.maincomponent.detailist;

import com.ranze.basiclib.BasePresenter;
import com.ranze.basiclib.BaseView;
import com.ranze.basiclib.widget.BaseFeedPresenter;

import java.util.List;

/**
 * Created by ranze on 2018/2/25.
 */

public interface DetailListContract {
    interface View extends BaseView<Presenter> {
        void showList(List<BaseFeedPresenter> feedBeans);
    }

    interface Presenter extends BasePresenter {
        void loadDetailList(int id);
    }
}
