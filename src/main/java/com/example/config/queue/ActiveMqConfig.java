package com.example.config.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Created by ThinkPad on 2017/7/14.
 */
@Configuration
public class ActiveMqConfig {
    @Bean(name = "queue1")
    public Queue test2queue(){
        return new ActiveMQQueue("queue1");
    }
    @Bean(name = "queue2")
    public Queue test1queue(){
        return new ActiveMQQueue( "queue2");
    }
}
