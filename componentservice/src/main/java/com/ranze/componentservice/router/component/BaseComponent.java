package com.ranze.componentservice.router.component;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.component.api.IComponent;

/**
 * Created by ranze on 2018/2/4.
 */

public class BaseComponent implements IComponent {
    public BaseComponent() {
        ARouter.getInstance().inject(this);
    }
}
