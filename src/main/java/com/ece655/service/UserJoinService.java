/**
 * 
 */
package com.ece655.service;

import java.io.Serializable;
import java.util.List;

import com.ece655.entity.UserJoin;

/**
 * @ClassName:     UserJoinService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午1:07:08 
 */
public interface UserJoinService{
	
	public Serializable join(UserJoin userJoin);
	
	public int quit(UserJoin userJoin);
	
	public List<UserJoin> searchJoinedGroups(UserJoin userJoin);

}
