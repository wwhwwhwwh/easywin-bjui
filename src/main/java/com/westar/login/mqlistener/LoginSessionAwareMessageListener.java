package com.westar.login.mqlistener;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.westar.common.model.RpNotifyRecord;
import com.westar.login.services.LoginService;

/**
 * 
 * @描述: 队列监听器 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-3-17,下午11:21:23 .
 * @版本号: V1.0 .
 */
@Component
public class LoginSessionAwareMessageListener implements SessionAwareMessageListener<Message> {

	private static final Log log = LogFactory.getLog(LoginSessionAwareMessageListener.class);

	@Autowired
	private JmsTemplate activeMqJmsTemplate;
	
	@Autowired
	private Destination sessionAwareQueue;
	
	@Autowired
	private LoginService loginService;

	public synchronized void onMessage(Message message, Session session) {
		try {
			ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
			final String ms = msg.getText();
			log.info("==>receive message:" + ms);
			RpNotifyRecord rpNotifyRecord = JSONObject.parseObject(ms, RpNotifyRecord.class);// 转换成相应的对象
			loginService.updateRpNotifyRecord(rpNotifyRecord);
		} catch (Exception e) {
			log.error("==>", e);
		}
	}
}