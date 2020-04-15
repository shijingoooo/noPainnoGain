package com.shijing.nopainnogain.demo.juc;

import java.util.concurrent.Phaser;

/**
 * @description:
 * @author: shijing
 * @create: 2020-03-19 21:46
 **/
public class PhaserDemo {
    public static void main(String[] args) {
        int parties = 3;
        int phases = 4;
        final Phaser phaser = new Phaser(parties) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("====== Phase : " + phase + " ======");
                return registeredParties == 0;
            }
        };

        for (int i = 0; i < parties; i++) {
            int threadId = i;
            Thread thread = new Thread(() -> {
                for (int phase = 0; phase < phases; phase++) {
                    System.out.println(String.format("Thread %s, phase %s", threadId, phase));
                    phaser.arriveAndAwaitAdvance();
                }
            });
            thread.start();
        }
    }
}
