package com.ranze.basiclib.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranze.basiclib.R;

/**
 * Created by ranze on 2018/2/10.
 */

public class BaseRecyclerView extends RecyclerView {
    private View mEmptyView;
    private AdapterDataObserver mObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            Adapter adapter = getAdapter();
            if (mEmptyView != null) {
                if (adapter.getItemCount() == 0) {
                    mEmptyView.setVisibility(VISIBLE);
                    BaseRecyclerView.this.setVisibility(GONE);
                } else {
                    mEmptyView.setVisibility(GONE);
                    BaseRecyclerView.this.setVisibility(VISIBLE);
                }
            }
        }
    };

    public BaseRecyclerView(Context context) {
        this(context, null);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEmptyView(View view) {
        mEmptyView = view;

        ((ViewGroup) getRootView()).addView(mEmptyView);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if (mEmptyView == null) {
            mEmptyView = LayoutInflater.from(getContext()).inflate(R.layout.basicres_default_empty_view,
                    (ViewGroup) getParent(), true);
        }

        adapter.registerAdapterDataObserver(mObserver);
        mObserver.onChanged();
    }
}
