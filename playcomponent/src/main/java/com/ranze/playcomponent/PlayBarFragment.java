package com.ranze.playcomponent;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.playcomponent.feed.FeedType;
import com.ranze.playcomponent.feed.PlayFeedsAdapter;
import com.ranze.playcomponent.router.path.PathConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranze on 2018/3/3.
 */
@Route(path = PathConstants.VIEW_PLAYBAR)
public class PlayBarFragment extends BaseCommonFragment {
    private List<BaseFeedPresenter> mData;

    @Override
    protected int getLayoutId() {
        return R.layout.playcomponent_frag_playbar;
    }

    @Override
    protected void convert(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity,
                LinearLayoutManager.HORIZONTAL,
                false));
        mData = new ArrayList<>();
        PlayFeedsAdapter adapter = new PlayFeedsAdapter(mData);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        LogUtil.d("PlayBarFragment#loadData");
        for (int i = 0; i < 10; ++i) {
            PlayingBean feed = new PlayingBean();
            feed.setName("this is " + i);
            feed.setFeedType(FeedType.song_playing);
            PlayingFeedPresenter feedPresenter = new PlayingFeedPresenter(feed);
            mData.add(feedPresenter);
        }
    }
}
