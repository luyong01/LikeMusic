package com.ranze.basiclib.util.schedulers;

import io.reactivex.Scheduler;

/**
 * Created by luyong01 on 2018/2/13.
 */

public interface BaseSchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();

}
