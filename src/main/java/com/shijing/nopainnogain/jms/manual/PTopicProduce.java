package com.shijing.nopainnogain.jms.manual;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PTopicProduce {
    private static final String BROKER_URL = "tcp://192.168.159.132:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {
        // 1.创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        // 2.获取连接
        Connection connection = connectionFactory.createConnection();
        // 3.创建Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4.创建目的地 队列/主题
        Destination topic = session.createTopic(TOPIC_NAME);
        // 5.创建生产者
        MessageProducer producer = session.createProducer(topic);
        // 持久化topic
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        // 启动
        connection.start();
        // 6.创建3条消息
        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("msg---" + i);
            // 7.发布消息
            producer.send(textMessage);
        }

        // 关闭连接
        producer.close();
        session.close();
        connection.close();

        System.out.println("发布完成");
    }
}
