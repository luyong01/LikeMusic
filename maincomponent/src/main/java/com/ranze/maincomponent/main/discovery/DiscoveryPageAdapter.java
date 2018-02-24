package com.ranze.maincomponent.main.discovery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by luyong01 on 2018/2/11.
 */

public class DiscoveryPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public DiscoveryPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "音乐";
        }
        if (position == 1) {
            return "视频";
        } else if (position == 2) {
            return "电台";
        }
        return "";
    }
}
