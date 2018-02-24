package com.ranze.maincomponent.main.discovery;

import android.util.Log;
import android.view.View;

import com.ranze.maincomponent.R;

/**
 * Created by luyong01 on 2018/2/11.
 */

public class DiscoveryMusicFragment extends SubCommonFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_discovery_music;
    }

    @Override
    protected void convert(View rootView) {

    }

    @Override
    protected void loadData() {
        Log.d("test", "discovery music loadData");
        mDataLoaded = true;
    }
}
