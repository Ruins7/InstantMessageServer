package com.ece655.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{

	private int mid;
	private int uid;
	private String time;
	private String content;
	private int gid;
	
	public Message() {
		super();
	}
	public Message(int mid, int uid, String time, String content, int gid) {
		super();
		this.mid = mid;
		this.uid = uid;
		this.time = time;
		this.content = content;
		this.gid = gid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	
}
