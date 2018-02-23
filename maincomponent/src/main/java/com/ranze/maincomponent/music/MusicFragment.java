package com.ranze.maincomponent.music;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.Utils;
import com.ranze.basiclib.widget.BaseAdapter;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.data.model.PlayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranze on 2018/2/10.
 */

public class MusicFragment extends BaseCommonFragment implements MusicContract.View {
    private MusicContract.Presenter mPresenter;
    List<PlayList.PlaylistBean> mData = new ArrayList<>();
    private BaseAdapter<PlayList.PlaylistBean> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_music;
    }

    @Override
    protected void convert(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.music_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

//        for (int i = 0; i < 100; ++i) {
//            PlayList.PlaylistBean playlistBean = new PlayList.PlaylistBean();
//            playlistBean.setName(i + "");
//            playlistBean.setItemType(ItemType.NORMAL_LINEAR);
//            mData.add(playlistBean);
//        }

        mAdapter = new FeedsAdapter(mData);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
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
    public void showList(List<PlayList.PlaylistBean> playList) {
        mAdapter.setData(playList);
    }

    @Override
    public void switchToSongList() {

    }
}
