package com.ranze.maincomponent.main.music;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.widget.BaseAdapter;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.MainConstants;
import com.ranze.maincomponent.feed.MainFeedsAdapter;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.router.path.PathConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranze on 2018/2/10.
 */

public class MusicFragment extends BaseCommonFragment implements MusicContract.View {
    private MusicContract.Presenter mPresenter;

    List<BaseFeedPresenter> mData = new ArrayList<>();
    private BaseAdapter<BaseFeedPresenter> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_music;
    }

    @Override
    protected void convert(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.music_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

//        for (int i = 0; i < 100; ++i) {
//            PlayListBean.PlaylistBean playlistBean = new PlayListBean.PlaylistBean();
//            playlistBean.setName(i + "");
//            playlistBean.setItemType(FeedType.PLAY_LIST);
//            mData.add(playlistBean);
//        }

        mAdapter = new MainFeedsAdapter(mData);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onDetach();
    }

    protected void loadData() {
        LogUtil.d("music loadData");
        mPresenter.loadList();
        mDataLoaded = true;
    }

    public static MusicFragment newInstance(String string) {
        MusicFragment fragment = new MusicFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, string);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setPresenter(MusicContract.Presenter presenter) {
        mPresenter = Utils.checkNotNull(presenter);
    }

    @Override
    public void showList(List<BaseFeedPresenter> playList) {
        mAdapter.replaceData(playList);
    }

    @Override
    public void switchToDetailList(int playListId) {
        ARouter.getInstance().build(PathConstants.VIEW_DETAILLIST).withInt(MainConstants.PLAY_LIST_ID, playListId).navigation();
    }
}
