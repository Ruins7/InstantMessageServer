/**
 * 
 */
package com.ece655.dao;

import java.io.Serializable;
import java.util.List;

import com.ece655.entity.User;
import com.ece655.entity.UserJoin;

/**
 * @ClassName:     UserJoinDao.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午12:25:56 
 */
public interface UserJoinDao extends BaseDao<UserJoin, Integer>{

	public Serializable joinGroup(UserJoin userJoin);
	
	public int quitGroup(UserJoin userJoin);
	
	public List<UserJoin> findAllGroupsAUserJoined(UserJoin userJoin);
}
