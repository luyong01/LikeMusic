package com.ranze.playcomponent.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.basiclib.widget.BaseViewHolder;
import com.ranze.basiclib.widget.FeedsAdapter;
import com.ranze.playcomponent.R;

import java.util.List;

/**
 * Created by ranze on 2018/3/3.
 */

public class PlayFeedsAdapter extends FeedsAdapter {
    private int[] mLayoutIds = new int[]{
            R.layout.playcomponent_recycler_item_playing,
    };

    private LayoutInflater mLayoutInflater;

    public PlayFeedsAdapter(List<BaseFeedPresenter> data) {
        super(data);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mLayoutInflater.inflate(mLayoutIds[viewType], parent, false);
        return PlayViewHolder.newInstance(viewType, view);
    }
}
