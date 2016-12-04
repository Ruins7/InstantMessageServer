package com.ece655.service;

import java.io.Serializable;

import com.ece655.entity.User;

public interface UserService {
	
    public Serializable signup(User user); 
    
    public User login(User user);
    
    public User findUserByConditions(User user);

}
