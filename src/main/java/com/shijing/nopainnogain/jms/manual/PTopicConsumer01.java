package com.shijing.nopainnogain.jms.manual;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class PTopicConsumer01 {

    private static final String BROKER_URL = "tcp://192.168.159.132:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException, IOException {

        // 1.创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        // 2.获取连接并启动
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("z3");
        // 3.创建Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4.创建目的地 队列/主题
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark...");
        connection.start();
        // 5.创建消费者
        // 6.设置监听接收消息
        topicSubscriber.setMessageListener((message)->{
            if (message instanceof TextMessage) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //
        System.in.read();
        // 关闭连接
        topicSubscriber.close();
        session.close();
        connection.close();

        System.out.println("接收完成");

    }

}
