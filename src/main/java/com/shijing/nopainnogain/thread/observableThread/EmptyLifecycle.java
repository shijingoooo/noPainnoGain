package com.shijing.nopainnogain.thread.observableThread;

/**
 * @Auther: shijing
 * @Date: 19/4/24 14:55
 * @Description:
 */
public class EmptyLifecycle<T> implements TaskLifecycle<T> {
    @Override
    public void onStart(Thread thread) {

    }

    @Override
    public void onRunning(Thread thread) {

    }

    @Override
    public void onFinish(Thread thread, T result) {

    }

    @Override
    public void onError(Thread thread, Exception e) {

    }
}
