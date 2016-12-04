/**
 * 
 */
package com.ece655.dao;

import java.util.List;

import com.ece655.entity.Groups;
import com.ece655.entity.User;
import com.ece655.entity.UserJoin;

/**
 * @ClassName:     GroupDao.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午12:19:56 
 */
public interface GroupDao extends BaseDao<Groups, Integer>{
		
	public Groups findAGroup(Groups group);
	
	public List<Groups> findAllGroupsByConditions(Groups group);

}
