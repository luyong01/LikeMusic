package com.ranze.maincomponent.music;

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

public class MusicFragment extends BaseCommonFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.maincomponent_frag_mine, container, false);

        return rootView;
    }

    public static MusicFragment newInstance(String string) {
        MusicFragment fragment = new MusicFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, string);
        fragment.setArguments(bundle);
        return fragment;
    }
}
