package com.ranze.playcomponent;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
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
import com.ranze.playcomponent.player.PlayerService;
import com.ranze.playcomponent.router.path.PathConstants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by ranze on 2018/3/3.
 */
@Route(path = PathConstants.VIEW_PLAYBAR)
public class PlayBarFragment extends BaseCommonFragment {
    private static PlayBarFragment INSTANCE;
    private List<BaseFeedPresenter> mData;
    private List<MusicBean.DataBean> mDataBeans;  // 歌曲的url

    private PlayerService mPlayerService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mPlayerService = ((PlayerService.LocalBinder) service).getPlayerService();
            LogUtil.d("PlayBarFragment#onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtil.d("PlayBarFragment#onServiceDisconnected");
        }
    };

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

        Intent intent = new Intent(mActivity, PlayerService.class);
        mActivity.bindService(intent, mServiceConnection, Service.BIND_AUTO_CREATE);
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
                        if (mPlayerService != null) {
                            mPlayerService.start(url);
                        }
                    }
                });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity.unbindService(mServiceConnection);
    }

    public static PlayBarFragment getInstance(Bundle args) {
        if (INSTANCE == null) {
            synchronized (PlayBarFragment.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PlayBarFragment();
                    INSTANCE.setArguments(args);
                }
            }
        }
        return INSTANCE;
    }
}
