/**
 * 
 */
package com.ece655.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.ece655.entity.Message;
import com.ece655.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName:     MessageAction.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         Ruins7
 * @version        V1.0  
 * @Date           2016年10月17日 下午2:37:22 
 */
public class MessageAction extends ActionSupport{

	private MessageService messageService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@Action(value = "sendmess")
	public String sendMessage() throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp = "";
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		
		JSONObject reqObject = JSONObject.fromObject(sb.toString());
		Message mess = new Message();
		mess = (Message) JSONObject.toBean(reqObject, Message.class);
		Serializable mid = messageService.send(mess);
		this.response.setCharacterEncoding("UTF-8");
		if(mid != null){
			this.response.getWriter().write("sendsuccess");
			return null;
		}else{
			this.response.getWriter().write("sendfail");
			return null;
		}
	}

}
