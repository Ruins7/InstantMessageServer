/**
 * 
 */
package com.ece655.serviceImpl;

import java.util.List;

import com.ece655.dao.GroupDao;
import com.ece655.entity.Groups;
import com.ece655.service.GroupService;

/**
 * @ClassName:     GroupServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午1:21:48 
 */
public class GroupServiceImpl implements GroupService{

	private GroupDao groupDao;
	
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public List<Groups> findAllGroups() {
		 
		return groupDao.findAllGroupsByConditions(null);
	}

	@Override
	public Groups findAGroup(Groups group) {
	 
		return groupDao.findAGroup(group);
	}

}
