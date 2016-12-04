/**
 * 
 */
package com.ece655.entity;

import java.io.Serializable;

/**
 * @ClassName: User.java
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @author Ruins7
 * @version V1.0
 * @Date 2016年10月12日 下午9:13:54
 */

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int uid;
	private String username;
	private String password;
	

	public User() {
		super();
	}

	public User(int uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
