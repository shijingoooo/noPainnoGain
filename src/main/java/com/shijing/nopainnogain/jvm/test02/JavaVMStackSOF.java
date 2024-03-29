package com.shijing.nopainnogain.jvm.test02;

/**
 * @Auther: Founder
 * @Date: 18/11/22 17 19
 * @Description: VM Args: -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        }catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength );
            throw e;
        }
    }
}
