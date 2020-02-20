package com.shijing.nopainnogain.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumerListener {
    @JmsListener(destination = "topic.test", containerFactory = "topicListenerContainerFactory")
    public void receive1(User user) {
        System.out.println("Topic.Subscribe.receive1接收消息：" + user.toString());
    }

    @JmsListener(destination = "topic.test", containerFactory = "topicListenerContainerFactory")
    public void receive2(User user) {
        System.out.println("Topic.Subscribe.receive2接收消息：" + user.toString());
    }
}
