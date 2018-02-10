package com.ranze.maincomponent.discovery;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.R;

/**
 * Created by ranze on 2018/2/10.
 */

public class DiscoveryFragment extends BaseCommonFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_discovery;
    }

    @Override
    protected void convert(View rootView) {

    }

    @Override
    protected void loadData() {
        Log.d("test", "discovery loadData");
        mDataLoaded = true;
    }

    public static DiscoveryFragment newInstance(String string) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, string);
        fragment.setArguments(bundle);
        return fragment;
    }
}
