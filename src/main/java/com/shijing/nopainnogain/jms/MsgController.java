package com.shijing.nopainnogain.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MsgController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/queue/send")
    public String sendQueueMsg(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        jmsTemplate.convertAndSend(new ActiveMQQueue("queue.test"), 123);
        return "SUCCESS";
    }

    @GetMapping("/topic/send")
    public String sendTopicMsg(){
        User user = new User();
        user.setId(1);
        user.setName("Tom");
        jmsTemplate.setMessageConverter(new UserMessageConverter());
        jmsTemplate.convertAndSend(new ActiveMQTopic("topic.test"), user);
        return "SUCCESS";
    }
}
