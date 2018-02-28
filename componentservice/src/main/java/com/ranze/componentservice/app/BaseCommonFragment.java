package com.ranze.componentservice.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.basiclib.BaseFragment;

/**
 * Created by ranze on 2018/2/4.
 */

public abstract class BaseCommonFragment extends BaseFragment {
    public static final String ARG_PARAM = "param_key";
    protected Bundle mParam;
    protected Activity mActivity;

    protected boolean mDataLoaded;
    protected boolean mUIPrepared;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        Bundle arguments = getArguments();
        if (arguments != null) {
            mParam = arguments.getBundle(ARG_PARAM);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        convert(rootView);
        mUIPrepared = true;
        lazyLoad();
        return rootView;
    }

    protected abstract int getLayoutId();

    protected abstract void convert(View rootView);

    protected void lazyLoad() {
        if (getUserVisibleHint() && mUIPrepared && !mDataLoaded) {
            loadData();

            //loadData 内部通常是异步加载，所以也许还没有真正加载数据
//            mDataLoaded = true;
        }
    }

    /**
     * 子类加载数据后应设置 mDataLoaded = true, 避免重复加载
     */
    protected abstract void loadData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }
}
