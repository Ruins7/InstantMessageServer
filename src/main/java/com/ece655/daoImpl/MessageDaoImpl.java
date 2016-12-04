/**
 * 
 */
package com.ece655.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.ece655.Tools.PackSQLTools;
import com.ece655.Tools.PackValuesTools;
import com.ece655.dao.MessageDao;
import com.ece655.entity.Message;

/**
 * @ClassName:     MessageDaoImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午12:29:33 
 */
public class MessageDaoImpl extends BaseDaoImpl<Message, Integer> implements MessageDao{

	@Override
	public Serializable sendMessage(Message mess) {
		return save(mess);
	}

	@Override
	public List<Message> findAllMessInAGroup(Message mess) {
		 
		return getListBySQL(PackSQLTools.packSQL(mess), PackValuesTools.packValues(mess));
	}

}
