/**
 * 
 */
package com.ece655.Tools;

import java.util.ArrayList;

import com.ece655.entity.Groups;
import com.ece655.entity.Message;
import com.ece655.entity.User;
import com.ece655.entity.UserJoin;

/**
 * @ClassName:     PackSQLTools.java
 * @Description:   用于拼接SQL查询语句的工具类 
 * @author         Freddy Lee
 * @version        V1.0  
 * @Date           2016.10.15  2:37:49  PM
 */
public class PackSQLTools {

	/**
	 * 为User表拼接SQL 条件查询
	 * @return String 
	 * @param User
	 */
	public static String packSQL(User user) {
		if(user == null){
			return "select * from user";
		}
		StringBuffer sqlselect = new StringBuffer("select * from user where");
		StringBuffer sqlid = new StringBuffer(" uid = ?");
		StringBuffer sqlname = new StringBuffer(" username = ?");
		StringBuffer sqlpwd = new StringBuffer(" password = ?");
		ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();

		if (user.getUid() != 0) {
			list.add(sqlid);
		}
		if (user.getUsername() != null) {
			list.add(sqlname);
		}
		if (user.getPassword() != null) {
			list.add(sqlpwd);
		}
		return insertAnd(list, sqlselect);
	}
	
	/**
	 * 为Message表拼接SQL 条件查询
	 * @return String 
	 * @param Message
	 */
	public static String packSQL(Message message) {
		if(message == null){
			return "select * from message";
		}
		StringBuffer sqlselect = new StringBuffer("select * from message where");
		StringBuffer sqlid = new StringBuffer(" mid = ?");
		StringBuffer sqluid = new StringBuffer(" uid = ?");
		StringBuffer sqltime = new StringBuffer(" time = ?");
		StringBuffer sqlcontent = new StringBuffer(" content = ?");
		StringBuffer sqlgid = new StringBuffer(" gid = ?");
		ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();

		if (message.getMid() != 0) {
			list.add(sqlid);
		}
		if (message.getUid() != 0) {
			list.add(sqluid);
		}
		if (message.getTime() != null) {
			list.add(sqltime);
		}
		if (message.getContent() != null) {
			list.add(sqlcontent);
		}
		if (message.getGid() != 0){
			list.add(sqlgid);
		}
		return insertAnd(list, sqlselect);
	}
	
	/**
	 * 为UserJoin表拼接SQL 条件查询
	 * @return String 
	 * @param UserJoin
	 */
	public static String packSQL(UserJoin userJoin) {
		if(userJoin == null){
			return "select * from userjoin";
		}
		StringBuffer sqlselect = new StringBuffer("select * from userjoin where");
		StringBuffer sqlid = new StringBuffer(" ujid = ?");
		StringBuffer sqluid = new StringBuffer(" uid = ?");
		StringBuffer sqlgid = new StringBuffer(" gid = ?");
		ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();

		if (userJoin.getUjid() != 0) {
			list.add(sqlid);
		}
		if (userJoin.getUid() != 0) {
			list.add(sqluid);
		}
		if (userJoin.getGid() != 0) {
			list.add(sqlgid);
		}
		return insertAnd(list, sqlselect);
	}
	
	/**
	 * 为Groups表拼接SQL 条件查询
	 * @return String 
	 * @param Groups
	 */
	public static String packSQL(Groups group) {
		if(group == null){
			return "select * from groups";
		}
		StringBuffer sqlselect = new StringBuffer("select * from groups where");
		StringBuffer sqlid = new StringBuffer(" uhid = ?");
		StringBuffer sqlgname = new StringBuffer(" uhuid = ?");
		ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();

		if (group.getGid() != 0) {
			list.add(sqlid);
		}
		if (group.getGname() != null) {
			list.add(sqlgname);
		}
		return insertAnd(list, sqlselect);
	}
	
	private static String insertAnd(ArrayList list, StringBuffer sqlselect){
		for (int i = 0; i < list.size(); i++) {
			sqlselect.append(list.get(i));
		}
		for (int i = 0; i < sqlselect.length(); i++) {
			if (sqlselect.charAt(i) == '?' && i != sqlselect.length() - 1) {
				sqlselect.insert(i + 1, " and");
			}
		}
		return sqlselect.toString();	
	}
}
