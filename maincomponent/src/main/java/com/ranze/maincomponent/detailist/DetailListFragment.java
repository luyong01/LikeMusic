package com.ranze.maincomponent.detailist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.feed.MainFeedsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranze on 2018/2/25.
 */

public class DetailListFragment extends BaseCommonFragment implements DetailListContract.View {
    private DetailListContract.Presenter mPresenter;
    private List<BaseFeedPresenter> mData;

    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_detaillist;
    }

    @Override
    protected void convert(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mData = new ArrayList<>();
        recyclerView.setAdapter(new MainFeedsAdapter(mData));
    }

    @Override
    protected void loadData() {

    }

    public static DetailListFragment newInstance(int playListId) {
        DetailListFragment fragment = new DetailListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PARAM, playListId);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void setPresenter(DetailListContract.Presenter presenter) {
        mPresenter = Utils.checkNotNull(presenter);
    }
}
