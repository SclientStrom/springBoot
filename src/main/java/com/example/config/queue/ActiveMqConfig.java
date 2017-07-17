package com.example.config.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.network.jms.JmsMesageConvertor;
import org.apache.activemq.network.jms.SimpleJmsMessageConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Connection;
import javax.jms.Queue;

/**
 * Created by ThinkPad on 2017/7/14.
 */
@Configuration
@PropertySource(value = "classpath:activemq.properties")
public class ActiveMqConfig {
    @Bean(name = "queue1" )
    public Queue test2queue(){
        return new ActiveMQQueue("queue1");
    }
    @Bean(name = "queue2")
    public Queue test1queue(){
        return new ActiveMQQueue( "queue2");
    }
}
