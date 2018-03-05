package com.ranze.maincomponent.MainUtils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ranze.component.api.ComponentManager;
import com.ranze.componentservice.router.component.ComponentName;
import com.ranze.componentservice.router.component.play.PlayComponent;

/**
 * Created by1 ranze on 2018/3/3.
 */

public class MainUtils {
    public static void addPlaybarFragment(int containerViewId, FragmentManager fragmentManager) {
        Fragment fragment = fragmentManager.findFragmentById(containerViewId);
        if (fragment == null) {
            try {
                PlayComponent playComponent = (PlayComponent) ComponentManager.getInstance().getComponent(ComponentName.PLAY);
                fragment = playComponent.getPlayService().getPlayBarFragment();
                fragmentManager.beginTransaction().add(containerViewId, fragment).commit();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
