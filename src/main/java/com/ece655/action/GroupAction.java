/**
 * 
 */
package com.ece655.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.ece655.entity.Groups;
import com.ece655.entity.Message;
import com.ece655.entity.User;
import com.ece655.entity.UserJoin;
import com.ece655.service.GroupService;
import com.ece655.service.MessageService;
import com.ece655.service.UserJoinService;
import com.ece655.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: GroupAction.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Ruins7
 * @version V1.0
 * @Date 2016年10月17日 下午1:48:40
 */
public class GroupAction extends ActionSupport {

	private HttpSession session;
	private User user;
	private List<User> users;
	private ArrayList<Groups> joinedgroups;
	private JSONArray jsonusers;
	private JSONArray jsonmesses;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private GroupService groupService;
	private UserJoinService userJoinService;
	private MessageService messageService;
	private UserService userService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setUserJoinService(UserJoinService userJoinService) {
		this.userJoinService = userJoinService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Action(value = "findallgroups")
	public String findAllGroups() {
		session = request.getSession();
		user = new User();
		user.setUsername((String) session.getAttribute("username"));
		user.setUid((int) session.getAttribute("userid"));
		// 查询所有group
		List<Groups> groupslist = groupService.findAllGroups();
		if (groupslist != null) {
			// 查询当前登录用户join的groups
			UserJoin uj = new UserJoin();
			uj.setUid(user.getUid());
			List<UserJoin> ujlist = userJoinService.searchJoinedGroups(uj);
			if (ujlist != null) {
				// 加入的组不为null
				joinedgroups = new ArrayList<Groups>();
				for (UserJoin ujj : ujlist) {
					Groups g = new Groups();
					g.setGid(ujj.getGid());
					joinedgroups.add(groupService.findAGroup(g));
				}
				// json 封装 网络通讯
				JSONArray jsonArray = new JSONArray();
				JSONObject jsonuser = JSONObject.fromObject(user);
				JSONArray jsonallgroups = new JSONArray();
				jsonallgroups.add(groupslist);
				JSONArray jsonjoinedgroups = new JSONArray();
				jsonjoinedgroups.add(joinedgroups);
				jsonArray.add(jsonuser);
				jsonArray.add(jsonallgroups);
				jsonArray.add(jsonjoinedgroups);
				try {
					this.response.setCharacterEncoding("UTF-8");
					this.response.getWriter().write(jsonArray.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				// 加入的组为null
				try {
					this.response.getWriter().write("joinedgroupemtpy");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		} else {
			// 没有groups
			try {
				this.response.getWriter().write("groupemtpy");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	@Action(value = "findagroup")
	public String findAgroup() throws IOException {
		// Json 解析
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
		User user = new User();
		user = (User) JSONObject.toBean(reqObject, User.class);
		String gid = reqObject.getString("gid");
		JSONArray jsonArray = new JSONArray();
		// 查询该group的所有message
		Message mess = new Message();
		mess.setGid(Integer.valueOf(gid));
		List<Message> messlist = messageService.findMessInOneGroup(mess);
		if (messlist != null) {
			jsonmesses = JSONArray.fromObject(messlist);
		} else {
			jsonmesses = JSONArray.fromObject(null);
		}
		// 查询该group的所有join的user
		UserJoin ujj = new UserJoin();
		ujj.setGid(Integer.valueOf(gid));
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
	}
}
