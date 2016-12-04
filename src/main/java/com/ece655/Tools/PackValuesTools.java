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
 * @ClassName:     PackValues.java
 * @Description:   用于拼接SQL查询条件的工具类
 * 
 * @author         Freddy Lee
 * @version        V1.0  
 * @Date           2016.10.15  2:37:27 PM 
 */
public class PackValuesTools {

	/**
	 * 为User表拼接查询条件Values
	 * @return Object[]
	 * @param User
	 */
	public static Object[] packValues(User user){
		if(user == null){
			return null;
		}
		ArrayList list = new ArrayList();
		if (user.getUid() != 0) {
			list.add(user.getUid());
		}
		if (user.getUsername() != null) {
			list.add(user.getUsername());
		}
		if (user.getPassword() != null) {
			list.add(user.getPassword());
		}
		
		Object[] values = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			values[i] = list.get(i);
		}
		return values;
	}
	
	/**
	 * 为Message表拼接查询条件Values
	 * @return Object[]
	 * @param Message
	 */
	public static Object[] packValues(Message message){
		
		ArrayList list = new ArrayList();
		if (message.getMid() != 0) {
			list.add(message.getMid());
		}
		if (message.getUid() != 0) {
			list.add(message.getUid());
		}
		if (message.getTime() != null) {
			list.add(message.getTime());
		}
		if (message.getContent() != null) {
			list.add(message.getContent());
		}
		if (message.getGid() != 0){
			list.add(message.getGid());
		}
		
		Object[] values = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			values[i] = list.get(i);
		}
		return values;
	}
	
	/**
	 * 为Transaction_history表拼接查询条件Values
	 * @return Object[]
	 * @param Transaction_history
	 */
	public static Object[] packValues(UserJoin userJoin){
		
		ArrayList list = new ArrayList();
		if (userJoin.getUjid() != 0) {
			list.add(userJoin.getUjid());
		}
		if (userJoin.getUid() != 0) {
			list.add(userJoin.getUid());
		}
		if (userJoin.getGid() != 0) {
			list.add(userJoin.getGid());
		}
		
		Object[] values = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			values[i] = list.get(i);
		}
		return values;
	}
	
	/**
	 * 为Groups表拼接查询条件Values
	 * @return Object[]
	 * @param Groups
	 */
	public static Object[] packValues(Groups group){
		if(group == null){
			return null;
		}
		ArrayList list = new ArrayList();
		if (group.getGid() != 0) {
			list.add(group.getGid());
		}
		if (group.getGname() != null) {
			list.add(group.getGname());
		}

		Object[] values = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			values[i] = list.get(i);
		}
		return values;
	}
}
