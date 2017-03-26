package com.open.blog.dao;

import com.open.blog.entity.User;

public interface UserDao {
	
	public User findUserByUserName(String username);
}
