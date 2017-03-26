package com.open.blog.service;

import java.util.List;

import com.open.blog.entity.Role;

public interface RoleService {
	
	public List<Role> findRole() throws Exception;
	
	public List<Role> findRoleUser() throws Exception;
}
