package com.shijing.nopainnogain.Thread.ObservableThread;

/**
 * @Auther: shijing
 * @Date: 19/4/24 14:57
 * @Description:
 */
@FunctionalInterface
public interface Task<T> {
    //任务执行接口，该接口允许有返回值
    T call();
}
