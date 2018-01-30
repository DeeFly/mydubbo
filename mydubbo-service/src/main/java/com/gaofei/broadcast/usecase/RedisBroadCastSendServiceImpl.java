package com.gaofei.broadcast.usecase;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaofei.broadcast.BroadcastPublisher;
import com.gaofei.broadcast.XueleMessage;
import com.gaofei.broadcast.XueleMessageConstants;
import com.gaofei.redis.RedisBroadCastSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端发送消息
 */
@Service
public class RedisBroadCastSendServiceImpl implements RedisBroadCastSendService {
	
    private static Logger logger = LoggerFactory.getLogger(RedisBroadCastSendServiceImpl.class);

	public boolean sendMessage(){
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
