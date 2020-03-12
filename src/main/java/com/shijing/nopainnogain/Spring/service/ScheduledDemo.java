package com.shijing.nopainnogain.Spring.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledDemo {

    /**
     * 0 0 0 ? * 1,5
     */
    /*@Scheduled(cron = "* * * * * ?")
    public void doJob() {
        System.out.println(System.currentTimeMillis());
    }*/
}
