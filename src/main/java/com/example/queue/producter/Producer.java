package com.example.queue.producter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * Created by ThinkPad on 2017/7/14.
 */
@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource(name = "queue1")
    private Queue queue1;
    @Resource(name = "queue2")
    private Queue queue2;

//    @Scheduled(fixedDelay=3000)//每3s执行1次
    public void send1(String message) {
        this.jmsMessagingTemplate.convertAndSend(this.queue1, message);
    }
    @Scheduled(fixedDelay=60000)//每6s执行1次
    public void send2() {
        this.jmsMessagingTemplate.convertAndSend(this.queue2, "hi,activeMQ queue2");
    }
}
