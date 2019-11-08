package com.shijing.nopainnogain.Thread.ObservableThread;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: shijing
 * @Date: 19/4/24 15:11
 * @Description:
 */
public class ObservableThreadTest {
    public static void main(String[] args) {
        final TaskLifecycle<String> lifecycle = new EmptyLifecycle<String>(){
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("The result is " + result);
            }
        };

        Observable observableThread = new ObservableThread<>(lifecycle, ()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(" finished done.");
                return "Hello Observer";
            }
        );
        observableThread.start();
    }
}
