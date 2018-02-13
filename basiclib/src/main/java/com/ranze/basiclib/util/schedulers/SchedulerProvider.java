package com.ranze.basiclib.util.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by luyong01 on 2018/2/13.
 */

public class SchedulerProvider implements BaseSchedulerProvider {
    private volatile static SchedulerProvider sIntance;

    private SchedulerProvider() {

    }

    public static SchedulerProvider getInstance() {
        if (sIntance == null) {
            synchronized (SchedulerProvider.class) {
                if (sIntance == null) {
                    sIntance = new SchedulerProvider();
                }
            }
        }
        return sIntance;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
