package com.ranze.basiclib.widget;

import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ranze on 2018/2/23.
 */

public abstract class FeedsAdapter extends BaseAdapter<BaseFeedPresenter> {

    public FeedsAdapter(List<BaseFeedPresenter> data) {
        super(data);
    }

    @Override
    public abstract BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

    @Override
    protected void convert(BaseViewHolder holder, BaseFeedPresenter data, int position) {
        super.convert(holder, data, position);
        holder.setPresenter(data);
    }

    @Override
    public void onViewRecycled(BaseViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setPresenter(null);
    }
}
