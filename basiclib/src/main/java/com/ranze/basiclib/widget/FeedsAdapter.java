package com.ranze.basiclib.widget;

import android.view.ViewGroup;

import com.ranze.basiclib.util.LogUtil;

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
        LogUtil.d("getItemViewType: " + position);
        return mData.get(position).getType();
    }

    @Override
    protected void convert(BaseViewHolder holder, BaseFeedPresenter data, int position) {
        super.convert(holder, data, position);
//        holder.setText(R.id.item_title, data.getName());
        holder.setPresenter(data);
    }
}
