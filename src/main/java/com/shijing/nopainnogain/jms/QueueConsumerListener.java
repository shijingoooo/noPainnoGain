package com.shijing.nopainnogain.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 **/
@Component
public class QueueConsumerListener {
    @JmsListener(destination = "queue.test", containerFactory = "queueListenerContainerFactory")
    public void receive(String message) {
        System.out.println("消费者接收到消息：" + message);
    }
}
