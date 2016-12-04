/**
 * 
 */
package com.ece655.service;

import java.io.Serializable;
import java.util.List;

import com.ece655.entity.Message;

/**
 * @ClassName:     MessageService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午1:11:44 
 */
public interface MessageService {
	
	public Serializable send(Message mess);
	
	public List<Message> findMessInOneGroup(Message mess);

}
