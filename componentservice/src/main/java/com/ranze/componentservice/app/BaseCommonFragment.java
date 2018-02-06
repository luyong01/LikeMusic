package com.ranze.componentservice.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.basiclib.BaseFragment;

/**
 * Created by ranze on 2018/2/4.
 */

public abstract class BaseCommonFragment extends BaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().inject(this);
    }
}
