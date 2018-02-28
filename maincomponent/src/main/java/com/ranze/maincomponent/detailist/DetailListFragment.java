package com.ranze.maincomponent.detailist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.MainConstants;
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
    private int id;  // 歌单id
    private MainFeedsAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_detaillist;
    }

    @Override
    protected void convert(View rootView) {
        if (mParam != null) {
            id = mParam.getInt(MainConstants.PLAY_LIST_ID, -1);
        }
        RecyclerView recyclerView = rootView.findViewById(R.id.detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mData = new ArrayList<>();
        mAdapter = new MainFeedsAdapter(mData);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {
        mPresenter.loadDetailList(id);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onDetach();
    }

    public static DetailListFragment newInstance(Bundle bundle) {
        DetailListFragment fragment = new DetailListFragment();
        bundle.putBundle(ARG_PARAM, bundle);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void setPresenter(DetailListContract.Presenter presenter) {
        mPresenter = Utils.checkNotNull(presenter);
    }

    @Override
    public void showList(List<BaseFeedPresenter> feedPresenters) {
        mAdapter.replaceData(feedPresenters);
    }
}
