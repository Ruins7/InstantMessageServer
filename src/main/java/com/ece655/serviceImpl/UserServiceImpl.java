package com.ece655.serviceImpl;

import java.io.Serializable;

import com.ece655.dao.UserDao;
import com.ece655.entity.User;
import com.ece655.service.UserService;

public class UserServiceImpl implements UserService {
	
	//所有service实现类都注入通用baseDao,但是对应的实体不同
    private UserDao userDao;
    
    //set注入
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Serializable signup(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public User login(User user) {
		return userDao.findbyConditions(user);
	}

	@Override
	public User findUserByConditions(User user) {
		 
		return userDao.findbyConditions(user);
	}

}
