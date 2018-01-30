package com.gaofei.broadcast.usecase;


import com.gaofei.broadcast.BroadcastConsumer;
import com.gaofei.broadcast.XueleMessage;
import com.gaofei.broadcast.XueleMessageConstants;
import com.gaofei.broadcast.XueleMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 客户端接收消息
 */
@Component
public class TeacherMigrateDataConsumer implements XueleMessageListener {

    private static Logger logger = LoggerFactory.getLogger(TeacherMigrateDataConsumer.class);

    @PostConstruct
    public void init() {
        BroadcastConsumer.subscriberOnce(XueleMessageConstants.TOPIC_TEACH_ACTION, this);
    }

    public void handleMessage(XueleMessage xueleMessage) {
        logger.info("here it come!");
        //do someThing
    }

}
