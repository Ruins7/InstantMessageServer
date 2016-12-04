package com.ece655.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.ece655.entity.User;
import com.ece655.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private User loginuser;
	private HttpSession session;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private UserService userService;

	// set注入
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Action(value = "login", results = { @Result(name = "success", type = "chain", location = "findallgroups") })
	public String login() throws IOException {
		// 设置json格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		// 通过bufferreader获取json数据
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp = "";
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		// 将获取到的数据转换为JSONObject
		JSONObject reqObject = JSONObject.fromObject(sb.toString());
		// 将JSONObject转换为对象
		loginuser = new User();
		loginuser = (User) JSONObject.toBean(reqObject, User.class);
		// 调用service层
		loginuser = userService.login(loginuser);
		// 结果判断
		if (loginuser != null) {
			// 首次登陆获取session来保存该用户的信息
			session = request.getSession();
			session.setAttribute("username", loginuser.getUsername());
			session.setAttribute("userid", loginuser.getUid());
			// 下一步：查询所有groups return success 通过type = chain 继续访问findallgroups
			// action
			return SUCCESS;
		} else {
			// 返回到登录界面,返回值为empty
			response.getWriter().write("empty");
			return null;
		}
	}

	@Action("signup")
	public String signup() {
		User user = new User();
		Serializable uid = userService.signup(user);
		if (uid != null) {
			return SUCCESS;// 查询所有group
		} else {
			return ERROR;// 返回到登录界面
		}
	}

	@Action("logoff")
	public String logoff() {
		// TODO

		return SUCCESS;
	}

}
