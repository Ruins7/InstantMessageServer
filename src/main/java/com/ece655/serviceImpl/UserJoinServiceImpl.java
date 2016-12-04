/**
 * 
 */
package com.ece655.serviceImpl;

import java.io.Serializable;
import java.util.List;

import com.ece655.dao.UserJoinDao;
import com.ece655.entity.UserJoin;
import com.ece655.service.UserJoinService;

/**
 * @ClassName:     UserJoinServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午1:09:52 
 */
public class UserJoinServiceImpl implements UserJoinService {

	private UserJoinDao userJoinDao;
	
	public void setUserJoinDao(UserJoinDao userJoinDao) {
		this.userJoinDao = userJoinDao;
	}

	@Override
	public Serializable join(UserJoin userJoin) {
		 
		return userJoinDao.joinGroup(userJoin);
	}

	@Override
	public int quit(UserJoin userJoin) {
		 
		return userJoinDao.quitGroup(userJoin);
	}

	@Override
	public List<UserJoin> searchJoinedGroups(UserJoin userJoin) {
		 
		return userJoinDao.findAllGroupsAUserJoined(userJoin);
	}

}
