package com.ranze.maincomponent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ranze.componentservice.app.BaseCommonFragment;
import com.ranze.maincomponent.discovery.DiscoveryFragment;
import com.ranze.maincomponent.friends.FriendsFragment;
import com.ranze.maincomponent.music.MusicFragment;
import com.ranze.maincomponent.router.path.PathConstants;

import java.util.ArrayList;
import java.util.List;

@Route(path = PathConstants.VIEW_MAIN)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RadioGroup mRadioGroup;
    private ViewPager mViewPager;
    private int currentPos;
    private static final String VIEW_PAGER_POS = "view pager pos";
    private Class[] fragmentClasses = new Class[]{
            MusicFragment.class,
            DiscoveryFragment.class,
            FriendsFragment.class,

    };
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincomponent_activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.maincomponent_navigation_drawer_open,
                R.string.maincomponent_navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRadioGroup = findViewById(R.id.main_radio_group);
        mViewPager = findViewById(R.id.main_view_pager);


        initRadioEvents();
        initFragments();

        if (savedInstanceState != null) {
            currentPos = savedInstanceState.getInt(VIEW_PAGER_POS);
        }

        initViewPagerEvents();
    }

    private void initViewPagerEvents() {
        MainPageAdapter pageAdapter = new MainPageAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(pageAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.btn_music);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.btn_discovery);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.btn_friends);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setCurrentItem(currentPos);
    }

    private void initRadioEvents() {
        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.btn_music) {
                mViewPager.setCurrentItem(0);
            } else if (checkedId == R.id.btn_discovery) {
                mViewPager.setCurrentItem(1);
            } else if (checkedId == R.id.btn_friends) {
                mViewPager.setCurrentItem(2);
            }
        });
    }

    private void initFragments() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        for (Class cls : fragmentClasses) {
            BaseCommonFragment fragment = (BaseCommonFragment) fragmentManager.findFragmentByTag(cls.getSimpleName());
            if (fragment == null) {
                try {
                    fragment = (BaseCommonFragment) cls.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            mFragments.add(fragment);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(VIEW_PAGER_POS, currentPos);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maincomponent_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
