package com.open.blog.service;

import com.open.blog.entity.User;

public interface UserService {

	public User findUserByUserName(String username);
}
