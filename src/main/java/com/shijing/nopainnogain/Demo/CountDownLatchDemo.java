package com.shijing.nopainnogain.Demo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public enum CountTryEnum{
        ONE(1, "齐"),
        TWO(2, "楚"),
        THREE(3, "燕"),
        FORE(4, "韩"),
        FIVE(5, "赵"),
        SIX(6, "魏");

        private Integer code;

        private String value;

        private CountTryEnum(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static CountTryEnum get(int code) {
            CountTryEnum[] myArray = CountTryEnum.values();
            for (CountTryEnum item : myArray) {
                if (code == item.getCode())
                    return item;
            }
            return null;
        }

    }

    public static void main(String[] args) throws Exception {

        countDownLatch();
    }

    private static void countDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教师");
                countDownLatch.countDown();
            }, CountTryEnum.get(i).getValue()).start();
        }
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t *****班长最后关门走人");
    }
}
