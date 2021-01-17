package com.example.jms.service;

import org.apache.activemq.advisory.ConsumerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author Simple&Happiness
 * @Date 2020/12/25 18:29
 * @Description
 **/
@Component
public class ConsumerService {

    private static Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    /**
     * 使用JmsListener配置消费者监听的队列  spring.jms.pub-sub-domain=false
     * @param receivedMsg 接收到的消息
     */
    @JmsListener(destination = "test-queue")
    public void receiveQueue(String receivedMsg) {
        logger.info("Queue Consumer1收到的报文为: {}", receivedMsg);
    }

    /**
     * 使用JmsListener配置第二个消费者监听的队列
     * @param receivedMsg 接收到的消息
     */
    @JmsListener(destination = "test-queue")
    public void receiveQueue2(String receivedMsg) {
        logger.info("Queue Consumer2收到的报文为: {}", receivedMsg);
    }


    /**
     * 使用JmsListener配置消费者监听的topic  spring.jms.pub-sub-domain=true
     * @param receivedMsg 接收到的消息
     */
    @JmsListener(destination = "test-topic")
    public void receiveTopic(String receivedMsg) {
        logger.info("Topic Consumer1收到的报文为: {}", receivedMsg);
    }

    /**
     * 使用JmsListener配置第二个消费者监听的topic
     * @param receivedMsg 接收到的消息
     */
    @JmsListener(destination = "test-topic")
    public void receiveTopic2(String receivedMsg) {
        logger.info("Topic Consumer2收到的报文为: {}", receivedMsg);
    }
}
