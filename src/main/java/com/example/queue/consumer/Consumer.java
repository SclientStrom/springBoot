package com.example.queue.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2017/7/14.
 */
@Component
public class Consumer {

    @JmsListener(destination = "queue1" )
    public void receiveQueue(String text){
        System.out.println("this is queue1 "+text);
    }

    @JmsListener(destination = "queue2")
    public void receiveQueue2(String text){
        System.out.println("this is queue2"+text);
    }
}
