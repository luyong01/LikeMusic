package com.ranze.maincomponent.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ranze on 2018/2/10.
 */

public class MainPageAdapter extends FragmentPagerAdapter {
    public List<Fragment> mFragments;

    public MainPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        assert mFragments != null;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
