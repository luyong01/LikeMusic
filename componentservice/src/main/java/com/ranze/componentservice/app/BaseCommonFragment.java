package com.ranze.componentservice.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.basiclib.BaseFragment;

/**
 * Created by ranze on 2018/2/4.
 */

public abstract class BaseCommonFragment extends BaseFragment {
    public static final String ARG_PARAM = "param_key";
    protected String mParam;
    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        Bundle arguments = getArguments();
        if (arguments != null) {
            mParam = arguments.getString(ARG_PARAM);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().inject(this);
    }
}
