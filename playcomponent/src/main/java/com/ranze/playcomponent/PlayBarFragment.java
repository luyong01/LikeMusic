package com.ranze.playcomponent;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.schedulers.SchedulerProvider;
import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.playcomponent.data.MusicBean;
import com.ranze.playcomponent.data.PlayRemoteDataSource;
import com.ranze.playcomponent.feed.FeedType;
import com.ranze.playcomponent.feed.PlayFeedsAdapter;
import com.ranze.playcomponent.router.path.PathConstants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by ranze on 2018/3/3.
 */
@Route(path = PathConstants.VIEW_PLAYBAR)
public class PlayBarFragment extends BaseCommonFragment {
    private List<BaseFeedPresenter> mData;
    private List<MusicBean.DataBean> mDataBeans;  // 歌曲的url

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

    public void play(int id, List<Integer> ids) {

        Disposable disposable = PlayRemoteDataSource.getInstance().getUrl(ids)
                .map(musicBean -> {
                    List<MusicBean.DataBean> dataBeanList = null;
                    if (musicBean.getCode() == 200) {
                        dataBeanList = musicBean.getData();
                        mDataBeans = dataBeanList;
                    }
                    return dataBeanList;
                })
                .subscribeOn(SchedulerProvider.getInstance().io())
                .observeOn(SchedulerProvider.getInstance().ui())
                .subscribe(dataBeans -> {
                    if (dataBeans != null) {
                        String url = "";
                        for (MusicBean.DataBean dataBean : dataBeans) {
                            if (dataBean.getId() == id) {
                                url = dataBean.getUrl();
                                break;
                            }
                        }
                        new MusicPlayer().play(url);
                    }
                });

    }
}
