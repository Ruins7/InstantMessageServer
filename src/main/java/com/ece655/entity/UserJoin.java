package com.ece655.entity;

import java.io.Serializable;

public class UserJoin implements Serializable{
	
	private int ujid;
	private int uid;
	private int gid;
	
	public UserJoin() {
		super();
	}
	public UserJoin(int ujid, int uid, int gid) {
		super();
		this.ujid = ujid;
		this.uid = uid;
		this.gid = gid;
	}
	public int getUjid() {
		return ujid;
	}
	public void setUjid(int ujid) {
		this.ujid = ujid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	

}
