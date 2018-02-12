package com.ranze.maincomponent.music;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.ranze.basiclib.repository.remote.NetWorker;
import com.ranze.basiclib.widget.BaseAdapter;
import com.ranze.basiclib.widget.BaseRecyclerView;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranze on 2018/2/10.
 */

public class MusicFragment extends BaseCommonFragment {
    List<String> mData = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_music;
    }

    @Override
    protected void convert(View rootView) {
        BaseRecyclerView recyclerView = rootView.findViewById(R.id.music_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        BaseAdapter adapter = new BaseAdapter<String>(mData) {

            @Override
            protected int getLayoutId(int viewType) {
                return R.layout.maincomponent_item_simple;
            }
        };

        recyclerView.setAdapter(adapter);
    }

    protected void loadData() {
        Log.d("test", "music loadData");

        for (int i = 0; i < 100; ++i) {
            mData.add(i + " item");
        }

        NetWorker.getInstance().login("17621652365", "ly521561");

        mDataLoaded = true;
    }

    public static MusicFragment newInstance(String string) {
        MusicFragment fragment = new MusicFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, string);
        fragment.setArguments(bundle);
        return fragment;
    }
}
