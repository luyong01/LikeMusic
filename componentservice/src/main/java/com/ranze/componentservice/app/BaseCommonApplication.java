package com.ranze.componentservice.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.basiclib.BaseApplication;
import com.ranze.component.api.ComponentManager;

/**
 * Created by ranze on 2018/2/4.
 */

public abstract class BaseCommonApplication extends BaseApplication {
    /**
     * 初始化路由和组件manger
     *
     * @param isDebug 是否调试模式
     */
    protected final void initRouterAndComponent(boolean isDebug) {
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化

        if (isDebug) {
            ComponentManager.openDebuggable(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ComponentManager.init(this); // 必须在ARouter初始化后进行，因为组件对象有可能回包含ARouter对应的IOC
    }
}
