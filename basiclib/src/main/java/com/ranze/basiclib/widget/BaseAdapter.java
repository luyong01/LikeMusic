package com.ranze.basiclib.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ranze on 2018/2/10.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.VH> {
    enum ITEM_TYPE {
        HEADER,
        FOOTER,
        NORMAL,
    }

    protected List<T> mData;
    private View mHeaderView;
    private View mFooterView;
    private View mEmptyView;

    public BaseAdapter(List<T> data) {
        this.mData = data;
    }

    public void setData(List<T> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    protected abstract int getLayoutId(int viewType);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {

        return VH.get(parent, getLayoutId(viewType));

    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        convert(holder, mData.get(position), position);

    }

    protected void convert(VH holder, T data, int position) {

    }

    public void addHeaderView(View view) {
        this.mHeaderView = view;
    }

    public void addFooterView(View view) {
        this.mFooterView = view;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0) {
//            return ITEM_TYPE.HEADER.ordinal();
//        } else if (position == mData.size() + 1) {
//            return ITEM_TYPE.NORMAL.ordinal();
//        } else {
//            return ITEM_TYPE.NORMAL.ordinal();
//        }
//    }

    @Override
    public void registerAdapterDataObserver(AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
    }

    protected static class VH extends RecyclerView.ViewHolder {
        private SparseArray<View> mViews;
        private View mConvertView;

        private VH(View itemView) {
            super(itemView);
            mConvertView = itemView;
            mViews = new SparseArray<>();
        }

        static VH get(ViewGroup parent, int layoutId) {
            View convertView = LayoutInflater.from(parent.getContext()).inflate(
                    layoutId, parent, false);
            return new VH(convertView);
        }

        <T extends View> T getView(int id) {
            View view = mViews.get(id);
            if (view == null) {
                view = mConvertView.findViewById(id);
                mViews.put(id, view);
            }
            return (T) view;
        }

        public void setText(int id, String text) {
            TextView view = getView(id);
            view.setText(text);
        }
    }
}
