package com.gaofei.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 保存动态事件处理.
 */
@Component
public class DeletePostConsumer implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(DeletePostConsumer.class);

    public void onMessage(Message message) {
        try {
            //do something
        } catch (Exception e) {
            byte[] bs = message.getBody();
            String body = bs != null ? new String(bs) : "";
            logger.error("删除动态错误" + body, e);
        }
    }
}
