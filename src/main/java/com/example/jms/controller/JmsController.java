package com.example.jms.controller;

import com.example.jms.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @Author Simple&Happiness
 * @Date 2020/12/25 18:31
 * @Description
 **/
@RestController
public class JmsController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/queue/produce")
    public String queueProduce(){
        Destination destination = new ActiveMQQueue("test-queue");
        for (int i = 0; i < 100; i++) {
            producerService.sendMessage(destination, "test "+i);
        }
        return "发送成功！";
    }

    @GetMapping("/topic/produce")
    public String topicProduce(){
        Destination destination = new ActiveMQTopic("test-topic");
        for (int i = 0; i < 100; i++) {
            producerService.sendMessage(destination, "test "+i);
        }
        return "发送成功！";
    }
}
