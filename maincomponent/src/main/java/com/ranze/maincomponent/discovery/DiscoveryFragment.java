package com.ranze.maincomponent.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.R;

/**
 * Created by ranze on 2018/2/10.
 */

public class DiscoveryFragment extends BaseCommonFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.maincomponent_frag_discovery, container, false);
        return rootView;
    }

    public static DiscoveryFragment newInstance(String string) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, string);
        fragment.setArguments(bundle);
        return fragment;
    }
}
