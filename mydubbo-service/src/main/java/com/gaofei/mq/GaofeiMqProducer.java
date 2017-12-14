package com.gaofei.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产消息，消息入队
 */
@Component
public class GaofeiMqProducer {

    private static final Logger logger = LoggerFactory.getLogger(GaofeiMqProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplateNoExchange;
    public void sendDataToQueue(Object obj) {
        try {
            rabbitTemplateNoExchange.convertAndSend("routeKey", obj);
        } catch (Exception e) {
            logger.warn("异常", e);
        }
    }

}
