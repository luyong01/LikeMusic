package com.ranze.maincomponent.music;

import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.widget.BaseAdapter;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.data.model.PlayList;

import java.util.List;

/**
 * Created by ranze on 2018/2/23.
 */

public class FeedsAdapter extends BaseAdapter<PlayList.PlaylistBean> {
    // 与 Itemtype 顺序对应
    private static final int[] LAYOUT_ID = new int[]{
            R.layout.maincomponent_item_normal_linear,
            R.layout.maincomponent_item_normal_title,
    };

    public FeedsAdapter(List<PlayList.PlaylistBean> data) {
        super(data);
    }

    @Override
    protected int getLayoutId(int viewType) {
        LogUtil.d("viewType = " + viewType);
        return LAYOUT_ID[viewType];

    }

    @Override
    public int getItemViewType(int position) {
        LogUtil.d("getItemViewType: " + position);
        return mData.get(position).getItemType();
    }

    @Override
    protected void convert(BaseAdapter.VH holder, PlayList.PlaylistBean data, int position) {
        super.convert(holder, data, position);
        holder.setText(R.id.item_title, data.getName());
    }
}
