/**
 * 
 */
package com.ece655.serviceImpl;

import java.io.Serializable;
import java.util.List;

import com.ece655.dao.MessageDao;
import com.ece655.entity.Message;
import com.ece655.service.MessageService;

/**
 * @ClassName:     MessageServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午1:13:17 
 */
public class MessageServiceImpl implements MessageService{
	
	private MessageDao messageDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Serializable send(Message mess) {
		return messageDao.sendMessage(mess);
	}

	@Override
	public List<Message> findMessInOneGroup(Message mess) {
		
		return messageDao.findAllMessInAGroup(mess);
	}

}
