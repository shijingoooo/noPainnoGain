package com.shijing.nopainnogain.JVM.test02;

/**
 * @Auther: shijing
 * @Date: 18/11/22 17 30
 * @Description: -Xss2M
 */
public class JavaVmStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }
}
