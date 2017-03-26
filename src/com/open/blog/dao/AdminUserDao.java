package com.open.blog.dao;

import java.util.List;

import com.open.blog.entity.AdminUser;

public interface AdminUserDao {

	public List<AdminUser> findUserByRoleId(int id) throws Exception;
	
	public List<AdminUser> findAdminUser() throws Exception;
	
	public void adminStateUpdate(String state, int id) throws Exception;
	
	public AdminUser findAdminUserByUsername(String username) throws Exception;
	
	public AdminUser findAdminUserByUserId(int id) throws Exception;
	
	public void updateAdminUserById(AdminUser adminUser) throws Exception;
	
	public void addAdminUser(AdminUser adminUser) throws Exception;
}
