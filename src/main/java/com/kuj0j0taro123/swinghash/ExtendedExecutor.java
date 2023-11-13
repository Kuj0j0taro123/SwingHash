package com.kuj0j0taro123.swinghash;

import com.kuj0j0taro123.swinghash.gui.GUIUpdater;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExtendedExecutor extends ThreadPoolExecutor {
    int tasks;
    public ExtendedExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        tasks = 0;
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        if (tasks == 0)
            GUIUpdater.startExecution();
        tasks += 1;
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        tasks -= 1;
        if (tasks == 0){
            GUIUpdater.endExecution();
        }

    }
}
