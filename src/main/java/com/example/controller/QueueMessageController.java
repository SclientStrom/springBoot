package com.example.controller;

import com.example.domain.User;
import com.example.queue.producter.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Name;

/**
 * Created by ThinkPad on 2017/7/17.
 */
@Controller
public class QueueMessageController {
    @Autowired
    private Producer producer;
    @RequestMapping("/message.json")
    @ResponseBody
    public String sendMessageToQueue(@RequestBody User user){
        producer.send1(user.toString());
        return "success";
    }
}
