/**
 * 
 */
package com.ece655.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.ece655.Tools.PackSQLTools;
import com.ece655.Tools.PackValuesTools;
import com.ece655.dao.UserJoinDao;
import com.ece655.entity.UserJoin;

/**
 * @ClassName:     UserJoinDaoImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午12:37:38 
 */
public class UserJoinDaoImpl extends BaseDaoImpl<UserJoin, Integer> implements UserJoinDao{

	@Override
	public Serializable joinGroup(UserJoin userJoin) {
		return save(userJoin);
	}

	@Override
	public int quitGroup(UserJoin userJoin) {
		List<UserJoin> ujlist = getListBySQL(PackSQLTools.packSQL(userJoin), PackValuesTools.packValues(userJoin));
		for (UserJoin userJoin2 : ujlist) {
			delete(userJoin2);
		}
		return 1;
	}

	@Override
	public List<UserJoin> findAllGroupsAUserJoined(UserJoin userJoin) {
		return getListBySQL(PackSQLTools.packSQL(userJoin), PackValuesTools.packValues(userJoin));
	}

}
