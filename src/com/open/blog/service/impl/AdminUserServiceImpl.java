package com.open.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.open.blog.dao.AdminUserDao;
import com.open.blog.dao.RoleDao;
import com.open.blog.entity.AdminUser;
import com.open.blog.entity.Role;
import com.open.blog.service.AdminUserService;

@Repository(value = "AdminUserService")
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	AdminUserDao adminUserDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<AdminUser> findAdminUser() throws Exception {
		// TODO Auto-generated method stub
		List<AdminUser> adminUsers = adminUserDao.findAdminUser();
		if(adminUsers != null && adminUsers.size() > 0) {
			for(AdminUser adminUser : adminUsers) {
				List<Role> roles = roleDao.findRoleByUserId(adminUser.getUid());
				adminUser.setRoles(roles);
			}
		}
		return adminUsers;
	}

	@Override
	public void adminStateUpdate(String state, int id) throws Exception {
		// TODO Auto-generated method stub
		adminUserDao.adminStateUpdate(state, id);
	}

	@Override
	public AdminUser findAdminUserByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		AdminUser adminUser = adminUserDao.findAdminUserByUsername(username);
		if(adminUser == null){
			return adminUser;
		}
		List<Role> roles = roleDao.findRoleByUserId(adminUser.getUid());
		if(roles != null && roles.size() > 0) {
			adminUser.setRoles(roles);
			adminUser.setRole(roles.get(0));
		}
		return adminUser;
	}

	@Override
	public AdminUser findAdminUserByUserId(int id) throws Exception {
		// TODO Auto-generated method stub
		return adminUserDao.findAdminUserByUserId(id);
	}

	@Override
	public void updateAdminUserById(AdminUser adminUser) throws Exception {
		// TODO Auto-generated method stub
		adminUserDao.updateAdminUserById(adminUser);
	}

	@Override
	public void addAdminUser(AdminUser adminUser) throws Exception {
		// TODO Auto-generated method stub
		adminUserDao.addAdminUser(adminUser);
	}

}
