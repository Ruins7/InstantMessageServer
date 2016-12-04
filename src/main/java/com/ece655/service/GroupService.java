/**
 * 
 */
package com.ece655.service;

import java.util.List;

import com.ece655.entity.Groups;

/**
 * @ClassName:     GroupService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午1:15:25 
 */
public interface GroupService {

	public List<Groups> findAllGroups();
	
	public Groups findAGroup(Groups group);
	
}
