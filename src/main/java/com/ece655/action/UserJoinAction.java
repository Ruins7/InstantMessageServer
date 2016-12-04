/**
 * 
 */
package com.ece655.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.ece655.entity.Message;
import com.ece655.entity.User;
import com.ece655.entity.UserJoin;
import com.ece655.service.MessageService;
import com.ece655.service.UserJoinService;
import com.ece655.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: UserJoinAction.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Ruins7
 * @version V1.0
 * @Date 2016年10月17日 下午2:08:22
 */
public class UserJoinAction extends ActionSupport {

	private List<User> users;
	private JSONArray jsonusers;
	private JSONArray jsonmesses;
	private UserJoinService userJoinService;
	private MessageService messageService;
	private UserService userService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUserJoinService(UserJoinService userJoinService) {
		this.userJoinService = userJoinService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@Action(value = "joingroup")
	public String joinGroup() throws IOException {
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
		UserJoin uj = new UserJoin();
		uj = (UserJoin) JSONObject.toBean(reqObject, UserJoin.class);
		Serializable ujid = userJoinService.join(uj);
		JSONArray jsonArray = new JSONArray();
		if (ujid != null) {
			// 查询该group的所有message
			Message mess = new Message();
			mess.setGid(uj.getGid());
			List<Message> messlist = messageService.findMessInOneGroup(mess);
			if (messlist != null) {
				jsonmesses = JSONArray.fromObject(messlist);
			} else {
				jsonmesses = JSONArray.fromObject(null);
			}
			// 查询该group的所有join的user
			UserJoin ujj = new UserJoin();
			ujj.setGid(uj.getGid());
			List<UserJoin> joinusers = userJoinService.searchJoinedGroups(ujj);
			// 对应查询每一个user
			if (joinusers != null) {
				users = new ArrayList<User>();
				for (UserJoin userJoin : joinusers) {
					User u = new User();
					u.setUid(userJoin.getUid());
					u = userService.findUserByConditions(u);
					users.add(u);
				}
				jsonusers = JSONArray.fromObject(users);
			} else {
				jsonusers = JSONArray.fromObject(null);
			}
			// json 封装 网络通讯
			jsonArray.add(jsonusers);
			jsonArray.add(jsonmesses);
			try {
				this.response.setCharacterEncoding("UTF-8");
				this.response.getWriter().write(jsonArray.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			// join group fail
			response.getWriter().write("failtojoin");
			return null;
		}
	}

	@Action(value = "quitgroup", results = { @Result(name = "success", type = "chain", location = "findallgroups") })
	public String quitGroup() throws IOException {
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
		UserJoin uj = new UserJoin();
		uj = (UserJoin) JSONObject.toBean(reqObject, UserJoin.class);
		userJoinService.quit(uj);
		return SUCCESS;
	}
}
