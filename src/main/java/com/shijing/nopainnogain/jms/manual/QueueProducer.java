package com.shijing.nopainnogain.jms.manual;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;
import java.util.UUID;

public class QueueProducer {
    private static final String BROKER_URL = "tcp://192.168.159.132:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        // 1.创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        connectionFactory.setUseAsyncSend(true);
        // 2.获取连接并启动
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 3.创建Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4.创建目的地 队列/主题
        Destination queue = session.createQueue(QUEUE_NAME);
        // 5.创建生产者
//        MessageProducer producer = session.createProducer(queue);
        ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT); // 开启JDBC持久化

        //延时投递和定时投递
        long delay = 3 * 1000;
        long period = 4 * 1000;
        int repeat = 5;

        // 6.创建3条消息
        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("msg---" + i);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);
            // 7.发布消息
//            producer.send(textMessage);
            textMessage.setJMSMessageID(UUID.randomUUID().toString() + "---async");
            String msgID = textMessage.getJMSMessageID();
            producer.send(textMessage, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("success: " + msgID);
                }

                @Override
                public void onException(JMSException e) {
                    System.out.println("fail: " + msgID);
                }
            });
        }

        // 关闭连接
        producer.close();
        session.close();
        connection.close();

        System.out.println("发布完成");
    }
}
