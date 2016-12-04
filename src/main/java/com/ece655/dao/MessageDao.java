/**
 * 
 */
package com.ece655.dao;

import java.io.Serializable;
import java.util.List;

import com.ece655.entity.Message;

/**
 * @ClassName:     MessageDao.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午12:27:07 
 */
public interface MessageDao extends BaseDao<Message, Integer>{

	public Serializable sendMessage(Message mess);
	
	public List<Message> findAllMessInAGroup(Message mess);
	
}
