package com.ranze.maincomponent.main.discovery;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.ranze.maincomponent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranze on 2018/2/10.
 */

public class DiscoveryFragment extends SubCommonFragment {
    private Class[] mFragmentClasses = new Class[]{
            DiscoveryMusicFragment.class,
            DiscoveryVideoFragment.class,
            DiscoveryRadioFragment.class
    };

    private List<Fragment> mFragments;

    @Override
    protected int getLayoutId() {
        return R.layout.maincomponent_frag_discovery;
    }

    @Override
    protected void convert(View rootView) {
        TabLayout tabLayout = rootView.findViewById(R.id.discovery_tab_layout);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());


        initFragments();

        ViewPager viewPager = rootView.findViewById(R.id.discovery_view_pager);
        viewPager.setAdapter(new DiscoveryPageAdapter(getChildFragmentManager(), mFragments));
        viewPager.setOffscreenPageLimit(2);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragments() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        for (Class cls : mFragmentClasses) {
            Fragment fragment = childFragmentManager.findFragmentByTag(cls.getSimpleName());
            if (fragment == null) {
                try {
                    fragment = (Fragment) cls.newInstance();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            mFragments.add(fragment);
        }
    }

    @Override
    protected void loadData() {
        Log.d("test", "discovery loadData");
        mDataLoaded = true;
    }

    public static DiscoveryFragment newInstance(String string) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, string);
        fragment.setArguments(bundle);
        return fragment;
    }
}
