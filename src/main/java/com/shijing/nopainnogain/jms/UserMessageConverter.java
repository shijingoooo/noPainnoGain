package com.shijing.nopainnogain.jms;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

public class UserMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        System.out.println("sendMessage:" + o.toString());
        ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
        msg.setObject((Serializable) o);
        return msg;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        User user = null;
        if(message instanceof ActiveMQObjectMessage){
            ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) message;
            user=(User) aMsg.getObject();
        }
        return user;
    }
}
