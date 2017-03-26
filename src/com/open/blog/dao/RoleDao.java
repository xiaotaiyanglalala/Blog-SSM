package com.open.blog.dao;

import java.util.List;

import com.open.blog.entity.Role;

public interface RoleDao {

	public List<Role> findRole();
	
	public List<Role> findRoleByUserId(int id) throws Exception;
	
	public void updateRoleByUserId(int id) throws Exception;
}
