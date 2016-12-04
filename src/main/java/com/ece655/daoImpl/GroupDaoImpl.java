/**
 * 
 */
package com.ece655.daoImpl;

import java.util.List;

import com.ece655.Tools.PackSQLTools;
import com.ece655.Tools.PackValuesTools;
import com.ece655.dao.GroupDao;
import com.ece655.entity.Groups;

/**
 * @ClassName:     GroupDaoImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午12:39:35 
 */
public class GroupDaoImpl extends BaseDaoImpl<Groups, Integer> implements GroupDao{

	@Override
	public List<Groups> findAllGroupsByConditions(Groups group) {
		return getListBySQL(PackSQLTools.packSQL(group), PackValuesTools.packValues(group));
	}

	@Override
	public Groups findAGroup(Groups group) {
		return get(group.getGid());
	}
	
}
