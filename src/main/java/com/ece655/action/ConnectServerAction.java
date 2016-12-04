package com.ece655.action;

import java.io.IOException;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

public class ConnectServerAction extends ActionSupport{
	
	@Action(value = "connserver")
	public String connTest() throws IOException {
		return null;
	}
}
