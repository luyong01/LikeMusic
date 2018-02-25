package com.ranze.basiclib.widget;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ranze on 2018/2/23.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;

    protected BaseFeedPresenter mPresenter;

    protected BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
        mConvertView = itemView;
    }

    public void setPresenter(BaseFeedPresenter presenter) {
        if (mPresenter != null) {
            mPresenter.setView(null);
        }
        mPresenter = presenter;
        if (presenter != null) {
            presenter.setView(this);
            presenter.onAttach();
        }

    }

    public BaseFeedPresenter getPresenter() {
        return mPresenter;
    }

    static BaseViewHolder get(ViewGroup parent, int layoutId) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(
                layoutId, parent, false);
        return new BaseViewHolder(convertView);
    }

    public <T extends View> T getView(int id) {
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
