package com.gaofei.broadcast.usecase;

import com.gaofei.broadcast.BroadcastPublisher;
import com.gaofei.broadcast.XueleMessage;
import com.gaofei.broadcast.XueleMessageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户端发送消息
 */
@Service
public class SendTeachLogDetailServiceImpl{
	
    private static Logger logger = LoggerFactory.getLogger(SendTeachLogDetailServiceImpl.class);

	public boolean sendGrowingMessage(){
		boolean result = false;
		try{
				XueleMessage msg = new XueleMessage(XueleMessageConstants.TOPIC_TEACH_ACTION, "jsonString");
				BroadcastPublisher.publish(msg);
				result =  true;
		  } catch (Exception e) {
		        return false;
		  }
		return result;
	}
}
