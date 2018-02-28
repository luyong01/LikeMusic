package com.ranze.maincomponent.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranze.basiclib.widget.BaseFeedPresenter;
import com.ranze.basiclib.widget.BaseViewHolder;
import com.ranze.basiclib.widget.FeedsAdapter;
import com.ranze.maincomponent.R;

import java.util.List;

/**
 * Created by ranze on 2018/2/24.
 */

public class MainFeedsAdapter extends FeedsAdapter {
    // 与 Itemtype 顺序对应
    private int[] mLayoutIds = new int[]{
            R.layout.maincomponent_item_play_list,
            R.layout.maincomponent_item_play_title,
            R.layout.maincomponent_item_detail_list,
    };

    private LayoutInflater mLayoutInflater;

    public MainFeedsAdapter(List<BaseFeedPresenter> data) {
        super(data);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mLayoutInflater.inflate(mLayoutIds[viewType], parent, false);
        return MainViewHolder.newInstance(viewType, view);
    }
}
