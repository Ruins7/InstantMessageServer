package com.ece655.entity;

import java.io.Serializable;

public class Groups implements Serializable{
	
	private int gid;
	private String gname;
	
	public Groups() {
		super();
	}

	public Groups(int gid, String gname) {
		super();
		this.gid = gid;
		this.gname = gname;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
}
