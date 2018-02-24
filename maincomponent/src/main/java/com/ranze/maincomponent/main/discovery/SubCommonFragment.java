package com.ranze.maincomponent.main.discovery;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.ranze.componentservice.app.BaseCommonFragment;

import java.util.List;

/**
 * 这个类就为了解决下面的问题：
 * ViewPager 嵌套使用时，会出现父 Fragment 未显示，子 Fragment 出现 setUserVisibleHint(true) 的情形
 * Created by luyong01 on 2018/2/11.
 */

public abstract class SubCommonFragment extends BaseCommonFragment {
    private boolean mWaitingShow;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getUserVisibleHint()) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null && !parentFragment.getUserVisibleHint()) {
                mWaitingShow = true;
                super.setUserVisibleHint(false);
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getActivity() != null) {
            List<Fragment> childFragments = getChildFragmentManager().getFragments();
            if (isVisibleToUser) {
                if (childFragments != null) {
                    for (Fragment childFragment : childFragments) {
                        if (childFragment instanceof SubCommonFragment) {
                            SubCommonFragment subCommonFragment = (SubCommonFragment) childFragment;
                            if (subCommonFragment.isWaitingShow()) {
                                subCommonFragment.setUserVisibleHint(true);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isWaitingShow() {
        return mWaitingShow;
    }

    public void setWaitingShow(boolean waitingShow) {
        mWaitingShow = waitingShow;
    }
}
